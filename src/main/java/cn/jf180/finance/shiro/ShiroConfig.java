package cn.jf180.finance.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;

/**

 * @author Administrator

 * @create 2018-03-26 11:26

 * @desc ShiroConfig

 **/
@Configuration
public class ShiroConfig {


	public static void main(String[] arg) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] bytes = md.digest("1234123456".getBytes("utf-8"));
		final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
		StringBuilder ret = new StringBuilder(bytes.length * 2);
		for (int i=0; i<bytes.length; i++) {
			ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
			ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
		}
		String s = new String(ret);
		System.out.println(s);

		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(-1);//散列的次数，比如散列两次，相当于 md5(md5(""));
		MyShiroRealm realm = new MyShiroRealm();
		UsernamePasswordToken token=new UsernamePasswordToken("123","123456");
		AuthenticationInfo authenticationInfo = realm.doGetAuthenticationInfo(token);

		boolean b = hashedCredentialsMatcher.doCredentialsMatch(token, authenticationInfo);
		System.out.println(b);

	}

	@Bean(name = "redisTemplate")
	public RedisTemplate<Serializable, Serializable> redisTemplate() {
		String host = "127.0.0.1";
		int port = 6379;
		redis.clients.jedis.JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(200);
		poolConfig.setMaxIdle(10);
		poolConfig.setMinIdle(1);
		poolConfig.setMaxWaitMillis(30000);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		poolConfig.setTestWhileIdle(true);
		JedisConnectionFactory connectFactory = new JedisConnectionFactory();
		connectFactory.setUsePool(true);
		connectFactory.setHostName(host);
		connectFactory.setPort(port);
		connectFactory.setDatabase(0);
		connectFactory.setPoolConfig(poolConfig);
		connectFactory.afterPropertiesSet();
		RedisTemplate<Serializable, Serializable> bean = new RedisTemplate<Serializable, Serializable>();
		bean.setConnectionFactory(connectFactory);
		bean.setKeySerializer(new StringRedisSerializer());
		bean.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		bean.setHashKeySerializer(new StringRedisSerializer());
		bean.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
		return bean;
	}

	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		//注意过滤器配置顺序 不能颠倒
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
		filterChainDefinitionMap.put("/logout", "logout");
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/add/redis", "anon");
		filterChainDefinitionMap.put("/ajaxLogin", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/**", "authc");
		//配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
		shiroFilterFactoryBean.setLoginUrl("/unauth");
		// 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/index");
		//未授权界面;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 凭证匹配器
	 * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 * ）
	 *
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(-1);//散列的次数，比如散列两次，相当于 md5(md5(""));
		return hashedCredentialsMatcher;
	}

	@Bean
	public MyShiroRealm myShiroRealm() {
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		// 自定义session管理 使用redis
		securityManager.setSessionManager(sessionManager());
		// 自定义缓存实现 使用redis
//		securityManager.setCacheManager(cacheManager());
		return securityManager;
	}

	//自定义sessionManager
	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager mySessionManager = new DefaultWebSessionManager();
		mySessionManager.setSessionDAO(redisSessionDAO());
//		SessionDAO sessionDAO = mySessionManager.getSessionDAO();
//		System.out.println(sessionDAO);
		return mySessionManager;
	}

	@Bean
	public JdkSerializationRedisSerializer serializationRedisSerializer(){
		return new JdkSerializationRedisSerializer();
	}


//	@Bean
//	public RedisCacheManager cacheManager() {
//		RedisCacheManager redisCacheManager = new RedisCacheManager();
//		redisCacheManager.setRedisManager(redisManager());
//		return redisCacheManager;
//	}

//	@Bean
//	public RedisSentinelConfiguration redisSentinelConfiguration(){
//		RedisSentinelConfiguration config = new RedisSentinelConfiguration;
//		return config;
//	}

	@Bean
	public RedisSessionDAO redisSessionDAO() {
		RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
		return redisSessionDAO;
	}

	/**
	 * 开启shiro aop注解支持.
	 * 使用代理方式;所以需要开启代码支持;
	 *
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

}