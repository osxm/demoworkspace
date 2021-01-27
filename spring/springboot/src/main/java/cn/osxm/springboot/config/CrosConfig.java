/**
 * @Title: CrosConfig.java
 * @Package cn.osxm.springboot.config
 * @Description: TODO
 * @author oscarchen
 * @date 2021年1月24日
 * @version V1.0
 */
package cn.osxm.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName: CrosConfig
 * @Description: TODO
 * @author oscarchen
 */
@Configuration
public class CrosConfig extends WebMvcConfigurationSupport {

	static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods(ORIGINS).maxAge(3600);
	}
}
