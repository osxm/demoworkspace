/**
 * 
 */
package cn.osxm.springboot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xuemi
 *
 */
@Controller
public class FileUploadController {

	@GetMapping("/upload_page")
	public String uploadPage() {
		return "upload_page";
	}

	@ResponseBody
	@PostMapping("/do_upload")
	public Map<String, String> doUpload(@RequestParam(name = "myfile") MultipartFile file) {
		Map<String, String> rtn = new HashMap<String, String>();
		String sTargetClassPath = null;
		try {
			// 1. 获取或创建文件上传目录 ， 这里放置再项目构建后的目录 target的子目录upload下面
			sTargetClassPath = ResourceUtils.getURL("classpath:").getPath(); // xxxx/target/classes/
			File rootFolder = new File(sTargetClassPath);
			File uploadFolder = new File(rootFolder.getAbsolutePath(), "../upload/");
			if (!uploadFolder.exists()) {
				uploadFolder.mkdirs();
			}
			String fullFileName = file.getOriginalFilename();
			String fileName = StringUtils.cleanPath(fullFileName);

			String targetFullFilePath = uploadFolder.getAbsolutePath() + "/" + fileName;
			File targetFile = new File(targetFullFilePath);
			if (!targetFile.exists()) {
				targetFile.createNewFile();
			}
			InputStream in = file.getInputStream();
			FileOutputStream out = new FileOutputStream(targetFile);
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
		rtn.put("success", "true");
		return rtn;
	}

}
