package com.btcc.institucional.dao;

import java.math.BigInteger;
import java.util.List;

import com.btcc.institucional.domain.Usuario;

public interface UsuarioDao {
	void save(Usuario usuario);
	
	void update(Usuario usuario);
	
	void delete(BigInteger id);
	
	Usuario findById(BigInteger id);
	
	List<Usuario> findAll();
}
