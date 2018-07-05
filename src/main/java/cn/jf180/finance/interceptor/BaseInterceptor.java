package cn.jf180.finance.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BaseInterceptor implements HandlerInterceptor {

	@Resource(name = "redisTemplate")
	public ValueOperations<String, Object> valueOps;

	public abstract List<String> addPathPatterns();

	public abstract List<String> excludePathPatterns();


	public String cookieVal(HttpServletRequest request,String cookieKey) {
		try {
			Cookie cookie = getCookie(request, cookieKey);
			if (cookie != null) {
				return cookie.getValue();
			}
		} catch (Exception e) {
		}
		return null;
	}


	private Cookie getCookie(HttpServletRequest request, String key) {
		if (key == null) {
			return null;
		}
		Cookie[] cookies = request.getCookies();
		int curVer = -1;
		Cookie res = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (key.equals(cookie.getName())) {
					if (cookie.getVersion() > curVer) {
						curVer = cookie.getVersion();
						res = cookie;
					}
				}
			}
		}
		return res;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub

	}

	public String ip(HttpServletRequest request) {
		// 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
		try {
			String ip = request.getHeader("X-Forwarded-For");
			if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
				if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
					ip = request.getHeader("x-real-ip");
				}
				if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
					ip = request.getHeader("Proxy-Client-IP");
				}
				if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
					ip = request.getHeader("WL-Proxy-Client-IP");
				}
				if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
					ip = request.getHeader("HTTP_CLIENT_IP");
				}
				if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
					ip = request.getHeader("HTTP_X_FORWARDED_FOR");
				}
				if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
					ip = request.getRemoteAddr();
				}
			} else if (ip.length() > 15) {
				String[] ips = ip.split(",");
				for (int i = 0; i < ips.length; i++) {
					String strIp = ips[i];
					if (!"unknown".equalsIgnoreCase(strIp)) {
						ip = strIp;
						break;
					}
				}
			}
			return ip;
		} catch (Exception e) {

		}
		return "";
	}


}
