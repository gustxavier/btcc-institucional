package com.btcc.institucional.domain;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@SuppressWarnings("serial")
@Entity
@Table(name = "noticia")
public class Noticia extends AbstractEntity<Long> {

	@Column(name = "titulo", nullable = false, length = 255)
	private String titulo;
	
	@Column(name = "linkpermanente", nullable = false, length = 255)
	private String linkpermanente;
	
	@Column(name = "retranca", nullable = true, length = 255)
	private String retranca;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data", nullable = false, columnDefinition = "DATE")
	private LocalDate data;
	
	@Column(name = "conteudo", nullable = true, columnDefinition = "LONGTEXT")
	private String conteudo;

	@Column(name = "imagem", nullable = true)
	private String imagem;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private NoticiaCategoria categoria;
	
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
	
	public String getRetranca() {
		return retranca;
	}

	public void setRetranca(String retranca) {
		this.retranca = retranca;
	}

	public NoticiaCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(NoticiaCategoria categoria) {
		this.categoria = categoria;
	}

	public String getLinkpermanente() {
		return linkpermanente;
	}

	public void setLinkpermanente(String linkpermanente) {
		this.linkpermanente = linkpermanente;
	}	
	
	
}
