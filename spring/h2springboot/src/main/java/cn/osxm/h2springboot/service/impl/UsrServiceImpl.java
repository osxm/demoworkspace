package cn.osxm.h2springboot.service.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import cn.osxm.h2springboot.entity.Usr;
import cn.osxm.h2springboot.service.UsrService;

@Service
public class UsrServiceImpl implements UsrService {

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public List<Usr> list() {
		return em.createQuery("from Usr",Usr.class).getResultList();
	}

}
