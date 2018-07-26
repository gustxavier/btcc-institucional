package com.btcc.institucional.service;

import java.math.BigInteger;
import java.util.ArrayList;
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
	public void excluir(BigInteger id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario buscaPorId(BigInteger id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean usuarioTemNoticias(BigInteger id) {
//		if(buscaPorId(id).getNoticias().isEmpty()) {
//			return false;
//		}
		return false;
	}

}
