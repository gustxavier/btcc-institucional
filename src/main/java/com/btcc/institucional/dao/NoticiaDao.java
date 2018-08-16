package com.btcc.institucional.dao;

import java.util.List;

import com.btcc.institucional.domain.Noticia;;

public interface NoticiaDao {
	void save(Noticia noticia);
	
	void update(Noticia noticia);
	
	void delete(Long id);
	
	Noticia findById(Long id);
	
	List<Noticia> findFirst();
	
	List<Noticia> findBlockThreeNotice();
	
	List<Noticia> findAll();
}
