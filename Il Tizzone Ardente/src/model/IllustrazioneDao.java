package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IllustrazioneDao {
    
    public synchronized void doSave(Illustrazione i) throws SQLException {
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = ("insert into illustrazione (URL, IDProdotto) values (?,?)");
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, i.getUrl());
			ps.setString(2, i.getId());
	                       
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
    

   
    public synchronized Illustrazione doRetrieveByKey(String key) throws SQLException{
        
    	Connection conn = null;
		PreparedStatement ps = null;
		Illustrazione i = new Illustrazione();
        
        String sql = "SELECT * FROM illustrazione WHERE IDProdotto = ?";
        
        try {
			
			conn = DriverManagerConnectionPool.getConnection();
			ps = conn.prepareStatement(sql);
	        ps.setString(1, key);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()){
	            
	        	String id, url;
	              
	            id = rs.getString("IDProdotto");
	            url = rs.getString("URL");
	            
	            i = new Illustrazione (id, url);
			
	        }
	        
        }finally {
			
			try {
				
				if (ps != null)
					ps.close();
				
			} finally {
				
				DriverManagerConnectionPool.releaseConnection(conn);
				
			}
		}
        
        return i;
    
    }
    
    public synchronized boolean doDelete(String key) throws SQLException{
    	
    	Connection conn = null;
		PreparedStatement ps = null;
		
    	int result = 0;
    	
    	String sql = "DELETE from illustrazione WHERE IDProdotto = ?";
    	
    	try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			ps = conn.prepareStatement(sql);
	    	ps.setString(1, key);
	    	
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
