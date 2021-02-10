package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.DriverManagerConnectionPool;
import model.Prodotto;
import model.ProdottoDao;

@WebListener
public class TizzoneArdenteContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    	sce.getServletContext().removeAttribute("galleriaImmagini");
    	sce.getServletContext().removeAttribute("galleriaImmaginiSconti");
    	try {
    		
			DriverManagerConnectionPool.closeConnection();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
    }

    public void contextInitialized(ServletContextEvent sce)  { 
       
    	ProdottoDao prodottoDao = new ProdottoDao();
		ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
		ArrayList<Prodotto> listaProdottiScontati = new ArrayList<Prodotto>();
		
		try {
			
			listaProdotti = prodottoDao.doRetrieveProdottiEIllustrazione();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		for(Prodotto prodotto: listaProdotti) {
			
			if(prodotto.getSconto() != 0)
				listaProdottiScontati.add(prodotto);
			
		}
		
		listaProdotti.removeAll(listaProdottiScontati);
		
		sce.getServletContext().setAttribute("galleriaImmagini", listaProdotti);
		sce.getServletContext().setAttribute("galleriaImmaginiSconti", listaProdottiScontati);
    }
	
}
