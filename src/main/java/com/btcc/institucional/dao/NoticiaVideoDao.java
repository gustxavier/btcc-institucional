package com.btcc.institucional.dao;

import java.util.List;

import com.btcc.institucional.domain.NoticiaVideo;

public interface NoticiaVideoDao {

	void save(NoticiaVideo noticiaVideo);
	
	void delete(Long id);
	
	NoticiaVideo findById(Long id);
	
	List<NoticiaVideo> findAll();	
}
