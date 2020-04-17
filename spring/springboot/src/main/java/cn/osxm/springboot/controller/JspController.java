/**
 * @Title: JspController.java
 * @Package cn.osxm.springboot.controller
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月14日
 * @version V1.0
 */
package cn.osxm.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: JspController
 * @Description: TODO
 * @author oscarchen
 */
@Controller
public class JspController {

	@GetMapping("/myjsp")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "Hello, This is JSP.");
		mv.setViewName("myjsp");
		return mv;
	}
}
