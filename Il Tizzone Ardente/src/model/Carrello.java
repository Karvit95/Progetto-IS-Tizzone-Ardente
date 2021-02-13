package model;

import java.io.Serializable;
import java.util.ArrayList;
 
public class Carrello implements Serializable {
	
	private static final long serialVersionUID = -6589565584929262633L;
	
	private ArrayList<ProdottoNelCarrello> carrello;
  
	public Carrello() {
	  
		carrello = new ArrayList<ProdottoNelCarrello>();
	  
	}
 
	public ArrayList<ProdottoNelCarrello> getCarrello() {
	  
		return carrello;
    
	}

	public void setCarrello(ArrayList<ProdottoNelCarrello> carrello) {
		
		this.carrello = carrello;
		
	}

	public void aggiungiProdottoCarrello(Prodotto p) {
		
		for(ProdottoNelCarrello lista: carrello) {
			
			if(lista.getProdotto().getId().equals(p.getId())) {
				
				lista.setQuantità(lista.getQuantità()+1);
				return;
			}	
		}
		
		ProdottoNelCarrello po = new ProdottoNelCarrello(p, 1);
		carrello.add(po);
	
	}
	
	public void rimuoviProdottoCarrello(String id) {
		
		for(int i = 0; i < carrello.size(); i++) {
			
			if(carrello.get(i).getProdotto().getId().equals(id)) {
				
				carrello.get(i).setQuantità(carrello.get(i).getQuantità()-1);
				
			}
			
		if(carrello.get(i).getQuantità() <= 0)
			carrello.remove(i);
		}
	}
	
	public void svuotaCarrello() {
		
		carrello.clear();
		
	}
}

    