package model;

import java.io.Serializable;

public class ProdottoNelCarrello implements Serializable {
	
	private static final long serialVersionUID = 8657571845222910205L;
	
	int quantit�;
	Prodotto prodotto;
	
	public ProdottoNelCarrello(Prodotto p, int quantit�) {
		this.prodotto = p;
		this.quantit� = quantit�;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	
}
