package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtenteDao;
import model.Utente;

@WebServlet("/CambioPassword")
public class CambioPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		UtenteDao utenteDao = new UtenteDao();
		
		//Dati dell'utente
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		String email = utente.getEmail();
		String passwordAttuale = utente.getPassword();
		
		//Password attuale dell'account
		String passwordAttualeInserita = request.getParameter("passwordAttuale");
		
		//Password nuova 
		String nuovaPassword = request.getParameter("up");
		
		//Controlla se la password attuale inserita dall'utente corrisponde a quella dell'utente
		if(!passwordAttuale.equals(passwordAttualeInserita)){
			
			//se la password attuale inserita dall'utente è diversa dalla password dell'account visualizza un messaggio di errore
			request.setAttribute("PasswordErrata", "passwordErrata");
			rd = request.getRequestDispatcher("cambioPassword.jsp");
			rd.forward(request, response);
			
		}
		
		else{
			
			try {
				
				//Effettua il cambio della password su db
				utenteDao.cambioPassword(email, nuovaPassword);
				utente.setPassword(nuovaPassword);
				request.getSession().setAttribute("utente", utente);
				request.setAttribute("successoCambioPassword", "successo");
				rd = request.getRequestDispatcher("cambioPassword.jsp");
				rd.forward(request, response);
		
			} catch (SQLException e) {
			
				request.setAttribute("erroreDB", "errore");
				rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
		
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
}
