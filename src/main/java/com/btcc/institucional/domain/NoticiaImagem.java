package com.btcc.institucional.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "noticia_imagem")
public class NoticiaImagem extends AbstractEntity<Long> {
	
	@Column(name = "titulo", nullable = false, length = 255)
	private String titulo;

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	
	
}
