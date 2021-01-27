/**
 * @Title: JsonController.java
 * @Package cn.osxm.springboot.rest
 * @Description: TODO
 * @author oscarchen
 * @date 2020��3��26��
 * @version V1.0
 */
package cn.osxm.springboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.osxm.springboot.model.Animal;

/**
 * @ClassName: JsonController
 * @Description: TODO
 * @author oscarchen
 */
@RestController
@RequestMapping(value = "/restjson")
public class JsonController {

	@GetMapping(value = "/str2bool")
	public Animal str2bool() {
		Animal tiger = new Animal();
		tiger.setName("Tiger");
		tiger.setExtinct("false");
		return tiger;
	}
	


}
