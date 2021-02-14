package control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EffetuatoDao;
import model.Effettuato;

@WebServlet("/ListaOrdiniAmministratore")
public class ListaOrdiniAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		LocalDate dataInizio;
		LocalDate dataFine;
		String persona;
		
		EffetuatoDao effettuatoDao = new EffetuatoDao();
		
		ArrayList<Effettuato> listaOrdini = new ArrayList<Effettuato>();
		ArrayList<Effettuato> listaTemp = new ArrayList<Effettuato>();;
		
		try {
			
			listaOrdini = effettuatoDao.doRetrieve();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		//Recupera dal db tutti gli ordini compresi con data compresa tra "dataInizio" e "dataFine"
		if((request.getParameter("dataInizio") != null) && (request.getParameter("dataFine") != null) && !(request.getParameter("dataInizio").equals("")) && !(request.getParameter("dataFine").equals(""))) {

			
			dataInizio = LocalDate.parse(request.getParameter("dataInizio"));
		    dataFine = LocalDate.parse(request.getParameter("dataFine"));
		
			for(Effettuato e: listaOrdini) {
				
				if(e.getDataAcquisto().isBefore(dataInizio) || e.getDataAcquisto().isAfter(dataFine)) {
					
					listaTemp.add(e);
					
				}
			}
			
			listaOrdini.removeAll(listaTemp);
			listaTemp.clear();
		}
		
		//recupera gli ordini che sono stati effettuati da un utente
		if((request.getParameter("persona")!= null) && !(request.getParameter("persona").equals(""))) {
			
			persona = request.getParameter("persona");
			
			for(Effettuato e: listaOrdini) {
				
				if(!(e.getEmail().equals(persona))) {
				
					listaTemp.add(e);
					
				}
			}
			
			listaOrdini.removeAll(listaTemp);
			listaTemp.clear();
		}
		
		//Invia la lista degli ordini trovati al front-end
		request.setAttribute("ordini", listaOrdini);
		rd = request.getRequestDispatcher("visualizzaOrdiniAmministratore.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
