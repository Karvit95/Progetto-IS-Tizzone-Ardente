package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IndirizzoOrdine;
import model.IndirizzoUtente;
import model.IndirizzoUtenteDao;
import model.Utente;

@WebServlet("/Spedizione")
public class Spedizione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int value = Integer.parseInt(request.getParameter("value"));
		
		HttpSession session = request.getSession();
		Utente utente = (Utente) session.getAttribute("utente");
		
		//L'utente decide di utilizzare l'indirizzo con cui si è registrato
		if(value == 0) {
			
			IndirizzoUtente indirizzoUtente = new IndirizzoUtente();
			IndirizzoUtenteDao indirizzoUtenteDao = new IndirizzoUtenteDao();
			
			try {
				
				indirizzoUtente = indirizzoUtenteDao.doRetrieveByKey(utente.getEmail());
				IndirizzoOrdine indirizzo = new IndirizzoOrdine(indirizzoUtente.getCittà(), indirizzoUtente.getIndirizzo(), indirizzoUtente.getProvincia(), indirizzoUtente.getNumeroCivico(), indirizzoUtente.getCap());
				session.setAttribute("indirizzoOrdine", indirizzo);
				response.sendRedirect("pagamento.jsp");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}	
		}
		
		//Se l'utente vuole inserire un indirizzo diverso da quello con cui si è registrato
		else if(value==1) {
			
			String città = request.getParameter("citta");
			String indirizzo = request.getParameter("Indirizzo");
			String provincia = request.getParameter("Provincia");
			int numeroCivico = Integer.parseInt(request.getParameter("NumeroCivico"));
			String cap = request.getParameter("CAP");
			
			IndirizzoOrdine indirizzoOrdine = new IndirizzoOrdine(città, indirizzo, provincia, numeroCivico, cap);
			session.setAttribute("indirizzoOrdine", indirizzoOrdine);
			response.sendRedirect("pagamento.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
