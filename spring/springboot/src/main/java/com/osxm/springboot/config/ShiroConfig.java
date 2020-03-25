/**
 * @Title: ShiroConfig.java
 * @Package com.osxm.springboot.config
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月7日
 * @version V1.0
 */
package com.osxm.springboot.config;

import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.osxm.springboot.shiro.ShiroRealm;

/**
 * @ClassName: ShiroConfig
 * @Description: TODO
 * @author oscarchen
 */
@Configuration
public class ShiroConfig {

	@Bean
	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
		DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
		chainDefinition.addPathDefinition("/users/**", "authc");
		return chainDefinition;
	}

	@Bean
	public ShiroRealm realm() {
		ShiroRealm shiroRealm = new ShiroRealm();
		return shiroRealm;
	}

	@Bean("securityManager")
	public DefaultWebSecurityManager getManager(ShiroRealm realm) {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(realm);
		return manager;
	}
}
