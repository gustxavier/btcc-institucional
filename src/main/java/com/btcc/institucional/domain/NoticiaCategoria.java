package com.btcc.institucional.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "noticia_categoria")
public class NoticiaCategoria extends AbstractEntity<Long> {

	@Column(name="nome", nullable = false, unique = true, length = 150)
	private String nome;
	
	@OneToMany(mappedBy = "categoria")
	private List<Noticia> noticias;

	public List<Noticia> getNoticia() {
		return noticias;
	}

	public void setNoticia(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
