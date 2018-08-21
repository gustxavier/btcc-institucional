package com.btcc.institucional.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "noticia_video")
public class NoticiaVideo extends AbstractEntity<Long> {
	
	@Column(name = "titulo", nullable = false, length = 255)
	private String titulo;
	
	@Column(name = "extensao", nullable = true, length = 20)
	private String extensao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
}
