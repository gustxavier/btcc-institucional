package com.btcc.institucional.dao;

import java.util.List;

import com.btcc.institucional.domain.Imagem;
import com.btcc.institucional.domain.ImagemTipo;

public interface ImagemDao {
	void save(Imagem Imagem);
	
	void update(Imagem Imagem);
	
	void delete(Long id);
	
	Imagem findById(Long id);
		
	List<Imagem> findByImagetitle(String title);
	
	List<Imagem> findAll(ImagemTipo tipo);
}
