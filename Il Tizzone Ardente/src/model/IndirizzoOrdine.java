package model;

import java.io.Serializable;

public class IndirizzoOrdine implements Serializable {

	private static final long serialVersionUID = 6655043497886750269L;
	
	private String codiceFattura;
	private String citt�;
	private String indirizzo;
	private String provincia;
	private int numeroCivico;
	private String cap;
	
	public IndirizzoOrdine(){
		
	}
	
	public IndirizzoOrdine(String codiceFattura, IndirizzoOrdine i) {
		
		this.codiceFattura = codiceFattura;
		this.citt� = i.getCitt�();
		this.indirizzo = i.getIndirizzo();
		this.provincia = i.getProvincia();
		this.numeroCivico = i.getNumeroCivico();
		this.cap = i.getCap();
				
	}
	
	public IndirizzoOrdine(String citt�, String indirizzo, String provincia, int numeroCivico, String cap) {
		this.citt� = citt�;
		this.indirizzo = indirizzo;
		this.provincia = provincia;
		this.numeroCivico = numeroCivico;
		this.cap = cap;
	}


	public IndirizzoOrdine(String codiceFattura, String citt�, String indirizzo, String provincia, int numeroCivico, String cap) {
		
		this.codiceFattura = codiceFattura;
		this.citt� = citt�;
		this.indirizzo = indirizzo;
		this.provincia = provincia;
		this.numeroCivico = numeroCivico;
		this.cap = cap;
	
	}
	

	public String getCodiceFattura() {
		return codiceFattura;
	}

	public void setCodiceFattura(String codiceFattura) {
		this.codiceFattura = codiceFattura;
	}

	public String getCitt�() {
		
		return citt�;
	
	}

	public void setCitt�(String citt�) {
	
		this.citt� = citt�;
	
	}

	public String getIndirizzo() {
	
		return indirizzo;
	
	}

	public void setIndirizzo(String indirizzo) {

		this.indirizzo = indirizzo;
	
	}

	public String getProvincia() {
		
		return provincia;
	
	}

	public void setProvincia(String provincia) {
		
		this.provincia = provincia;
	
	}

	public int getNumeroCivico() {
		
		return numeroCivico;
	
	}

	public void setNumeroCivico(int numeroCivico) {
		
		this.numeroCivico = numeroCivico;
	
	}

	public String getCap() {
		
		return cap;
	
	}

	public void setCap(String cap) {
		
		this.cap = cap;
	
	}
}
