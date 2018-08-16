package com.btcc.institucional.domain;

public enum ImagemLocal {
	
	topo("TOP"),
	meio("MID"),
	baixo("BOT");
	
	private String local;

	private ImagemLocal(String local) {
		this.local = local;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	
	
}
