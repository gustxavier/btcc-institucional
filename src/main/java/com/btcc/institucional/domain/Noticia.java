package com.btcc.institucional.domain;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "noticia")
public class Noticia extends AbstractEntity<BigInteger> {

	@Column(name = "titulo", nullable = false, length = 255)
	private String titulo;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data", nullable = false, columnDefinition = "DATE")
	private LocalDate data;
	
	@Column(name = "conteudo", nullable = true)
	private String conteudo;
	
	@Column(name = "imagem", nullable = true)
	private String imagem;
	
//	@Column(name = "deletado", nullable = false, columnDefinition = "DEFAULT N")
//	@Enumerated(EnumType.STRING)
//	private Deletado deletado;
//	
//	@Column(name = "publicado", nullable = false, columnDefinition = "DEFAULT N")
//	@Enumerated(EnumType.STRING)
//	private Publicado publicado;

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
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

//	public Deletado getDeletado() {
//		return deletado;
//	}
//
//	public void setDeletado(Deletado deletado) {
//		this.deletado = deletado;
//	}
//
//	public Publicado getPublicado() {
//		return publicado;
//	}
//
//	public void setPublicado(Publicado publicado) {
//		this.publicado = publicado;
//	}

	
}
