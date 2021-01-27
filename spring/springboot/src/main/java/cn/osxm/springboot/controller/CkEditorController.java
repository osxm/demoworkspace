/**
 * @Title: CkEditorController.java
 * @Package cn.osxm.springboot.controller
 * @Description: TODO
 * @author oscarchen
 * @date 2021年1月23日
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.osxm.springboot.model.CkEditorUploadResp;


/**
  * @ClassName: CkEditorController
  * @Description: TODO
  * @author oscarchen
  */
@RestController
@RequestMapping("/ckeditor")
public class CkEditorController {

	@RequestMapping("/uploadimage")
	public CkEditorUploadResp uploadImage(@RequestParam(name = "upload")MultipartFile file) {
		CkEditorUploadResp  resp = new CkEditorUploadResp();
		String fullFileName = file.getOriginalFilename();
		String fileName = StringUtils.cleanPath(fullFileName);
		String fileExtension = StringUtils.unqualify(fullFileName);
		//String fileExtension = StringUtils.stripFilenameExtension(fullFileName);
		String sfileDestPath = "D:\\filesys";
		Path fileDestPath = Paths.get(sfileDestPath).toAbsolutePath().normalize();
		if(!fileDestPath.toFile().exists()) {
			fileDestPath.toFile().mkdirs();
		}
		String uuid = UUID.randomUUID().toString();
		String targetFileName = uuid+"."+fileExtension;
		Path targetPath = fileDestPath.resolve(targetFileName);
		
		try {
			Files.copy(file.getInputStream(), targetPath,StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setUploaded(true);
		resp.setUrl("11");
		return resp;
		
	}
	
}
