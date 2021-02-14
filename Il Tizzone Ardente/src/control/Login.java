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

@WebServlet("/Login")
public class Login extends HttpServlet {
     
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		UtenteDao utenteDao = new UtenteDao();
		Utente utente = new Utente();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			
			utente = utenteDao.doRetrieveByKey(email);
			
		} catch (SQLException e) {
			
			request.setAttribute("erroreDB", "errore");
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		
		}
	
		//Caso in cui l'utente non venga trovato all'interno del db
		if((utente.getEmail() == null)){
			
			request.setAttribute("emailNonTrovata", "emailnonesiste");
			
			response.getWriter().append("Login fallito");
			
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		
		//Caso l'utente e la password corrispondono
		else if(utente.getPassword().equals(password)){
			
			response.getWriter().append("Login riuscito");
			request.getSession().setAttribute("utente", utente);
			
			response.sendRedirect("home.jsp");
			
		}
		
		//Caso in cui l'utente viene trovato ma ha sbagliato a scrivere la password 
		else{
			
			request.setAttribute("PasswordErrata", "PasswordErrata");
			
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}
}
