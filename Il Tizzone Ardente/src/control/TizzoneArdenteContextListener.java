package control;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.DriverManagerConnectionPool;
import model.ProdottoConIllustrazione;
import model.ProdottoConIllustrazioneDao;

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
       
    	ProdottoConIllustrazioneDao pciDao = new ProdottoConIllustrazioneDao();
		ArrayList<ProdottoConIllustrazione> listaProdotti = new ArrayList<ProdottoConIllustrazione>();
		ArrayList<ProdottoConIllustrazione> listaProdottiScontati = new ArrayList<ProdottoConIllustrazione>();
		
		try {
			
			listaProdotti = pciDao.doRetrieve();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		for(ProdottoConIllustrazione pci: listaProdotti) {
			
			if(pci.getProdotto().getSconto() != 0)
				listaProdottiScontati.add(pci);
			
		}
		
		listaProdotti.removeAll(listaProdottiScontati);
		
		sce.getServletContext().setAttribute("galleriaImmagini", listaProdotti);
		sce.getServletContext().setAttribute("galleriaImmaginiSconti", listaProdottiScontati);
    }
	
}
