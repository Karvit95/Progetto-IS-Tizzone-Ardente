package model;

import java.io.Serializable;

public class Composizione implements Serializable {
	
	private static final long serialVersionUID = 6571512122803413201L;
	
	private int quantit�;
	private String codiceFattura;
	private int iva;
	private String idProdotto;
	private double prezzoPagato;

	public Composizione() {
		
	}

	public Composizione(int quantit�, String codiceFattura, int iva, String idProdotto, double prezzoPagato) {
		
		this.quantit� = quantit�;
		this.codiceFattura = codiceFattura;
		this.iva = iva;
		this.idProdotto = idProdotto;
		this.prezzoPagato = prezzoPagato;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
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
