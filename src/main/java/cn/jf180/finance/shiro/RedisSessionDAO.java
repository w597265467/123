//package cn.jf180.finance.shiro;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.UnknownSessionException;
//import org.apache.shiro.session.mgt.SimpleSession;
//import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.UUID;
//
///**
//
// * @author Administrator
//
// * @create 2018-03-26 11:44
//
// * @desc RedisSessionDAO
//
// **/
//@Component
//public class RedisSessionDAO extends AbstractSessionDAO {
//
//	@Autowired
//	private  RedisManager redisManager;
//
//	@Autowired
//	public JdkSerializationRedisSerializer serializer;
//
//	@Resource(name = "redisTemplate")
//	private RedisTemplate redisTemplate;
//
//	@Override
//	protected Serializable doCreate(Session session) {
//		Serializable id = session.getId();
//		if (id == null) {
//			id = UUID.randomUUID().toString();
//		}
//		SimpleSession simpleSession = null;
//		if (session instanceof SimpleSession) {
//			simpleSession = (SimpleSession) session;
//			simpleSession.setId(id);
//		} else {
//			throw new RuntimeException("session类型错误");
//		}
//		assignSessionId(session, id);
//		redisManager.set((String) id,simpleSession);
//		return id;
//	}
//
//	@Override
//	protected Session doReadSession(Serializable sessionId) {
//		if (sessionId == null) {
//			return null;
//		}
//		redisManager.get((String) sessionId);
//		return redisManager.get((String) sessionId);
//	}
//
//	@Override
//	public void update(Session session) throws UnknownSessionException {
//		Serializable id = session.getId();
//		SimpleSession simpleSession = null;
//		if (session instanceof SimpleSession) {
//			simpleSession = (SimpleSession) session;
//			simpleSession.setId(id);
//		} else {
//			throw new RuntimeException("session类型错误");
//		}
//		redisManager.set((String) id,simpleSession);
//	}
//
//	@Override
//	public void delete(Session session) {
//		redisTemplate.delete(session.getId().toString());
//	}
//
//	@Override
//	public Collection<Session> getActiveSessions() {
//		return redisTemplate.keys("*");
//	}
//
//}
