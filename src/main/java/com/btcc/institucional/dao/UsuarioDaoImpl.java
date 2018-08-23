package com.btcc.institucional.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.btcc.institucional.domain.Usuario;

@Repository(value ="usuario")
@Transactional
public class UsuarioDaoImpl extends AbstractDao<Usuario, Long> implements UsuarioDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> verifyLogin(Usuario usuario) {
		return getEntityManager().createQuery("select id from Usuario u where u.email = :email and u.password = :password")
		.setParameter("email", usuario.getEmail())
		.setParameter("password", usuario.getPassword())
		.getResultList();		
	}

	@Override
	public Usuario findByName(String username) {
		Usuario usuario = new Usuario();
		
		List<?> list = getEntityManager().createQuery("from " + getEntityClass().getSimpleName() + " where nome = :nome")
				.setParameter("nome", username)
				.getResultList();
		
		if(!list.isEmpty()) {
			usuario = (Usuario) list.get(0);
		}
		
		return usuario;
	}
}
