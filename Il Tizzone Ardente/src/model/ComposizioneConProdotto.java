package model;

public class ComposizioneConProdotto {
	
	private ProdottoConIllustrazione prodottoIllustrato;
	private Composizione composizione;
	
	public ComposizioneConProdotto() {
		
	}
	
	public ComposizioneConProdotto(ProdottoConIllustrazione prodotto, Composizione composizione) {
		
		this.prodottoIllustrato = prodotto;
		this.composizione = composizione;
	}

	public ProdottoConIllustrazione getProdottoIllustrato() {
		return prodottoIllustrato;
	}

	public void setProdottoIllustrato(ProdottoConIllustrazione prodotto) {
		this.prodottoIllustrato = prodotto;
	}

	public Composizione getComposizione() {
		return composizione;
	}

	public void setComposizione(Composizione composizione) {
		this.composizione = composizione;
	}
	
	

}
