package com.btcc.institucional.domain;

import java.util.List;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity<Long> {
	
	@Column(name= "nome", nullable = false, length = 60)
	private String nome;
	
	@Column(name= "email", nullable = false, length = 80)
	private String email;
	
	@Column(name= "password", nullable = false, length = 150)
	private String password;
	
	private String passwordConfirm;
		
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	@OneToMany
	@JoinColumn(foreignKey = @ForeignKey( name = "none" ))
	private List<Noticia> noticias;
	
	public List<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
