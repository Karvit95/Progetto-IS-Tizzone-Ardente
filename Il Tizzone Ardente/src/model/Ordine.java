package model;

import java.io.Serializable;

public class Ordine implements Serializable {
	
	private static final long serialVersionUID = -3117074765142503863L;
	
	private String codiceFattura;
	
	public Ordine(){
		
	}
	
	public Ordine(String codiceFattura) {
		
		this.codiceFattura = codiceFattura;
		
	}

	public String getCodiceFattura() {
		return codiceFattura;
	}

	public void setCodiceFattura(String codiceFattura) {
		this.codiceFattura = codiceFattura;
	}

}
