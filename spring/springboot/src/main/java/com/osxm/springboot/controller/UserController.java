/**
 * @Title: UserController.java
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

import com.osxm.springboot.service.UserService;

/**
  * @ClassName: UserController
  * @Description: TODO
  * @author oscarchen
  */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String list(ModelMap map) {
        map.addAttribute("users", userService.list());
        return "user";
    }
}
