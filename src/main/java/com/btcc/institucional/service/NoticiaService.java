package com.btcc.institucional.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.btcc.institucional.domain.Noticia;

public interface NoticiaService {
	void salvar (Noticia noticia);
	
	void editar (Noticia noticia);
	
	void excluir (Long noticia);
	
	Noticia buscaPorId (Long id);
	
	List<Noticia> buscarPrimeiro();
	
	List<Noticia> buscarBlocoTresNoticias();
	
	List<Noticia> buscarTodos();
	
	ArrayList<String> uploadFile (MultipartFile file, Noticia noticia);
	
	boolean removeFile (Long id);
}
