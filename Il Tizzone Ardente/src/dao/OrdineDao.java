package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Ordine;

public class OrdineDao {
    
    public synchronized void doSave(Ordine o) throws SQLException {
    	
    	Connection conn = null;
		PreparedStatement ps = null;
	
		String sql = ("insert into ordine (CodiceFattura) values (?)");
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, o.getCodiceFattura());
	     
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
    
    public synchronized ArrayList<Ordine> doRetrieve() throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
        ArrayList<Ordine> listaOrdine = new ArrayList<Ordine>();
        
        String sql = ("Select * from ordine order by CodiceFattura");
        
        try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			 ps=conn.prepareStatement(sql);
		     ResultSet rs = ps.executeQuery(sql);
		        
		     while (rs.next()){
		            
		    	 String codiceFattura;
		             
		         codiceFattura = rs.getString("CodiceFattura");
		            
		         Ordine o = new Ordine (codiceFattura);
		            
		         listaOrdine.add(o);
		            
		     }
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}

        return listaOrdine;
    
    }
   
    public synchronized Ordine doRetrieveByKey(String key) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		
    	Ordine o = new Ordine();
        
        String sql = "SELECT * FROM ordine WHERE CodiceFattura = ?";
        
        try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement(sql);
	        ps.setString(1, key);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()){
	            
	        	String codiceFattura;
	              
	        	codiceFattura = rs.getString("CodiceFattura");
	        	
	            o = new Ordine (codiceFattura);
	                        
	        }
		}finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        
        return o;
    
    }
}
