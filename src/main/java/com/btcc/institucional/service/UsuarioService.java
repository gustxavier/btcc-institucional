package com.btcc.institucional.service;

import java.math.BigInteger;
import java.util.List;

import com.btcc.institucional.domain.Usuario;

public interface UsuarioService {
void salvar (Usuario usuario);
	
	void editar (Usuario usuaraio);
	
	void excluir (BigInteger id);
	
	Usuario buscaPorId (BigInteger id);
	
	List<Usuario> buscarTodos();
	
	boolean usuarioTemNoticias(BigInteger id);
}
