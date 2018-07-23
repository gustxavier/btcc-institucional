package com.btcc.institucional.dao;

import java.math.BigInteger;
import java.util.List;

import com.btcc.institucional.domain.Noticia;;

public interface NoticiaDao {
	void save(Noticia noticia);
	
	void update(Noticia noticia);
	
	void delete(BigInteger id);
	
	Noticia findById(BigInteger id);
	
	List<Noticia> findAll();
}
