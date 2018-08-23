package com.btcc.institucional.domain;

public enum UsuarioPermissao {
	admin("ADMIN"),
	user("USER");
	
	private String permissao;

	private UsuarioPermissao(String permissao) {
		this.permissao = permissao;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
	
}
