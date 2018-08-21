package com.btcc.institucional.dao;

import java.util.List;

import com.btcc.institucional.domain.NoticiaImagem;

public interface NoticiaImagemDao {
	void save(NoticiaImagem noticiaImagem);
		
	void delete(Long id);
	
	NoticiaImagem findById(Long id);
	
	List<NoticiaImagem> findAll();
}
