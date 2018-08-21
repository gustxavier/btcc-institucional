package com.btcc.institucional.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.btcc.institucional.domain.NoticiaVideo;

public interface NoticiaVideoService {

	void salvar (NoticiaVideo noticiaVideo);

	void excluir (Long id);

	NoticiaVideo buscaPorId (Long id);

	List<NoticiaVideo> buscarTodos();

	boolean removeFile(Long id);

	ArrayList<String> uploadFile(MultipartFile file, NoticiaVideo noticiaVideo);

}
