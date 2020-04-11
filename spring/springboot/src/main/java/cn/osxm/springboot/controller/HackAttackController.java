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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.osxm.springboot.entity.Usr;
import cn.osxm.springboot.service.UsrService;

/**
  * @ClassName: HackAttackController
  * @Description: TODO
  * @author oscarchen
  */
@RestController
@RequestMapping("/hack")
public class HackAttackController {
	
	@Autowired
	private UsrService service;

	@RequestMapping("list-users-safe")
	public List<Usr> listSafe(String id){
		return service.listSafe(id);
	}
	
	@RequestMapping("list-users-unsafe")
	public List<Usr> listUnSafe(String id){
		return service.listUnSafe(id);
	}
}
