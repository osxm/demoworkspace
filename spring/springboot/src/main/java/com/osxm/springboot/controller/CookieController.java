/**
 * @Title: CookieController.java
 * @Package com.osxm.springboot.controller
 * @Description: TODO
 * @author oscarchen
 * @date 2020年1月4日
 * @version V1.0
 */
package com.osxm.springboot.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
  * @ClassName: CookieController
  * @Description: TODO
  * @author oscarchen
  */
@RestController
public class CookieController {

	@RequestMapping("/newcookie")
	public String newCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("token", "this_is_jwt_cookie_test");
		response.addCookie(cookie);
		return "Add New Cookie Test";
	}

	@RequestMapping("/getcookie")
	public String getcookie(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				sb.append(cookie.getName());
				sb.append("=");
				sb.append(cookie.getValue());
				sb.append("<br>");
			}
		}
		return sb.toString();
	}
}
