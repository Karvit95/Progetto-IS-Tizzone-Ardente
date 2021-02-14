package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Effettuato;

public class EffetuatoDao {
    
    public synchronized void doSave(Effettuato e) throws SQLException {
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = ("insert into effettuare (Email, CodiceFattura, DataDiAcquisto) values (?,?,?)");
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, e.getEmail());
			ps.setString(2, e.getCodiceFattura());
			ps.setDate(3, Date.valueOf(e.getDataAcquisto()));
	                       
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
    
    public synchronized ArrayList<Effettuato> doRetrieve() throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        ArrayList<Effettuato> listaEffettuato = new ArrayList<Effettuato>();
        
        String sql = ("Select * from effettuare order by CodiceFattura");
        
        try {
        	
        	conn = DriverManagerConnectionPool.getConnection();
        	ps=conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            
            while (rs.next()){
                
                String email, codiceFattura;
                LocalDate dataAcquisto;
                 
                email = rs.getString("Email");
                codiceFattura = rs.getString("CodiceFattura");
                dataAcquisto = rs.getDate("DataDiAcquisto").toLocalDate();
                
                Effettuato e = new Effettuato (email, codiceFattura, dataAcquisto);
                
                listaEffettuato.add(e);
        	
            }
        }finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        return listaEffettuato;
    
    }
   
    public synchronized Effettuato doRetrieveByKey(String key) throws SQLException{ 
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
    	Effettuato e = new Effettuato();
        
        String sql = "SELECT * FROM effettuare WHERE CodiceFattura = ?";
        
        try {
        	
        	conn = DriverManagerConnectionPool.getConnection();
        	
        	ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                
            	String email, codiceFattura;
                LocalDate dataAcquisto;
                
            	email = rs.getString("Email");
            	codiceFattura = rs.getString("CodiceFattura");
            	dataAcquisto = rs.getDate("DataDiAcquisto").toLocalDate();
                
                e = new Effettuato (email, codiceFattura, dataAcquisto);
                       
            }
        }finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        
        return e;
    
    }
    
    public synchronized ArrayList<Effettuato> doRetrieveByUtente(String emailKey) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        ArrayList<Effettuato> listaEffettuato = new ArrayList<Effettuato>();
        
        String sql = "SELECT * FROM effettuare WHERE Email = ?";
         
        try {
        	
        	conn = DriverManagerConnectionPool.getConnection();
        	
        	ps=conn.prepareStatement(sql);
        	ps.setString(1, emailKey);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                
                String email, codiceFattura;
                LocalDate dataAcquisto;
                 
                email = rs.getString("Email");
                codiceFattura = rs.getString("CodiceFattura");
                dataAcquisto = rs.getDate("DataDiAcquisto").toLocalDate();
                
                Effettuato e = new Effettuato (email, codiceFattura, dataAcquisto);
                
                listaEffettuato.add(e);
        	
            }
        }finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        return listaEffettuato;
    } 
}
