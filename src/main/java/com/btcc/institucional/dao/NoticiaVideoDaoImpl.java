package com.btcc.institucional.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.btcc.institucional.domain.NoticiaVideo;

@Repository
public class NoticiaVideoDaoImpl extends AbstractDao<NoticiaVideo, Long> implements NoticiaVideoDao {
	
	public List<NoticiaVideo> findAll(){
		return getEntityManager()
				.createQuery("from " + getEntityClass().getSimpleName() + " ORDER BY id DESC", getEntityClass())
				.getResultList();
	}
}
