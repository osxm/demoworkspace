/**
 * @Title: UserService.java
 * @Package com.osxm.springboot.service
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月7日
 * @version V1.0
 */
package com.osxm.springboot.service;

import java.util.List;

import com.osxm.springboot.entity.User;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @author oscarchen
 */
public interface UserService {
	User get(String userId);

	List<User> list();
}
