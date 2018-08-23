package com.btcc.institucional.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.btcc.institucional.domain.NoticiaCategoria;
import com.btcc.institucional.service.NoticiaCategoriaService;

@Component
public class StringToCategoriaConverter implements Converter<String, NoticiaCategoria>{

	@Autowired
	private NoticiaCategoriaService serviceCategoria;
	
	@Override
	public NoticiaCategoria convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return serviceCategoria.buscaPorId(id);
	}

}
