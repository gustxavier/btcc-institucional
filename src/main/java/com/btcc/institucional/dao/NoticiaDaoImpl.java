package com.btcc.institucional.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.btcc.institucional.domain.Noticia;

@Repository
public class NoticiaDaoImpl extends AbstractDao<Noticia, Long> implements NoticiaDao {
	
	public List<Noticia> findAll(){
		return getEntityManager()
				.createQuery("from " + getEntityClass().getSimpleName() + " ORDER BY id DESC", getEntityClass())
				.getResultList();
	}
	
	public List<Noticia> findBlockThreeNotice(){
		return getEntityManager()
				.createQuery("from " + getEntityClass().getSimpleName() + " ORDER BY id DESC", getEntityClass())
				.setMaxResults(1)
				.getResultList();
	}
}
