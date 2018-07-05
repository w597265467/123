//package cn.jf180.finance.interceptor;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
//
//	@Value("${spring.profiles.active}")
//	public String profiles;
//
//	@Resource
//	private UrlInterceptor urlInterceptor;
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		// 多个拦截器组成一个拦截器链
//		// addPathPatterns 用于添加拦截规则
//		// excludePathPatterns 用户排除拦截
//		addBaseInterceptor(registry, urlInterceptor);
//		super.addInterceptors(registry);
//	}
//
//	public void addBaseInterceptor(InterceptorRegistry registry, BaseInterceptor interceptor) {
//		InterceptorRegistration tion = registry.addInterceptor(interceptor);
//		List<String> aaList = interceptor.addPathPatterns();
//		List<String> bbList = interceptor.excludePathPatterns();
//		if (aaList != null && !aaList.isEmpty()) {
//			for (String aa : aaList) {
//				tion.addPathPatterns(aa);
//			}
//		}
//		if (bbList != null && !bbList.isEmpty()) {
//			for (String bb : bbList) {
//				tion.excludePathPatterns(bb);
//			}
//		}
//	}
//
//}