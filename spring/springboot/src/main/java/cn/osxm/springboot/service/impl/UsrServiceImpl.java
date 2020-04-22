/**
 * @Title: UsrServiceImpl.java
 * @Package cn.osxm.springboot.service.impl
 * @Description: TODO
 * @author oscarchen
 * @date 2020年4月11日
 * @version V1.0
 */
package cn.osxm.springboot.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cn.osxm.springboot.entity.Usr;
import cn.osxm.springboot.service.UsrService;

/**
 * @ClassName: UsrServiceImpl
 * @Description: TODO
 * @author oscarchen
 */
@Service
public class UsrServiceImpl implements UsrService {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<Usr> listSafe(String id) {
		String hql = "from Usr where id=:id";
		return em.createQuery(hql, Usr.class).setParameter("id", id).getResultList();
	}

	@Override
	public List<Usr> listUnSafe(String id) {
		String hql = "from Usr where id=" + id;
		return em.createQuery(hql, Usr.class).getResultList();
	}
	
	@Override
	public Usr get(Integer id) {
		return em.find(Usr.class, id);
	}

	@Override
	@Transactional
	public void saveUser(Integer id, String name) {
		Usr usr = em.find(Usr.class, id);
		if(usr!=null) {
			usr.setName(name);
			em.persist(usr);
		}
		
	}

}
