/**
 * @Title: AuthenticationInterceptor.java
 * @Package cn.osxm.springboot.com
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月8日
 * @version V1.0
 */
package cn.osxm.springboot.com.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: AuthenticationInterceptor
 * @Description: TODO
 * @author oscarchen
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
	/**
	 * 预处理回调方法. 返回值： true继续；false 中断
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("开始拦截.........");
		// 业务代码
		return true;
	}

	/**
	 * 后处理回调方法
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * 类似于try-catch-finally中的finally
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}