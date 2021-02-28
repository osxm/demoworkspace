/**
 * @Title: CkEditorController.java
 * @Package cn.osxm.springboot.controller
 * @Description: TODO
 * @author oscarchen
 * @date 2021年1月23日
 * @version V1.0
 */
package cn.osxm.springboot.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.osxm.springboot.model.CkEditorUploadResp;


/**
  * @ClassName: CkEditorController
  * @Description: TODO
  * @author oscarchen
  */
@Controller
@RequestMapping("/ckeditor")
public class CkEditorController {

	@GetMapping("/page")
	public String ckeditorPage() {
		return "ckeditor";
	}
	
	
	@RequestMapping("/uploadimage")
	@ResponseBody
	public CkEditorUploadResp uploadImage(@RequestParam(name = "upload")MultipartFile file) {
		CkEditorUploadResp  resp = new CkEditorUploadResp();
		String fullFileName = file.getOriginalFilename();
		String fileExtension = StringUtils.unqualify(fullFileName);
		//String fileExtension = StringUtils.stripFilenameExtension(fullFileName);
		//String sfileDestPath = "D:\\filesys"; //如果没找到static/uploadimages
		String sfileDestPath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "static"+File.separator+"uploadimages";
		File destFolder = new File(sfileDestPath);
		if(!destFolder.exists()) {
			destFolder.mkdir();
		}
		String uuid = UUID.randomUUID().toString();
		String destFullFileName = uuid+"."+fileExtension;
		String destFilePath = sfileDestPath + File.separator+destFullFileName;
		File descFile = new File(destFilePath);
		try {
			if (!descFile.exists()) {				
					descFile.createNewFile();
			}
			InputStream in = file.getInputStream();
			FileOutputStream out = new FileOutputStream(descFile);
			int n = 0;
			byte[] b = new byte[1024];
			while ((n = in.read(b)) != -1) {
				out.write(b, 0, n);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			File destFolder = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/uploadimages");
			sfileDestPath = destFolder.getAbsolutePath();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		/*Path fileDestPath = Paths.get(sfileDestPath).toAbsolutePath().normalize();
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
		}*/
		resp.setUploaded(true);
		resp.setUrl("http://localhost:8080/static/uploadimages/"+destFullFileName);
		return resp;
		
	}
	
}
