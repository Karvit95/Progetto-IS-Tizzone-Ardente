package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.IndirizzoOrdine;

public class IndirizzoOrdineDao {
    
    public synchronized void doSave(IndirizzoOrdine ind) throws SQLException {
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = ("insert into indirizzo_ordine (CodiceFattura, Città, Indirizzo, Provincia, NumeroCivico, CAP) values (?,?,?,?,?,?)");
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, ind.getCodiceFattura());
			ps.setString(2, ind.getCittà());
			ps.setString(3, ind.getIndirizzo());
	        ps.setString(4, ind.getProvincia());
	        ps.setInt(5, ind.getNumeroCivico());
	        ps.setString(6, ind.getCap());
	                       
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
    
    public synchronized ArrayList<IndirizzoOrdine> doRetrieve() throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        IndirizzoOrdine indirizzoOrdine;
        ArrayList<IndirizzoOrdine> listaIndirizzi = new ArrayList<IndirizzoOrdine>();
        
        String sql = ("Select * from indirizzo_ordine");
        
        try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps=conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery(sql);
	        
	        while (rs.next()){
	            
	            String codiceFattura, città, indirizzo, provincia, cap;
	            int numeroCivico;
	             
	            codiceFattura = rs.getString("Email");
	            città = rs.getString("Città");
	            indirizzo = rs.getString("Indirizzo");
	            provincia = rs.getString("Provincia");
	            numeroCivico = rs.getInt("NumeroCivico");
	            cap = rs.getString("CAP");
	            
	            indirizzoOrdine = new IndirizzoOrdine (codiceFattura, città, indirizzo, provincia, numeroCivico, cap);
	            
	            listaIndirizzi.add(indirizzoOrdine);
	        }
        }finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        
        return listaIndirizzi;
    
    }
   
    
    public synchronized IndirizzoOrdine doRetrieveByKey(String key) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        IndirizzoOrdine indirizzoOrdine = new IndirizzoOrdine();
        
        String sql = "SELECT * FROM indirizzo_utente WHERE CodiceFattura = ?";
        
        try {
			
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement(sql);
	        ps.setString(1, key);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()){
	            
	        	String codiceFattura, città, indirizzo, provincia, cap;
	            int numeroCivico;
	              
	            codiceFattura = rs.getString("Email");
	            città = rs.getString("Città");
	            indirizzo = rs.getString("Indirizzo");
	            provincia = rs.getString("Provincia");
	            numeroCivico = rs.getInt("NumeroCivico");
	            cap = rs.getString("CAP");
	            
	            indirizzoOrdine = new IndirizzoOrdine (codiceFattura, città, indirizzo, provincia, numeroCivico, cap);
	                        
	        }
        }finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        
        return indirizzoOrdine;
    
    }
    
}
