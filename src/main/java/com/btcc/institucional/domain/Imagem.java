package com.btcc.institucional.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "imagem")
public class Imagem  extends AbstractEntity<Long>{
	
	@Column(name = "titulo", nullable = false, length = 255)
	private String titulo;
	
	@Column(name = "tipo", nullable = false)
	private String tipo;
	
	@Column(name = "local", nullable = true)
	private String local;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	
	
}
