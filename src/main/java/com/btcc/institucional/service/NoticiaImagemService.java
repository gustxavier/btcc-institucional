package com.btcc.institucional.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.btcc.institucional.domain.NoticiaImagem;

public interface NoticiaImagemService {
	void salvar (NoticiaImagem noticiaImagem);

	void excluir (Long id);

	NoticiaImagem buscaPorId (Long id);

	List<NoticiaImagem> buscarTodos();

	boolean removeFile(Long id);

	ArrayList<String> uploadFile(MultipartFile file, NoticiaImagem noticiaImagem);

}
