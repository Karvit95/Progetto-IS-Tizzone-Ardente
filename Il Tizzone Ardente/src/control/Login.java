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

@WebServlet("/Login")
public class Login extends HttpServlet {
     
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		UtenteDao uDao = new UtenteDao();
		Utente utente = new Utente();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			
			utente = uDao.doRetrieveByKey(email);
			
		} catch (SQLException e) {
			
			request.setAttribute("erroreDB", "errore");
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		
		}
	
		if((utente.getEmail() == null)){
			
			request.setAttribute("emailNonTrovata", "emailnonesiste");
			
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		
		else if(utente.getPassword().equals(password)){
			
			request.getSession().setAttribute("utente", utente);
			
			response.sendRedirect("home.jsp");
			
		}
		
		else{
			
			request.setAttribute("PasswordErrata", "PasswordErrata");
			
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
}
