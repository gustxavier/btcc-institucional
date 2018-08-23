package com.btcc.institucional.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity<Long> {

	@Column(name= "nome", nullable = false, unique = true ,length = 60)
	private String nome;

	@Column(name= "email", nullable = false, length = 80)
	private String email;

	@Column(name= "password", nullable = false, length = 150)
	private String password;

	@Column(name= "permissao", nullable = false) 
	private String permissao;
	
	@Transient
	private String passwordConfirm;


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

	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
	
}
