package com.btcc.institucional.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.btcc.institucional.dao.NoticiaCategoriaDao;
import com.btcc.institucional.domain.NoticiaCategoria;

@Service @Transactional(readOnly = false)
public class NoticiaCategoriaServiceImpl implements NoticiaCategoriaService{

	@Autowired
	private NoticiaCategoriaDao dao;
	
	@Override
	public void salvar(NoticiaCategoria noticiaCategoria) {
		dao.save(noticiaCategoria);
	}

	@Override
	public void editar(NoticiaCategoria noticiaCategoria) {
		dao.update(noticiaCategoria);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public NoticiaCategoria buscaPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<NoticiaCategoria> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean categoriaTemNoticia(Long id) {
		if(buscaPorId(id).getNoticia().isEmpty()) {
			return false;
		}
		return true;
	}

}
