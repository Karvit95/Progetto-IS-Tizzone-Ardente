package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import model.Utente;

public class UtenteDao {
    
    public synchronized void doSave(Utente u) throws SQLException, SQLIntegrityConstraintViolationException {
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "insert into utente (Email, Nome, Cognome, NumeroDiTelefono, Password, Amministratore) values (?,?,?,?,?,?)";
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getNome());
			ps.setString(3, u.getCognome());
	        ps.setString(4, u.getNumeroTelefono());
	        ps.setString(5, u.getPassword());
	        ps.setBoolean(6, u.isAmministratore());
	        
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
    
    public synchronized ArrayList<Utente> doRetrieve() throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
        
        String sql = ("Select * from utente");
        
        try {
        	
        	conn = DriverManagerConnectionPool.getConnection();
        	ps = conn.prepareStatement(sql);
        	
        	ResultSet rs = ps.executeQuery();
        	
        	while (rs.next()){
                
                String email, nome, cognome, numeroTelefono, password;
                boolean amministratore;
                 
                email = rs.getString("Email");
                nome = rs.getString("Nome");
                cognome = rs.getString("Cognome");
                numeroTelefono = rs.getString("NumeroDiTelefono");
                password = rs.getString("password");
                amministratore = rs.getBoolean("Amministratore");
                
                Utente utente = new Utente(email, nome, cognome, numeroTelefono, password, amministratore);
                
                listaUtenti.add(utente);
                
        	}	
                
        	}finally {
            	
        		try {
            		
    				if (ps != null)
    					ps.close();
    				
    			} finally {
    				
    				DriverManagerConnectionPool.releaseConnection(conn);
    				
    			}
            }
        
        return listaUtenti;
        
    }
            
    public synchronized Utente doRetrieveByKey(String emailKey) throws SQLException{
        
    	Connection conn = null;
        PreparedStatement ps = null;
      
        Utente utente = new Utente();
        
        String sql = "SELECT * FROM utente WHERE Email = ?";
        
        try {
        	
        	conn = DriverManagerConnectionPool.getConnection();
        	
        	ps = conn.prepareStatement(sql);
            ps.setString(1, emailKey);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                
            	String email, nome, cognome, numeroTelefono, password;
                boolean amministratore;
                  
                email = rs.getString("Email");
                nome = rs.getString("Nome");
                cognome = rs.getString("Cognome");
                numeroTelefono = rs.getString("NumeroDiTelefono");
                password = rs.getString("password");
                amministratore = rs.getBoolean("Amministratore");
               
                utente = new Utente(email, nome, cognome, numeroTelefono, password, amministratore);
            }      
            
        }finally {
        	
        	try {
        		
        		if(ps!=null)
        			ps.close();
            }finally {
            	
            	DriverManagerConnectionPool.releaseConnection(conn);
            }
        }
        
        return utente;
    
    }
    
    public synchronized boolean cambioPassword(String emailKey, String nuovaPassword) throws SQLException{
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	
    	int result = 0; 
    	
    	String sql ="UPDATE utente SET Password = ? WHERE Email = ?";
    	
    	try {
    		
    		conn = DriverManagerConnectionPool.getConnection();
    		ps = conn.prepareStatement(sql);
        	ps.setString(1, nuovaPassword);
        	ps.setString(2, emailKey);
        	
        	result = ps.executeUpdate();
        	
        	conn.commit();
    		
    	}finally {
    		try {
    			
    			if(ps!=null)
    				ps.close();
    			
    		}finally {
    			
    			DriverManagerConnectionPool.releaseConnection(conn);
    			
    		}
    	}
    	
    	return (result!=0);
        
    }
    
    public synchronized boolean doDelete(String emailKey) throws SQLException{
    	
    	Connection conn = null;
    	PreparedStatement ps = null;
    	
    	int result = 0;
    	
    	String sql = "DELETE from utente WHERE Email = ?";
    	
    	try {
    		
    		conn = DriverManagerConnectionPool.getConnection();
    		ps = conn.prepareStatement(sql);
    		ps.setString(1, emailKey);
    		
    		result = ps.executeUpdate();
    		
    		conn.commit();
    		
    	}finally {
    		
    		try {
    			
    			if(ps!=null)
    				ps.close();
    		}finally {
    			
    			DriverManagerConnectionPool.releaseConnection(conn);
    		}
    	}
    	
    	return (result != 0);
    	
    }
    
}
