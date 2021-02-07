package model;

import java.io.Serializable;

public class Composizione implements Serializable {
	
	private static final long serialVersionUID = 6571512122803413201L;
	
	private int quantit�;
	private String codiceFattura;
	private int IVA;
	private String IDProdotto;
	private double prezzoPagato;

	public Composizione() {
		
	}

	public Composizione(int quantit�, String codiceFattura, int iVA, String iDProdotto, double prezzoPagato) {
		
		this.quantit� = quantit�;
		this.codiceFattura = codiceFattura;
		this.IVA = iVA;
		this.IDProdotto = iDProdotto;
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

	public int getIVA() {
		return IVA;
	}

	public void setIVA(int iVA) {
		IVA = iVA;
	}

	public String getIDProdotto() {
		return IDProdotto;
	}

	public void setIDProdotto(String iDProdotto) {
		IDProdotto = iDProdotto;
	}

	public double getPrezzoPagato() {
		return prezzoPagato;
	}

	public void setPrezzoPagato(double prezzoPagato) {
		this.prezzoPagato = prezzoPagato;
	}
	
	

}
