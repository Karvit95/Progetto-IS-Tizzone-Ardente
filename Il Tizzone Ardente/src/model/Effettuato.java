package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Effettuato implements Serializable {
	
	private static final long serialVersionUID = 8102403910901858915L;
	
	private String codiceFattura;
	private String email;
	private LocalDate dataAcquisto;
	
	public Effettuato() {
		
	}
	
	public Effettuato(String email, String codiceFattura, LocalDate dataAcquisto) {
		this.codiceFattura = codiceFattura;
		this.email = email;
		this.dataAcquisto = dataAcquisto;
	}
	
	public String getCodiceFattura() {
		return codiceFattura;
	}
	public void setCodiceFattura(String codiceFattura) {
		this.codiceFattura = codiceFattura;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataAcquisto() {
		return dataAcquisto;
	}
	public void setDataAcquisto(LocalDate dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
}
