package com.btcc.institucional.service;

import java.math.BigInteger;
import java.util.List;

import com.btcc.institucional.domain.Noticia;

public interface NoticiaService {
	void salvar (Noticia noticia);
	
	void editar (Noticia noticia);
	
	void excluir (BigInteger noticia);
	
	Noticia buscaPorId (BigInteger id);
	
	List<Noticia> buscarTodos();
}
