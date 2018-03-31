package cn.jf180.finance.shiro;

import org.apache.catalina.connector.RequestFacade;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.lang.reflect.Field;

/**

 * @author Administrator

 * @create 2018-03-26 11:44

 * @desc MySessionManager

 **/
public class MySessionManager extends DefaultWebSessionManager {

	public static void main(String[] arg) {
//		boolean anyEmpty = StringUtils.isNotEmpty("1", "1", "1");
//		System.out.println(!anyEmpty);
	}


	@Override
	public Session start(SessionContext sessionContext) {

		return super.start(sessionContext);
	}

	@Override
	public Session getSession(SessionKey sessionKey) throws SessionException {
//		HttpServletSession;
		Serializable sessionId = sessionKey.getSessionId();
		if (sessionId!=null){
			return sessionDAO.readSession(sessionId);
		}
		Session session = null;
		if (sessionKey != null) {
			if (sessionKey instanceof WebSessionKey) {
				WebSessionKey wsk = (WebSessionKey) sessionKey;
				ServletRequest servletRequest = wsk.getServletRequest();
				if (servletRequest instanceof ShiroHttpServletRequest) {
					ShiroHttpServletRequest shs = (ShiroHttpServletRequest) servletRequest;
					Class<? extends ShiroHttpServletRequest> shsClass = shs.getClass();
					Class<?> superclass = shsClass.getSuperclass().getSuperclass();
					String id = null;
					if (superclass == ServletRequestWrapper.class) {
						try {
							Field request = superclass.getDeclaredField("request");
							request.setAccessible(true);
							RequestFacade req = (RequestFacade) request.get(shs);
							id = req.getSession().getId();
							System.out.println(id);
						} catch (Exception e) {

						}
					}
					return sessionDAO.readSession(id);
				}
//				session = sessionDAO.readSession(wsk.getServletRequest());
			}
		}
		return session;
	}

	@Override
	public boolean isServletContainerSessions() {
		return false;
	}
}
