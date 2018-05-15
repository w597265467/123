package cn.jf180.finance.interceptor;

import cn.jf180.finance.em.FinCreditActionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class UrlInterceptor extends BaseInterceptor {
	@Override
	public List<String> addPathPatterns() {
		List<String> list = new ArrayList<String>();
		list.add("/**");
		return list;
	}

	@Override
	public List<String> excludePathPatterns() {
		return new ArrayList<String>();
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		for (FinCreditActionEnum actionEnum : FinCreditActionEnum.values()) {
			if (actionEnum.action.equals(uri)){
				String replace = url.toString().replace("localhost:6060", "localhost:7308").replace("127.0.0.1:6060","127.0.0.1:7308");
				response.sendRedirect(replace);
			}
		}
		StringBuffer requestURL = url;
		String replace = requestURL.toString().replace("localhost:6060", "test.jf180.cn").replace("127.0.0.1:6060","test.jf180.cn");
		response.sendRedirect(replace);

		return true;
	}
}
