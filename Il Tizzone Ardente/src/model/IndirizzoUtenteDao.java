package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IndirizzoUtenteDao {
	
    public synchronized void doSave(IndirizzoUtente ind) throws SQLException {
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = ("insert into indirizzo_utente (Email, Città, Indirizzo, Provincia, NumeroCivico, CAP) values (?,?,?,?,?,?)");
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, ind.getEmail());
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
    
    public synchronized ArrayList<IndirizzoUtente> doRetrieve() throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        IndirizzoUtente indirizzoUtente;
        ArrayList<IndirizzoUtente>listaIndirizzi = new ArrayList<IndirizzoUtente>();
        
        String sql = ("Select * from indirizzo_utente");
        
        try {
        	
        	conn = DriverManagerConnectionPool.getConnection();
        	
        	ps=conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            while (rs.next()){
                
                String email, città, indirizzo, provincia, cap;
                int numeroCivico;
                 
                email = rs.getString("Email");
                città = rs.getString("Città");
                indirizzo = rs.getString("Indirizzo");
                provincia = rs.getString("Provincia");
                numeroCivico = rs.getInt("NumeroCivico");
                cap = rs.getString("CAP");
                
                indirizzoUtente = new IndirizzoUtente (email, città, indirizzo, provincia, numeroCivico, cap);
                
                listaIndirizzi.add(indirizzoUtente);
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
   
    
    public synchronized IndirizzoUtente doRetrieveByKey(String emailKey) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        IndirizzoUtente indirizzoUtente = new IndirizzoUtente();
        
        String sql = "SELECT * FROM indirizzo_utente WHERE Email = ?";
        
        try {
        	
        	conn = DriverManagerConnectionPool.getConnection();
        	
        	ps = conn.prepareStatement(sql);
            ps.setString(1, emailKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                
            	String email, città, indirizzo, provincia, cap;
                int numeroCivico;
                  
                email = rs.getString("Email");
                città = rs.getString("Città");
                indirizzo = rs.getString("Indirizzo");
                provincia = rs.getString("Provincia");
                numeroCivico = rs.getInt("NumeroCivico");
                cap = rs.getString("CAP");
                
                indirizzoUtente = new IndirizzoUtente (email, città, indirizzo, provincia, numeroCivico, cap);
                            
            }
        }finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}

        return indirizzoUtente;
    
    }
    
    public synchronized boolean doDelete(String emailKey) throws SQLException{
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
    	int result = 0;
    	
    	String sql = "DELETE from indirizzo_utente WHERE Email = ?";
    	
    	try {
    		
    		conn = DriverManagerConnectionPool.getConnection();
    		
    		ps = conn.prepareStatement(sql);
        	ps.setString(1, emailKey);
        	
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
    
}

