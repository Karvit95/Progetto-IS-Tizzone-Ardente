package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdottoDao;

@WebServlet("/ModificaProdotto")
public class ModificaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		ProdottoDao pDao = new ProdottoDao();
		boolean risultatoModificaProdotto = false;
		String idProdotto;
		int sceltaModifica = Integer.parseInt(request.getParameter("sceltaModifica"));
		
		
		switch(sceltaModifica) {
			
			//modifica prezzo
			case 0: 
				
				idProdotto = request.getParameter("idModificaPrezzoProdotto");
				double nuovoPrezzo = Double.parseDouble(request.getParameter("nuovoPrezzo"));
			
				try {
					
					risultatoModificaProdotto = pDao.cambioPrezzo(idProdotto, nuovoPrezzo);
					
				} catch (SQLException e) {
				
					request.setAttribute("erroreDB", "errore");
					rd = request.getRequestDispatcher("areaAmministratore.jsp");
					rd.forward(request, response);
				
				}
				
				//controlla se il cambio prezzo è riuscito
				if(risultatoModificaProdotto) {
					
					request.setAttribute("cambioPrezzoRiuscito", "OK");
					rd = request.getRequestDispatcher("areaAmministratore.jsp");
			
				}
				
				else {
					
					request.setAttribute("prodottoNonTrovato", "KO");
					rd = request.getRequestDispatcher("areaAmministratore.jsp");
					rd.forward(request, response);
					
				}
					
				break;
			
			//modifica lo sconto
			case 1: 
				
				idProdotto = request.getParameter("idModificaScontoProdotto");
				int nuovoSconto = Integer.parseInt(request.getParameter("nuovoSconto"));
			
				try {
					
					risultatoModificaProdotto = pDao.cambioSconto(idProdotto, nuovoSconto);
					
				} catch (SQLException e) {
				
					request.setAttribute("erroreDB", "errore");
					rd = request.getRequestDispatcher("areaAmministratore.jsp");
					rd.forward(request, response);
				
				}
				
				//controlla se il cambio sconto è riuscito
				if(risultatoModificaProdotto) {
					
					request.setAttribute("cambioScontoRiuscito", "OK");
					rd = request.getRequestDispatcher("areaAmministratore.jsp");
					rd.forward(request, response);
					
				}
				
				else {
					
					request.setAttribute("prodottoNonTrovato", "KO");
					rd = request.getRequestDispatcher("areaAmministratore.jsp");
					rd.forward(request, response);
					
				}
					
				break;
			
			//modifica quantità
			case 2: 
				
				idProdotto = request.getParameter("idModificaQuantitaProdotto");
				int nuovaQuantita = Integer.parseInt(request.getParameter("nuovaQuantita"));
			
				try {
					
					risultatoModificaProdotto = pDao.cambioQuantita(idProdotto, nuovaQuantita);
					
				} catch (SQLException e) {
				
					request.setAttribute("erroreDB", "errore");
					rd = request.getRequestDispatcher("areaAmministratore.jsp");
					rd.forward(request, response);
				
				}
				
				
				//controlla se il cambio quantità è riuscito
				if(risultatoModificaProdotto) {
					
					request.setAttribute("cambioQuantitaRiuscito", "OK");
					rd = request.getRequestDispatcher("areaAmministratore.jsp");
					rd.forward(request, response);
					
				}
				
				else {
					
					request.setAttribute("prodottoNonTrovato", "KO");
					rd = request.getRequestDispatcher("areaAmministratore.jsp");
					rd.forward(request, response);
					
				}
					
				break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
