package com.btcc.institucional.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.btcc.institucional.domain.NoticiaImagem;

@Repository
public class NoticiaImagemDaoImpl extends AbstractDao<NoticiaImagem, Long> implements NoticiaImagemDao {
	
	public List<NoticiaImagem> findAll(){
		return getEntityManager()
				.createQuery("from " + getEntityClass().getSimpleName() + " ORDER BY id DESC", getEntityClass())
				.getResultList();
	}
}
