package com.btcc.institucional.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.btcc.institucional.domain.Noticia;

public interface NoticiaService {
	void salvar (Noticia noticia);
	
	void editar (Noticia noticia);
	
	void excluir (Long id);
	
	Noticia buscaPorId (Long id);
	
	List<Noticia> buscarPrimeiro();
	
	List<Noticia> buscarBlocoTresNoticias();
	
	List<Noticia> buscarTodos();
	
	List<Noticia> buscarRelacionadas(Long noticiaId, Long categoriaId);
	
	ArrayList<String> uploadFile (MultipartFile file, Noticia noticia);
	
	boolean removeFile (Long id);
	
	boolean validaFomulario(Noticia noticia);
}
