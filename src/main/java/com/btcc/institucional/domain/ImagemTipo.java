package com.btcc.institucional.domain;

public enum ImagemTipo {
	home("H"),
	banner("B");
	
	private String tipo;

	private ImagemTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
