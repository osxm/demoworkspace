/**
 * @Title: AuthenticationFilter.java
 * @Package cn.osxm.springboot.com
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月8日
 * @version V1.0
 */
package cn.osxm.springboot.com.auth;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: AuthenticationFilter
 * @Description: TODO
 * @author oscarchen
 */
//@Component
//@WebFilter(urlPatterns = "/**", filterName = "authenFilter")
public class AuthenticationFilter implements Filter {

	// 排除的url
	private static final String[] excludePathPatterns = { "/login" };

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// 获取请求url地址，不拦截excludePathPatterns中的url
		String url = req.getRequestURI();
		if (Arrays.asList(excludePathPatterns).contains(url)) {
			// 放行，相当于第一种方法中LoginInterceptor返回值为true
			chain.doFilter(request, response);
		} else {
			System.out.println("开始拦截了................");
			// 业务代码
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}