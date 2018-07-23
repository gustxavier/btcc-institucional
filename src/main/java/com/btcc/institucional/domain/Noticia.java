package com.btcc.institucional.domain;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "NOTICIA")
public class Noticia extends AbstractEntity<BigInteger> {

	@ManyToOne
	@JoinColumn (name = "fk_usuario_id")
	private Usuario autor_id;
	
	@Column(name = "titulo", nullable = false, length = 255)
	private String titulo;
	
	@Column(name = "data", nullable = false, columnDefinition = "DATE")
	private LocalDate data;
	
	@Column(name = "conteudo", nullable = true)
	private String conteudo;
	
	@Column(name = "deletado", nullable = false, columnDefinition = "DEFAULT N")
	@Enumerated(EnumType.STRING)
	private Deletado deletado;
	
	@Column(name = "publicado", nullable = false, columnDefinition = "DEFAULT N")
	@Enumerated(EnumType.STRING)
	private Publicado publicado;

	public Usuario getAutor_id() {
		return autor_id;
	}

	public void setAutor_id(Usuario autor_id) {
		this.autor_id = autor_id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Deletado getDeletado() {
		return deletado;
	}

	public void setDeletado(Deletado deletado) {
		this.deletado = deletado;
	}

	public Publicado getPublicado() {
		return publicado;
	}

	public void setPublicado(Publicado publicado) {
		this.publicado = publicado;
	}

	
}
