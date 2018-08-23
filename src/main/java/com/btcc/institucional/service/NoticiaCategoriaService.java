package com.btcc.institucional.service;

import java.util.List;
import com.btcc.institucional.domain.NoticiaCategoria;

public interface NoticiaCategoriaService {
	void salvar (NoticiaCategoria noticiaCategoria);
	
	void editar (NoticiaCategoria noticiaCategoria);
	
	void excluir (Long id);
	
	NoticiaCategoria buscaPorId (Long id);
	
	List<NoticiaCategoria> buscarTodos();

	boolean categoriaTemNoticia(Long id);
}
