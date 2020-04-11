/**
 * @Title: UsrController.java
 * @Package cn.osxm.h2springboot.controller
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月10日
 * @version V1.0
 */
package cn.osxm.h2springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.osxm.h2springboot.entity.Usr;
import cn.osxm.h2springboot.service.UsrService;

/**
  * @ClassName: UsrController
  * @Description: TODO
  * @author oscarchen
  */
@RestController
public class UsrController {

	@Autowired
	private UsrService service;
	
	@GetMapping("/users")
	public List<Usr> list(){
		return service.list();
	}
}
