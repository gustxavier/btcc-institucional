package com.btcc.institucional.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.btcc.institucional.domain.Noticia;

@Repository
public class NoticiaDaoImpl extends AbstractDao<Noticia, Long> implements NoticiaDao {
	
	public List<Noticia> findAll(){
		return getEntityManager()
				.createQuery("from " + getEntityClass().getSimpleName() + " order by id desc", getEntityClass())
				.getResultList();
	}
	
	public List<Noticia> findBlockThreeNotice(){
		return getEntityManager()
				.createQuery("from " + getEntityClass().getSimpleName() + " order by id desc", getEntityClass())
				.setMaxResults(1)
				.getResultList();
	}

	@Override
	public List<Noticia> findRelated(Long noticiaId, Long categoriaId) {
		return getEntityManager()
				.createQuery("from " + getEntityClass().getSimpleName() + " where categoria_id = :categoria and id != :id order by id desc", getEntityClass())
				.setParameter("id", noticiaId)
				.setParameter("categoria", categoriaId)
				.setMaxResults(2)
				.getResultList();
	}
}
