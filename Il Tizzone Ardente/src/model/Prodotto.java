package model;

import java.io.Serializable;

public class Prodotto implements Serializable {
	
	private static final long serialVersionUID = 251079331519531454L;
	
	String id;
	double peso;
	String nome;
	String modello;
	String catalogo;
	String materiale;
	double prezzo;
	int sconto;
	String descrizione;
	int quantità;
	
	public Prodotto() {
		
	}

	public Prodotto(String id, double peso, String nome, String modello, String catalogo, String materiale, double prezzo, int sconto, String descrizione, int quantità) {
		
		this.id = id;
		this.peso = peso;
		this.nome = nome;
		this.modello = modello;
		this.catalogo = catalogo;
		this.materiale = materiale;
		this.prezzo = prezzo;
		this.sconto = sconto;
		this.descrizione = descrizione;
		this.quantità = quantità;

	}

	public String getId() {
		
		return id;
		
	}
	
	public void setId(String id) {
		
		this.id = id;
		
	}
	
	public double getPeso() {
		
		return peso;
		
	}
	
	public void setPeso(double peso) {
		
		this.peso = peso;
	
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		
		this.nome = nome;
	
	}
	
	public String getModello() {
	
		return modello;
	
	}
	
	public void setModello(String modello) {
	
		this.modello = modello;
	
	}
	
	public String getCatalogo() {
	
		return catalogo;
	
	}
	
	public void setCatalogo(String catalogo) {
	
		this.catalogo = catalogo;
	
	}
	
	public String getMateriale() {
	
		return materiale;
	
	}
	
	public void setMateriale(String materiale) {
	
		this.materiale = materiale;
	
	}
	
	public double getPrezzo() {
	
		return prezzo;
	
	}
	
	public void setPrezzo(double prezzo) {
	
		this.prezzo = prezzo;
	
	}
	
	public int getSconto() {
	
		return sconto;
	
	}
	
	public void setSconto(int sconto) {
	
		this.sconto = sconto;

	}

	public String getDescrizione() {
	
		return descrizione;
	
	}
	
	public void setDescrizione(String descrizione) {
	
		this.descrizione = descrizione;
	
	}
	
	public int getQuantità() {
		
		return quantità;
	
	}

	public void setQuantità(int quantità) {
	
		this.quantità = quantità;
	
	}
	
	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", peso=" + peso + ", nome=" + nome + ", modello=" + modello + ", catalogo="
				+ catalogo + ", materiale=" + materiale + ", prezzo=" + prezzo + ", sconto=" + sconto + ", descrizione="
				+ descrizione + ", quantità=" + quantità + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalogo == null) ? 0 : catalogo.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((materiale == null) ? 0 : materiale.hashCode());
		result = prime * result + ((modello == null) ? 0 : modello.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantità;
		result = prime * result + sconto;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		if (catalogo == null) {
			if (other.catalogo != null)
				return false;
		} else if (!catalogo.equals(other.catalogo))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (materiale == null) {
			if (other.materiale != null)
				return false;
		} else if (!materiale.equals(other.materiale))
			return false;
		if (modello == null) {
			if (other.modello != null)
				return false;
		} else if (!modello.equals(other.modello))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		if (quantità != other.quantità)
			return false;
		if (sconto != other.sconto)
			return false;
		return true;
	}
	
}
