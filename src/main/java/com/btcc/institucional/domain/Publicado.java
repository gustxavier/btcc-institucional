package com.btcc.institucional.domain;

public enum Publicado {
	Sim("S"),
	Nao("N");
	
	private String estado;

	private Publicado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
