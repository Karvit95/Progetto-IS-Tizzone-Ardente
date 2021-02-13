package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class DettagliOrdine implements Serializable{

	private static final long serialVersionUID = -6692302511326748966L;
	
	private String CodiceFattura;
	private String email;
	private LocalDate dataDiAcquisto;
	private ArrayList<ProdottoAcquistato> prodottiAcquistati;
	private double prezzoTotale;
	
	public DettagliOrdine() {
		
	}
	
	public DettagliOrdine(String codiceFattura, String email, LocalDate dataDiAcquisto, ArrayList<ProdottoAcquistato> prodottiAcquistati, double prezzoTotale) {
		
		CodiceFattura = codiceFattura;
		this.email = email;
		this.dataDiAcquisto = dataDiAcquisto;
		this.prodottiAcquistati = prodottiAcquistati;
		this.prezzoTotale = prezzoTotale;
		
	}

	public String getCodiceFattura() {
		
		return CodiceFattura;
	
	}

	public void setCodiceFattura(String codiceFattura) {
	
		CodiceFattura = codiceFattura;
	
	}

	public String getEmail() {
	
		return email;
	
	}

	public void setEmail(String email) {
	
		this.email = email;
	
	}

	public LocalDate getDataDiAcquisto() {
	
		return dataDiAcquisto;
	
	}

	public void setDataDiAcquisto(LocalDate dataDiAcquisto) {
	
		this.dataDiAcquisto = dataDiAcquisto;
	
	}

	public ArrayList<ProdottoAcquistato> getProdottiAcquistati() {
	
		return prodottiAcquistati;

	}

	public void setProdottiAcquistati(ArrayList<ProdottoAcquistato> prodottiAcquistati) {
		
		this.prodottiAcquistati = prodottiAcquistati;
	
	}

	public double getPrezzoTotale() {
	
		return prezzoTotale;
	
	}

	public void setPrezzoTotale(double prezzoTotale) {
	
		this.prezzoTotale = prezzoTotale;
	
	}
}
