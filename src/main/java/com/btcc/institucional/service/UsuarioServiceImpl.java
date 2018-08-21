package com.btcc.institucional.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btcc.institucional.dao.UsuarioDao;
import com.btcc.institucional.domain.Usuario;

@Service @Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao dao;
	
	@Override
	public void salvar(Usuario usuario) {
		dao.save(usuario);		
	}

	@Override
	public void editar(Usuario usuario) {
		dao.update(usuario);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> buscarTodos() {
		return dao.findAll();
	}

//	@Override
//	public boolean usuarioTemNoticias(BigInteger id) {
////		if(buscaPorId(id).getNoticias().isEmpty()) {
////			return false;
////		}
//		return false;
//	}

	@Override
	public String loginTemUsuario(Usuario usuario) {
		List<Usuario> usuarios = dao.verifyLogin(usuario);
		System.out.println(usuarios);
		if(usuarios.isEmpty()) {
			return "/login/error";
		} 
		return "/panel";
	}

}
