package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Effettuato;
import model.EffetuatoDao;
import model.Utente;

@WebServlet("/ListaOrdiniUtente")
public class ListaOrdiniUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		EffetuatoDao effettuatoDao = new EffetuatoDao();
		ArrayList<Effettuato> listaEffettuato = new ArrayList<Effettuato>();
		
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		String email = utente.getEmail();
				
		try {
			
			//recupera dal database gli ordini effettuati dall'utente
			listaEffettuato = effettuatoDao.doRetrieveByUtente(email);
			request.setAttribute("ordini", listaEffettuato);
			rd = request.getRequestDispatcher("listaOrdiniUtente.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
