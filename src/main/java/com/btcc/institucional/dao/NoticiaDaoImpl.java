package com.btcc.institucional.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.btcc.institucional.domain.Noticia;

@Repository
public class NoticiaDaoImpl extends AbstractDao<Noticia, Long> implements NoticiaDao {
	
	@SuppressWarnings("unchecked")
    private final Class<Noticia> entityClass = (Class<Noticia>) 
        ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
	
	public List<Noticia> findBlockThreeNotice(){
		return getEntityManager()
				.createQuery("from " + entityClass.getSimpleName() + " ORDER BY id DESC", entityClass)
				.setMaxResults(1)
				.getResultList();
	}
}
