package model;

import java.io.Serializable;

public class IndirizzoOrdine implements Serializable {

	private static final long serialVersionUID = 6655043497886750269L;
	
	private String codiceFattura;
	private String città;
	private String indirizzo;
	private String provincia;
	private int numeroCivico;
	private String cap;
	
	public IndirizzoOrdine(){
		
	}
	
	public IndirizzoOrdine(String codiceFattura, IndirizzoOrdine i) {
		
		this.codiceFattura = codiceFattura;
		this.città = i.getCittà();
		this.indirizzo = i.getIndirizzo();
		this.provincia = i.getProvincia();
		this.numeroCivico = i.getNumeroCivico();
		this.cap = i.getCap();
				
	}
	
	public IndirizzoOrdine(String città, String indirizzo, String provincia, int numeroCivico, String cap) {
		this.città = città;
		this.indirizzo = indirizzo;
		this.provincia = provincia;
		this.numeroCivico = numeroCivico;
		this.cap = cap;
	}


	public IndirizzoOrdine(String codiceFattura, String città, String indirizzo, String provincia, int numeroCivico, String cap) {
		
		this.codiceFattura = codiceFattura;
		this.città = città;
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

	public String getCittà() {
		
		return città;
	
	}

	public void setCittà(String città) {
	
		this.città = città;
	
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
