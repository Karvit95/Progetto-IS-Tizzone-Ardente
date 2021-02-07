package model;

import java.io.Serializable;
import java.util.ArrayList;
 
public class Carrello implements Serializable {
	
	private static final long serialVersionUID = -6589565584929262633L;
	
	private ArrayList<ProdottoOrdinato> carrello;
  
	public Carrello() {
	  
		carrello = new ArrayList<ProdottoOrdinato>();
	  
	}
 
	public ArrayList<ProdottoOrdinato> getCarrello() {
	  
		return carrello;
    
	}

	public void setCarrello(ArrayList<ProdottoOrdinato> carrello) {
		
		this.carrello = carrello;
		
	}

	public void aggiungiProdottoCarrello(ProdottoConIllustrazione p) {
		
		for(ProdottoOrdinato lista: carrello) {
			
			if(lista.getProdottoIllustrato().getProdotto().getId().equals(p.getProdotto().getId())) {
				
				lista.setQuantit�(lista.getQuantit�()+1);
				return;
			}	
		}
		
		ProdottoOrdinato po = new ProdottoOrdinato(p, 1);
		carrello.add(po);
	
	}
	
	public void rimuoviProdottoCarrello(String id) {
		
		for(int i = 0; i < carrello.size(); i++) {
			
			if(carrello.get(i).getProdottoIllustrato().getProdotto().getId().equals(id)) {
				
				carrello.get(i).setQuantit�(carrello.get(i).getQuantit�()-1);
				
			}
			
		if(carrello.get(i).getQuantit�() <= 0)
			carrello.remove(i);
		}
	}
	
	public void svuotaCarrello() {
		
		carrello.clear();
		
	}
}

    