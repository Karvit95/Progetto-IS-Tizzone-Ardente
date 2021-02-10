package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoDao {
    
    public synchronized void doSave(Prodotto p) throws SQLException {
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = ("insert into prodotto (IDProdotto, Peso, Nome, Modello, Catalogo, Materiale, Prezzo, Sconto, Descrizione, Quantità) values (?,?,?,?,?,?,?,?,?,?)");
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, p.getId());
			ps.setDouble(2, p.getPeso());
			ps.setString(3, p.getNome());
	        ps.setString(4, p.getModello());
	        ps.setString(5, p.getCatalogo());
	        ps.setString(6, p.getMateriale());
	        ps.setDouble(7, p.getPrezzo());
	        ps.setInt(8, p.getSconto());
	        ps.setString(9, p.getDescrizione());
	        ps.setInt(10, p.getQuantità());
	                       
	        ps.executeUpdate();		 
	       
	        conn.commit();
			
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
	}
    
    public synchronized ArrayList<Prodotto> doRetrieve() throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        Prodotto prodotto;
        ArrayList<Prodotto>listaProdotti = new ArrayList<Prodotto>();
        
        String sql = ("Select * from prodotto");
        
        try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps=conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery(sql);
	        
	        while (rs.next()){
	            
	            String idProdotto, nome, modello, catalogo, materiale, descrizione;
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
	            
	            prodotto = new Prodotto(idProdotto, peso, nome, modello, catalogo, materiale, prezzo, sconto, descrizione, quantità);
	            
	            listaProdotti.add(prodotto);
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
    
    public synchronized Prodotto doRetrieveByKey(String id) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        Prodotto prodotto = new Prodotto();
        
        String sql = "SELECT * FROM prodotto WHERE IDProdotto = ?";
        
        try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement(sql);
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next()){
	            
	        	String idProdotto, nome, modello, catalogo, materiale, descrizione;
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
	            
	            prodotto = new Prodotto(idProdotto, peso, nome, modello, catalogo, materiale, prezzo, sconto, descrizione, quantità);
	                        
	        }
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        
        return prodotto;
    }
    
    public synchronized boolean cambioPrezzo(String id, double nuovoPrezzo) throws SQLException {
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
    	int result = 0; 
    	
    	String sql = "UPDATE prodotto SET Prezzo = ? WHERE IDProdotto = ?";
    	
    	try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement(sql);
	    	ps.setDouble(1, nuovoPrezzo);
	    	ps.setString(2, id);
	    	
	    	result = ps.executeUpdate();
	    	
	    	conn.commit();
			
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
    	
    	return (result!=0);
    	
    }
    
    public synchronized boolean cambioSconto(String id, int nuovoPrezzo) throws SQLException {
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
    	int result = 0; 
    	
    	String sql = "UPDATE prodotto SET Sconto = ? WHERE IDProdotto = ?";
    	
    	try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement(sql);
	    	ps.setInt(1, nuovoPrezzo);
	    	ps.setString(2, id);
	    	
	    	result = ps.executeUpdate();
	    	
	    	conn.commit();
			
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
    	
    	return (result!=0);
    	
    }
    
    public synchronized boolean cambioQuantita(String id, int nuovaQuantita) throws SQLException {
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
    	int result = 0; 
    	
    	String sql = "UPDATE prodotto SET Quantità = ? WHERE IDProdotto = ?";
    	
    	try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement(sql);
	    	ps.setInt(1, nuovaQuantita);
	    	ps.setString(2, id);
	    	
	    	result = ps.executeUpdate();
	    	
	    	conn.commit();
			
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
    	
    	return (result!=0);
    	
    }

    public synchronized boolean doDelete(String id) throws SQLException{
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
    	int result = 0;
    	
    	String sql = "DELETE from prodotto WHERE IDProdotto = ?";
    	
    	try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement(sql);
	    	ps.setString(1, id);
	    	
	    	result = ps.executeUpdate();
	    	
	    	conn.commit();
			
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
    	
    	return (result != 0);
    	
    }
    
    public synchronized ArrayList<Prodotto> doRetrieveProdottiEIllustrazione() throws SQLException{
   	 
		Connection conn = null;
		PreparedStatement ps = null;
		
		ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
		
		Prodotto p;
		
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
	 	         
	 	            p = new Prodotto(id, peso, nome, modello, catalogo, materiale, prezzo, sconto, descrizione, quantità, immagine);
	 	            listaProdotti.add(p);
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
	
	public synchronized Prodotto doRetrieveProdottiEIllustrazioneByKey(String id) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
		Prodotto prodotto = new Prodotto();
        
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
		            
		            prodotto = new Prodotto(idProdotto, peso, nome, modello, catalogo, materiale, prezzo, sconto, descrizione, quantità, immagine);
		                        
		        }
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        
        return prodotto;
    
    }

	public synchronized ArrayList<Prodotto> doRetrieveByCatalogo(String nomeCatalogo) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        Prodotto prodotto = new Prodotto();
        ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
        
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
	            
	            prodotto = new Prodotto(idProdotto, peso, nome, modello, catalogo, materiale, prezzo, sconto, descrizione, quantità, immagine);
	            
	            listaProdotti.add(prodotto);
	                        
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
	
	public synchronized ArrayList<Prodotto> ricerca(String ricerca) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
		Prodotto prodotto = new Prodotto();
        ArrayList<Prodotto>listaProdotti = new ArrayList<Prodotto>();
        
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
		            
		            prodotto = new Prodotto(idProdotto, peso, nome, modello, catalogo, materiale, prezzo, sconto, descrizione, quantità, immagine);
		            
		            listaProdotti.add(prodotto);
		                        
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