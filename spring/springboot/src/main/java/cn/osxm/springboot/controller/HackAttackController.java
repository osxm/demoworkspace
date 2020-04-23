/**
 * @Title: HackAttackController.java
 * @Package cn.osxm.springboot.controller
 * @Description: 
 * listUnSafe() 演示SQL注入风险。
 * @author oscarchen
 * @date 2020/04/08
 * @version V1.0
 */
package cn.osxm.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.osxm.springboot.entity.Usr;
import cn.osxm.springboot.service.UsrService;

/**
 * @ClassName: HackAttackController
 * @Description: TODO
 * @author oscarchen
 */
@Controller
@RequestMapping("/hack")
public class HackAttackController {

	@Autowired
	private UsrService service;

	/**
	 * http://localhost:8080/hack/list-users-safe?id=1 or id!=1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("list-users-safe")
	public List<Usr> listSafe(String id) {
		return service.listSafe(id);
	}

	/**
	 * http://localhost:8080/hack/list-users-unsafe?id=1 or id!=1
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("list-users-unsafe")
	public List<Usr> listUnSafe(String id) {
		return service.listUnSafe(id);
	}

	@GetMapping("/stroedxss")
	public String stroedXss(ModelMap map) {

		map.addAttribute("usr", service.get(1));
		return "storedxss";
	}

	@RequestMapping("/save-user")
	public String saveUser(Integer id, String name, ModelMap map) {
		service.saveUser(id, name);
		map.addAttribute("usr", service.get(1));
		return "storedxss";
	}
}
