/**
 * @Title: ToolController.java
 * @Package com.osxm.springboot.controller
 * @Description: TODO
 * @author oscarchen
 * @date 2020年12月9日
 * @version V1.0
 */
package cn.osxm.h2springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.osxm.h2springboot.util.GraphicVcodeUtil;

/**
 * @ClassName: ToolController
 * @Description: TODO
 * @author oscarchen
 */
@Controller
@RequestMapping("/tool")
public class ToolController {
	/**
	 * 生成验证码
	 */
	@RequestMapping(value = "/getGraphicVcode")
	public void getVerify(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
			response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expire", 0);
			GraphicVcodeUtil randomValidateCode = new GraphicVcodeUtil();
			randomValidateCode.writeRandcode(request, response);// 输出验证码图片
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
