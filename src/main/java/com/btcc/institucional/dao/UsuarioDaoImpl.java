package com.btcc.institucional.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.btcc.institucional.domain.Usuario;

@Repository(value ="usuario")
public class UsuarioDaoImpl extends AbstractDao<Usuario, Long> implements UsuarioDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> verifyLogin(Usuario usuario) {
		return getEntityManager().createQuery("select id from Usuario u where u.email = :email and u.password = :password")
		.setParameter("email", usuario.getEmail())
		.setParameter("password", usuario.getPassword())
		.getResultList();		
	}
 
}
