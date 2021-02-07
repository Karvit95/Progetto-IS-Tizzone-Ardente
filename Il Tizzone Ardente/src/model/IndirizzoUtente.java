package model;

import java.io.Serializable;

public class IndirizzoUtente implements Serializable {

	private static final long serialVersionUID = 6655043497886750269L;
	
	private String email;
	private String citt�;
	private String indirizzo;
	private String provincia;
	private int numeroCivico;
	private String cap;
	
	public IndirizzoUtente(){
		
	}
	
	public IndirizzoUtente(String email, String citt�, String indirizzo, String provincia, int numeroCivico, String cap) {
		
		this.email = email;
		this.citt� = citt�;
		this.indirizzo = indirizzo;
		this.provincia = provincia;
		this.numeroCivico = numeroCivico;
		this.cap = cap;
	
	}
	
	public String getEmail() {
	
		return email;
	
	}

	public void setEmail(String email) {
	
		this.email = email;
	
	}

	public String getCitt�() {
		
		return citt�;
	
	}

	public void setCitt�(String citt�) {
	
		this.citt� = citt�;
	
	}

	public String getIndirizzo() {
	
		return indirizzo;
	
	}

	public void setIndirizzo(String indirizzo) {

		this.indirizzo = indirizzo;
	
	}

	public String getProvincia() {
		
		return provincia;
	
	}

	public void setProvincia(String provincia) {
		
		this.provincia = provincia;
	
	}

	public int getNumeroCivico() {
		
		return numeroCivico;
	
	}

	public void setNumeroCivico(int numeroCivico) {
		
		this.numeroCivico = numeroCivico;
	
	}

	public String getCap() {
		
		return cap;
	
	}

	public void setCap(String cap) {
		
		this.cap = cap;
	
	}

	@Override
	public String toString() {
		return "IndirizzoUtente [citt�=" + citt� + ", indirizzo=" + indirizzo + ", provincia=" + provincia
				+ ", numeroCivico=" + numeroCivico + ", cap=" + cap + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cap == null) ? 0 : cap.hashCode());
		result = prime * result + ((citt� == null) ? 0 : citt�.hashCode());
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + numeroCivico;
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
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
		IndirizzoUtente other = (IndirizzoUtente) obj;
		if (cap == null) {
			if (other.cap != null)
				return false;
		} else if (!cap.equals(other.cap))
			return false;
		if (citt� == null) {
			if (other.citt� != null)
				return false;
		} else if (!citt�.equals(other.citt�))
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (numeroCivico != other.numeroCivico)
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}

	
	

}
