package model;

import java.io.Serializable;

public class ProdottoOrdinato implements Serializable {
	
	private static final long serialVersionUID = 8657571845222910205L;
	
	int quantit�;
	ProdottoConIllustrazione prodottoIllustrato;
	
	public ProdottoOrdinato(ProdottoConIllustrazione p, int quantit�) {
		this.prodottoIllustrato = p;
		this.quantit� = quantit�;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}

	public ProdottoConIllustrazione getProdottoIllustrato() {
		return prodottoIllustrato;
	}

	public void setProdottoIllustrato(ProdottoConIllustrazione prodotto) {
		this.prodottoIllustrato = prodotto;
	}

	
}
