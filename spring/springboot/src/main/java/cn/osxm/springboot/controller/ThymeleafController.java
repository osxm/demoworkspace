/**
 * @Title: ThymeleafController.java
 * @Package cn.osxm.springboot.controller
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月14日
 * @version V1.0
 */
package cn.osxm.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
  * @ClassName: ThymeleafController
  * @Description: TODO
  * @author oscarchen
  */
@Controller
public class ThymeleafController {

	@GetMapping("/thymeleaf")
	public String list(ModelMap map) {
		map.addAttribute("msg", "Hello,Thymeleaf Page.");
		return "thymeleaf";
	}
}
