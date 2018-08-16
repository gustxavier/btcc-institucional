package com.btcc.institucional.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.btcc.institucional.domain.Imagem;
import com.btcc.institucional.domain.ImagemTipo;

public interface ImagemService {
	void salvar (Imagem imagem);
	
	void editar (Imagem imagem);
	
	void excluir (Long id);
	
	Imagem buscaPorId (Long id);	
	
	List<Imagem> buscarTodos(ImagemTipo local);
	
	ArrayList<String> uploadFile (MultipartFile file, Imagem imagem);
	
	boolean removeFile (Long id);
	
	boolean isTituloExists(String titulo);
	
	ArrayList<String> validaCamposAdicionar(MultipartFile file, Imagem imagem);
}
