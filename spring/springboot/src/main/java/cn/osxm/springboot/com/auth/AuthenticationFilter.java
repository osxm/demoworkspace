/**
 * @Title: AuthenticationFilter.java
 * @Package cn.osxm.springboot.com
 * @Description: TODO
 * @author oscarchen
 * @date 2020��4��8��
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

	// 
	private static final String[] excludePathPatterns = { "/login" };

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// 
		String url = req.getRequestURI();
		if (Arrays.asList(excludePathPatterns).contains(url)) {
			// 
			chain.doFilter(request, response);
		} else {
			//System.out.println("");
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}