package com.btcc.institucional.domain;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity<BigInteger> {
	
	@Column(name= "nome", nullable = false, length = 60)
	private String nome;
	
	@Column(name= "email", nullable = false, length = 80)
	private String email;
	
	@Column(name= "password", nullable = false, length = 150)
	private String password;
	
//	@Column(name= "deletado", nullable = false, columnDefinition = "DEFAULT N")
//	@Enumerated(EnumType.STRING)
//	private Deletado deletado;
		
	@OneToMany
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
//	public Deletado getDeletado() {
//		return deletado;
//	}
//	public void setDeletado(Deletado deletado) {
//		this.deletado = deletado;
//	}	
//	
}
