/**
 * @Title: HomeController.java
 * @Package com.osxm.springboot.controller
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月7日
 * @version V1.0
 */
package com.osxm.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.osxm.springboot.entity.User;
import com.osxm.springboot.service.HomeService;

/**
 * @ClassName: HomeController
 * @Description: TODO
 * @author oscarchen
 */
@Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	@RequestMapping("/index")
	public String index(ModelMap map) {
		map.addAttribute("msg", "This is Index Page.");
		return "index";
	}

	@GetMapping("/login")
	public String toLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String login(ModelMap map, User user) {
		String errMsg = homeService.login(user.getUserId(), user.getPassword());
		if (errMsg != null) {
			return "login";
		} else {
			return "index";
		}
	}

	@RequestMapping("/logout")
	public String logout() {
		homeService.logout();
		return "login";
	}
}
