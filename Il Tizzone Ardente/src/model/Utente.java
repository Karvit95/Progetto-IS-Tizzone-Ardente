package model;

import java.io.Serializable;

public class Utente implements Serializable {
	
	private static final long serialVersionUID = -6284082261447942012L;
	
	private String email;
	private String nome;
	private String cognome;
	private String password;
	private String numeroTelefono;
	private boolean amministratore;
	
	public Utente(){
		
	}
	
	public Utente(String email, String nome, String cognome,  String numeroTelefono, String password, boolean amministratore) {
		
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.numeroTelefono = numeroTelefono;
		this.amministratore = amministratore;
	}

	public String getNome() {
	
		return nome;
	
	}
	
	public void setNome(String nome) {
	
		this.nome = nome;
	
	}
	
	public String getCognome() {
	
		return cognome;
	
	}
	
	public void setCognome(String cognome) {
	
		this.cognome = cognome;
	
	}

	public String getEmail() {

		return email;
	
	}

	public void setEmail(String email) {
	
		this.email = email;
	
	}

	public String getPassword() {
	
		return password;
	
	}
	
	public void setPassword(String password) {
	
		this.password = password;
	
	}
	
	public String getNumeroTelefono() {
	
		return numeroTelefono;
	
	}
	
	public void setNumeroTelefono(String numeroTelefono) {
	
		this.numeroTelefono = numeroTelefono;
	
	}
	
	public boolean isAmministratore() {
	
		return amministratore;
	
	}
	
	public void setAmministratore(boolean amministratore) {
	
		this.amministratore = amministratore;
	
	}

	@Override
	public String toString() {
		
		return "utente [nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password=" + password
			
				+ ", numeroTelefono=" + numeroTelefono + ", amministratore=" + amministratore + "]";
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + (amministratore ? 1231 : 1237);
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroTelefono == null) ? 0 : numeroTelefono.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Utente other = (Utente) obj;
		if (amministratore != other.amministratore)
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroTelefono == null) {
			if (other.numeroTelefono != null)
				return false;
		} else if (!numeroTelefono.equals(other.numeroTelefono))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
}