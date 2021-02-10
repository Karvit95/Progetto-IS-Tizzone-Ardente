package model;

import java.io.Serializable;

public class ProdottoOrdinato implements Serializable {
	
	private static final long serialVersionUID = 8657571845222910205L;
	
	int quantità;
	Prodotto prodotto;
	
	public ProdottoOrdinato(Prodotto p, int quantità) {
		this.prodotto = p;
		this.quantità = quantità;
	}

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	
}
