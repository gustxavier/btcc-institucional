package com.btcc.institucional.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btcc.institucional.dao.UsuarioDao;
import com.btcc.institucional.domain.Usuario;
import com.btcc.institucional.domain.UsuarioPermissao;

@Service @Transactional(readOnly = false)
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao dao;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void salvar(Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		usuario.setPermissao(UsuarioPermissao.admin.getPermissao());
		dao.save(usuario);		
	}

	@Override
	public void editar(Usuario usuario) {
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
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
}
