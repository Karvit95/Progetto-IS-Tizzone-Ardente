package model;

import java.io.Serializable;

public class ProdottoConIllustrazione implements Serializable {

	private static final long serialVersionUID = 7693589653398851803L;
	
	private Prodotto prodotto;
	private Illustrazione immagine;
	
	public ProdottoConIllustrazione() {
		
	}
	
	public ProdottoConIllustrazione(Prodotto prodotto) {
		
		this.prodotto = prodotto;
		
	}

	public ProdottoConIllustrazione(Prodotto prodotto, Illustrazione immagine) {
		
		this.prodotto = prodotto;
		this.immagine = immagine;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public Illustrazione getImmagine() {
		return immagine;
	}

	public void setImmagine(Illustrazione immagine) {
		this.immagine = immagine;
	}
}
