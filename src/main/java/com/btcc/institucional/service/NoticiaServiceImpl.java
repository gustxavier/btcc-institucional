package com.btcc.institucional.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import com.btcc.institucional.dao.NoticiaDao;
import com.btcc.institucional.domain.Noticia;

@Service @Transactional(readOnly = false)
public class NoticiaServiceImpl implements NoticiaService{

	@Autowired
	private NoticiaDao dao;
	
	
	@Override
	public void salvar(Noticia noticia) {
		dao.save(noticia);
		
	}

	@Override
	public void editar(Noticia noticia) {
		dao.update(noticia);
		
	}

	@Override
	public void excluir (BigInteger id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Noticia buscaPorId(BigInteger id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Noticia> buscarTodos() {
		return dao.findAll();
	}

}
