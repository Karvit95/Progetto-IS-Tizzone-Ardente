package model;

import java.io.Serializable;

public class ProdottoOrdinato implements Serializable {
	
	private static final long serialVersionUID = 8657571845222910205L;
	
	int quantità;
	ProdottoConIllustrazione prodottoIllustrato;
	
	public ProdottoOrdinato(ProdottoConIllustrazione p, int quantità) {
		this.prodottoIllustrato = p;
		this.quantità = quantità;
	}

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

	public ProdottoConIllustrazione getProdottoIllustrato() {
		return prodottoIllustrato;
	}

	public void setProdottoIllustrato(ProdottoConIllustrazione prodotto) {
		this.prodottoIllustrato = prodotto;
	}

	
}
