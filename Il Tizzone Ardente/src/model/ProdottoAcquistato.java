package model;

public class ProdottoAcquistato {
	
	private Prodotto prodotto;
	private Composizione composizione;
	
	public ProdottoAcquistato() {
		
	}
	
	public ProdottoAcquistato(Prodotto prodotto, Composizione composizione) {
		
		this.prodotto = prodotto;
		this.composizione = composizione;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

	public Composizione getComposizione() {
		return composizione;
	}

	public void setComposizione(Composizione composizione) {
		this.composizione = composizione;
	}
	
	

}
