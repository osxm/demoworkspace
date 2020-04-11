/**
 * @Title: MvcInterceptorConfig.java
 * @Package cn.osxm.springboot.config
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月8日
 * @version V1.0
 */
package cn.osxm.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import cn.osxm.springboot.com.auth.AuthenticationInterceptor;

/**
  * @ClassName: MvcInterceptorConfig
  * @Description: TODO
  * @author oscarchen
  */
@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport{

	@Autowired
    private AuthenticationInterceptor loginInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns ,拦截路径/**表示拦截所有请求
        // excludePathPatterns 不需要拦截的路径
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
        .excludePathPatterns("/login","/account/register");    
        super.addInterceptors(registry);
    }

}