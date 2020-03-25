/**
 * @Title: UserServiceImpl.java
 * @Package com.osxm.springboot.service.impl
 * @Description: TODO
 * @author oscarchen
 * @date 2019年11月7日
 * @version V1.0
 */
package com.osxm.springboot.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.osxm.springboot.entity.User;
import com.osxm.springboot.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author oscarchen
 */
@Service
public class UserServiceImpl implements UserService {

	@PersistenceContext
	protected EntityManager em;

	/**
	 * Title: get Description:
	 * 
	 * @param userId
	 * @return
	 * @see com.osxm.springboot.service.UserService#get(java.lang.String)
	 */

	//@Override
	public User get(String userId) {
		return em.find(User.class, userId);
	}

	//@Override
	public List<User> list() {
		List<User> result = em.createQuery("from User", User.class).getResultList();
		return result;
	}

}
