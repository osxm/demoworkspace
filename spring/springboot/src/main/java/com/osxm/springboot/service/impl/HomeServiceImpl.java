/**
 * @Title: HomeServiceImpl.java
 * @Package com.osxm.springboot.service.impl
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月14日
 * @version V1.0
 */
package com.osxm.springboot.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.osxm.springboot.service.HomeService;

/**
 * @ClassName: HomeServiceImpl
 * @Description: TODO
 * @author oscarchen
 */
@Service
public class HomeServiceImpl implements HomeService {

	// @Override
	public String login(String userId, String password) {
		String errMsg = null;
		if (userId == null || userId.isEmpty()) {
			errMsg = "UserId is Null.";
		} else {
			Subject currentUser = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(userId, password);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException uae) {
				errMsg = "用户不存在：" + token.getPrincipal();
			} catch (IncorrectCredentialsException ice) {
				errMsg = "密码错误： " + token.getPrincipal();
			} catch (LockedAccountException lae) {
				errMsg = "账号被锁了";
			}
		}
		return errMsg;
	}

	// @Override
	public void logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}

}
