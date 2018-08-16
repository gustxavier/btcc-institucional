package com.btcc.institucional.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.btcc.institucional.domain.Imagem;
import com.btcc.institucional.domain.ImagemTipo;

@Repository
public class ImagemImpl extends AbstractDao<Imagem, Long> implements ImagemDao {

	@SuppressWarnings("unchecked")
    private final Class<Imagem> entityClass = (Class<Imagem>) 
        ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
	
	@Override
	public List<Imagem> findAll(ImagemTipo tipo) {
		return getEntityManager()
				.createQuery("from " + entityClass.getSimpleName() + " WHERE tipo = :tipo", entityClass)
				.setParameter("tipo", tipo.getTipo())
				.getResultList();
	}

	@Override
	public List<Imagem> findByImagetitle(String title) {
		return getEntityManager()
				.createQuery("from " + entityClass.getSimpleName() + " WHERE titulo = :titulo", entityClass)
				.setParameter("titulo", title)
				.getResultList();
	}


}
