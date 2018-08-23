package com.btcc.institucional.dao;

import java.util.List;

import com.btcc.institucional.domain.NoticiaCategoria;

public interface NoticiaCategoriaDao {
	void save(NoticiaCategoria noticiaCategoria);
	
	void update(NoticiaCategoria noticiaCategoria);
	
	void delete(Long id);
	
	NoticiaCategoria findById(Long id);
	
	List<NoticiaCategoria> findAll();
}
