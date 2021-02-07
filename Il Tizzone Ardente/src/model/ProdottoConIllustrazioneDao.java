package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoConIllustrazioneDao {

	public synchronized ArrayList<ProdottoConIllustrazione> doRetrieve() throws SQLException{
	 
		Connection conn = null;
		PreparedStatement ps = null;
		
		ArrayList<ProdottoConIllustrazione> listaProdotti = new ArrayList<ProdottoConIllustrazione>();
		
		Prodotto p;
		Illustrazione i;
		ProdottoConIllustrazione prodottoIllustrazione;
		
		String sql = "SELECT * FROM prodotto INNER JOIN illustrazione ON prodotto.IDProdotto = illustrazione.IDProdotto";
		
		 try {
	        	
	        	conn = DriverManagerConnectionPool.getConnection();
	        	ps = conn.prepareStatement(sql);
	        	ResultSet rs = ps.executeQuery();
	        	
	        	 while (rs.next()){
	 	            
	 	            String id, nome, modello, catalogo, materiale, descrizione, immagine;
	 	            double peso, prezzo;
	 	            int sconto, quantità;
	 	            
	 	            id = rs.getString("IDProdotto");
	 	            peso = rs.getInt("Peso");
	 	            nome = rs.getString("Nome");
	 	            modello = rs.getString("Modello");
	 	            catalogo = rs.getString("Catalogo");
	 	            materiale = rs.getString("Materiale");
	 	            prezzo = rs.getDouble("Prezzo");
	 	            sconto = rs.getInt("Sconto");
	 	            descrizione = rs.getString("Descrizione");
	 	            quantità = rs.getInt("Quantità");
	 	            immagine = rs.getString("URL");
	 	         
	 	            p = new Prodotto(id, peso, nome, modello, catalogo, materiale, prezzo, sconto, descrizione, quantità);
	 	            i = new Illustrazione(id, immagine);
	 	            prodottoIllustrazione = new ProdottoConIllustrazione(p, i);
	 	            listaProdotti.add(prodottoIllustrazione);
	 	        }
	        	 
	        }finally {
				
	        	try {
					
	        		if(ps != null)
	        			ps.close();
					
	        	}finally {
					
	        		DriverManagerConnectionPool.releaseConnection(conn);
	        	}
	        }
		
		 return listaProdotti;
	}
	
	public synchronized ProdottoConIllustrazione doRetrieveByKey(String id) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
		Prodotto prodotto = new Prodotto();
        Illustrazione illustrazione = new Illustrazione();
        ProdottoConIllustrazione prodottoIllustrazione = new ProdottoConIllustrazione();
        
        String sql = "SELECT * FROM prodotto INNER JOIN illustrazione on prodotto.IDProdotto = illustrazione.IDProdotto WHERE prodotto.IDProdotto = ?";
        
        try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, id);
		     ResultSet rs = ps.executeQuery();
		     while (rs.next()){
		            
		        	String idProdotto, nome, modello, catalogo, materiale, descrizione, immagine;
		            double peso, prezzo;
		            int sconto, quantità;
		              
		            idProdotto = rs.getString("IDProdotto");
		            peso = rs.getDouble("Peso");
		            nome = rs.getString("Nome");
		            modello = rs.getString("Modello");
		            catalogo = rs.getString("Catalogo");
		            materiale = rs.getString("Materiale");
		            prezzo = rs.getDouble("Prezzo");
		            sconto = rs.getInt("Sconto");
		            descrizione = rs.getString("Descrizione");
		            quantità = rs.getInt("Quantità");
		            immagine = rs.getString("URL");
		            
		            prodotto = new Prodotto(idProdotto, peso, nome, modello, catalogo, materiale, prezzo, sconto, descrizione, quantità);
		            illustrazione = new Illustrazione(idProdotto, immagine);
		            prodottoIllustrazione = new ProdottoConIllustrazione(prodotto, illustrazione);
		                        
		        }
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        
        return prodottoIllustrazione;
    
    }

	public synchronized ArrayList<ProdottoConIllustrazione> doRetrieveByCatalogo(String nomeCatalogo) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        Prodotto prodotto = new Prodotto();
        Illustrazione illustrazione = new Illustrazione();
        ProdottoConIllustrazione prodottoIllustrazione = new ProdottoConIllustrazione();
        ArrayList<ProdottoConIllustrazione>listaProdotti = new ArrayList<ProdottoConIllustrazione>();
        
        String sql = "SELECT * FROM prodotto INNER JOIN illustrazione on prodotto.IDProdotto = illustrazione.IDProdotto WHERE prodotto.Catalogo = ?";
        
        try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement(sql);
	        ps.setString(1, nomeCatalogo);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()){
	            
	        	String idProdotto, nome, modello, catalogo, materiale, descrizione, immagine;
	            double peso, prezzo;
	            int sconto, quantità;
	              
	            idProdotto = rs.getString("IDProdotto");
	            peso = rs.getDouble("Peso");
	            nome = rs.getString("Nome");
	            modello = rs.getString("Modello");
	            catalogo = rs.getString("Catalogo");
	            materiale = rs.getString("Materiale");
	            prezzo = rs.getDouble("Prezzo");
	            sconto = rs.getInt("Sconto");
	            descrizione = rs.getString("Descrizione");
	            quantità = rs.getInt("Quantità");
	            immagine = rs.getString("URL");
	            
	            prodotto = new Prodotto(idProdotto, peso, nome, modello, catalogo, materiale, prezzo, sconto, descrizione, quantità);
	            illustrazione = new Illustrazione(idProdotto, immagine);
	            prodottoIllustrazione = new ProdottoConIllustrazione(prodotto, illustrazione);
	            
	            listaProdotti.add(prodottoIllustrazione);
	                        
	        }	
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        
        return listaProdotti;
 
    }
	
	public synchronized ArrayList<ProdottoConIllustrazione> doRetrieveByNome(String ricerca) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
		Prodotto prodotto = new Prodotto();
        Illustrazione illustrazione = new Illustrazione();
        ProdottoConIllustrazione prodottoIllustrazione = new ProdottoConIllustrazione();
        ArrayList<ProdottoConIllustrazione>listaProdotti = new ArrayList<ProdottoConIllustrazione>();
        
        String sql = "SELECT * FROM prodotto INNER JOIN illustrazione on prodotto.IDProdotto = illustrazione.IDProdotto WHERE Nome LIKE '%" + ricerca + "%'";
        
        try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			 ps = conn.prepareStatement(sql);
		     ResultSet rs = ps.executeQuery();
		     while (rs.next()){
		            
		        	String idProdotto, nome, modello, catalogo, materiale, descrizione, immagine;
		            double peso, prezzo;
		            int sconto, quantità;
		              
		            idProdotto = rs.getString("IDProdotto");
		            peso = rs.getDouble("Peso");
		            nome = rs.getString("Nome");
		            modello = rs.getString("Modello");
		            catalogo = rs.getString("Catalogo");
		            materiale = rs.getString("Materiale");
		            prezzo = rs.getDouble("Prezzo");
		            sconto = rs.getInt("Sconto");
		            descrizione = rs.getString("Descrizione");
		            quantità = rs.getInt("Quantità");
		            immagine = rs.getString("URL");
		            
		            prodotto = new Prodotto(idProdotto, peso, nome, modello, catalogo, materiale, prezzo, sconto, descrizione, quantità);
		            illustrazione = new Illustrazione(idProdotto, immagine);
		            prodottoIllustrazione = new ProdottoConIllustrazione(prodotto, illustrazione);
		            
		            listaProdotti.add(prodottoIllustrazione);
		                        
		        }
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        
        return listaProdotti;
    
    }
}
