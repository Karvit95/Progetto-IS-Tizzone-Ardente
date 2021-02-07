package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import model.UtenteDao;

@WebServlet("/CambioPassword")
public class CambioPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		UtenteDao uDao = new UtenteDao();
		
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		String email = utente.getEmail();
		String passwordAttuale = utente.getPassword();
		
		String passwordAttualeInserita = request.getParameter("passwordAttuale");
		
		String nuovaPassword = request.getParameter("up");
		
		if(!passwordAttuale.equals(passwordAttualeInserita)){
			
			request.setAttribute("PasswordErrata", "passwordErrata");
			rd = request.getRequestDispatcher("cambioPassword.jsp");
			rd.forward(request, response);
			
		}
		
		else{
			
			try {
			
				uDao.cambioPassword(email, nuovaPassword);
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
