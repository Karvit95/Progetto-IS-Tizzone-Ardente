package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Composizione;

public class ComposizioneDao {
	    
	    public synchronized void doSave(Composizione c) throws SQLException {
	    	
	    	Connection conn = null;
			PreparedStatement ps = null;
			
			String sql = ("insert into composizione (Quantit‡Composizione, CodiceFattura, IVA, IDProdotto, PrezzoPagato) values (?,?,?,?,?)");
			
			try {
				
				conn = DriverManagerConnectionPool.getConnection();
				ps=conn.prepareStatement(sql);
				ps.setInt(1, c.getQuantit‡());
				ps.setString(2, c.getCodiceFattura());
				ps.setInt(3, c.getIva());
				ps.setString(4, c.getIdProdotto());
				ps.setDouble(5, c.getPrezzoPagato());
	                       
				ps.executeUpdate();		 
				
				conn.commit();
				
			}finally {
				
				try {
					
					if(ps != null)
						ps.close();
					
				}finally {
					
					DriverManagerConnectionPool.releaseConnection(conn);
				}
			}
		}
	    
	    public synchronized ArrayList<Composizione> doRetrieve() throws SQLException{
	        
	    	Connection conn = null;
			PreparedStatement ps = null;
			
			ArrayList<Composizione> listaComposizione = new ArrayList<Composizione>();
	        
	        String sql = ("Select * from composizione order by CodiceFattura");
	        
	        try {
	        	
	        	conn = DriverManagerConnectionPool.getConnection();
	        	ps = conn.prepareStatement(sql);
	        	ResultSet rs = ps.executeQuery();
	        	
	        	 while (rs.next()){
	 	            
	 	            String codiceFattura, IDProdotto;
	 	            int quantit‡, IVA;
	 	            double prezzo;
	 	            
	 	            quantit‡ = rs.getInt("Quantit‡Composizione");
	 	            codiceFattura = rs.getString("CodiceFattura");
	 	            IVA = rs.getInt("IVA");
	 	            IDProdotto = rs.getString("IDProdotto");
	 	            prezzo = rs.getDouble("PrezzoPagato");
	 	      
	 	            Composizione composizione = new Composizione(quantit‡, codiceFattura, IVA, IDProdotto, prezzo);
	 	            
	 	            listaComposizione.add(composizione);
	 	        }
	        	 
	        }finally {
				
				try {
					
					if(ps != null)
						ps.close();
					
				}finally {
					
					DriverManagerConnectionPool.releaseConnection(conn);
				}
			}
	        
	        return listaComposizione;
		}
	   
	    
	    public synchronized ArrayList<Composizione> doRetrieveByKey(String key) throws SQLException{
	        
	    	Connection conn = null;
			PreparedStatement ps = null;
			
			ArrayList<Composizione> listaComposizione = new ArrayList<Composizione>();
	        
	        String sql = "SELECT * FROM composizione WHERE CodiceFattura = ?";
	        
	        try {
	        	
	        	conn = DriverManagerConnectionPool.getConnection();
		        ps = conn.prepareStatement(sql);
		        ps.setString(1, key);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()){
		            
		        	String codiceFattura, IDProdotto;
		            int quantit‡, IVA;
		            double prezzo;
		            
		            quantit‡ = rs.getInt("Quantit‡Composizione");
		            codiceFattura = rs.getString("CodiceFattura");
		            IVA = rs.getInt("IVA");
		            IDProdotto = rs.getString("IDProdotto");
		            prezzo = rs.getDouble("PrezzoPagato");
		      
		            Composizione composizione = new Composizione(quantit‡, codiceFattura, IVA, IDProdotto, prezzo);
		            listaComposizione.add(composizione);
		            
		        }	
	        }finally {
				
				try {
					
					if(ps != null)
						ps.close();
					
				}finally {
					
					DriverManagerConnectionPool.releaseConnection(conn);
				}
			}

	       
	        return listaComposizione;
	    
	    }
	
}
