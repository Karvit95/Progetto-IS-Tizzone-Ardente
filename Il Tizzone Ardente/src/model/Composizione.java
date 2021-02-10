package model;

import java.io.Serializable;

public class Composizione implements Serializable {
	
	private static final long serialVersionUID = 6571512122803413201L;
	
	private int quantità;
	private String codiceFattura;
	private int iva;
	private String idProdotto;
	private double prezzoPagato;

	public Composizione() {
		
	}

	public Composizione(int quantità, String codiceFattura, int iva, String idProdotto, double prezzoPagato) {
		
		this.quantità = quantità;
		this.codiceFattura = codiceFattura;
		this.iva = iva;
		this.idProdotto = idProdotto;
		this.prezzoPagato = prezzoPagato;
	}

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	public String getCodiceFattura() {
		return codiceFattura;
	}

	public void setCodiceFattura(String codiceFattura) {
		this.codiceFattura = codiceFattura;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public String getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(String idProdotto) {
		this.idProdotto = idProdotto;
	}

	public double getPrezzoPagato() {
		return prezzoPagato;
	}

	public void setPrezzoPagato(double prezzoPagato) {
		this.prezzoPagato = prezzoPagato;
	}
}
