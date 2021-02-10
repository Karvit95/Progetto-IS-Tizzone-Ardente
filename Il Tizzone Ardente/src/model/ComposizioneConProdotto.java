package model;

public class ComposizioneConProdotto {
	
	private Prodotto prodotto;
	private Composizione composizione;
	
	public ComposizioneConProdotto() {
		
	}
	
	public ComposizioneConProdotto(Prodotto prodotto, Composizione composizione) {
		
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
