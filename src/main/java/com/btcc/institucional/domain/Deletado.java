package com.btcc.institucional.domain;

public enum Deletado {
	Sim("S"),
	Nao("N");
	
	private String estado;

	Deletado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
