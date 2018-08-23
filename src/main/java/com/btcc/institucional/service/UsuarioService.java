package com.btcc.institucional.service;

import java.util.List;

import com.btcc.institucional.domain.Usuario;

public interface UsuarioService {
void salvar (Usuario usuario);
	
	void editar (Usuario usuario);
	
	void excluir (Long id);
	
	Usuario buscaPorId (Long id);
		
	List<Usuario> buscarTodos();
}
