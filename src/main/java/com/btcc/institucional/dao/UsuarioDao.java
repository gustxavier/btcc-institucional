package com.btcc.institucional.dao;

import java.util.List;

import com.btcc.institucional.domain.Usuario;

public interface UsuarioDao {
	void save(Usuario usuario);
	
	void update(Usuario usuario);
	
	void delete(Long id);
	
	Usuario findById(Long id);
	
	List<Usuario> verifyLogin(Usuario usuario);
	
	Usuario findByName(String email);
	
	List<Usuario> findAll();
}
