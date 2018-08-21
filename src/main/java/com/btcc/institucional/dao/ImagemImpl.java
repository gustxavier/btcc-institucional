package com.btcc.institucional.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.btcc.institucional.domain.Imagem;
import com.btcc.institucional.domain.ImagemLocal;
import com.btcc.institucional.domain.ImagemTipo;

@Repository
public class ImagemImpl extends AbstractDao<Imagem, Long> implements ImagemDao {
	
	@Override
	public List<Imagem> findAll(ImagemTipo tipo) {
		return getEntityManager()
				.createQuery("from " + getEntityClass().getSimpleName() + " WHERE tipo = :tipo", getEntityClass())
				.setParameter("tipo", tipo.getTipo())
				.getResultList();
	}

	@Override
	public List<Imagem> findByImagetitle(String title) {
		return getEntityManager()
				.createQuery("from " + getEntityClass().getSimpleName() + " WHERE titulo = :titulo", getEntityClass())
				.setParameter("titulo", title)
				.getResultList();
	}
}
