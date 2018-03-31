package cn.jf180.finance.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

/**

 * @author Administrator

 * @create 2018-03-26 11:34

 * @desc MyShiroRealm

 **/
public class MyShiroRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();
		authorizationInfo.addRole("admin");
		authorizationInfo.addStringPermission("seeImg");
		return authorizationInfo;
	}

	/*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
//        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
		//获取用户的输入的账号.
		String username = (String) token.getPrincipal();
		Object credentials = token.getCredentials();
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				username, //用户名
				"B38E2BF274239FF5DD2B45EE9AE099C9", //密码
				new SimpleByteSource("1234"),//salt=username+salt
				getName()  //realm name
		);
		return authenticationInfo;
	}

}
