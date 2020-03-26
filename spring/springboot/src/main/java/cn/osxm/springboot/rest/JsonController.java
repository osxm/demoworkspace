/**
 * @Title: JsonController.java
 * @Package cn.osxm.springboot.rest
 * @Description: TODO
 * @author oscarchen
 * @date 2020Äê3ÔÂ26ÈÕ
 * @version V1.0
 */
package cn.osxm.springboot.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.osxm.springboot.model.Animal;

/**
 * @ClassName: JsonController
 * @Description: TODO
 * @author oscarchen
 */
@RestController
@RequestMapping(value = "/rest")
public class JsonController {

	@GetMapping(value = "/str2bool")
	public Animal str2bool() {
		Animal tiger = new Animal();
		tiger.setName("Tiger");
		tiger.setExtinct("false");
		return tiger;
	}

}
