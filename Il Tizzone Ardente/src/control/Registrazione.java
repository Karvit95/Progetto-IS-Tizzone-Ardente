package control;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.IndirizzoUtente;
import model.IndirizzoUtenteDao;
import model.Utente;
import model.UtenteDao;

@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtenteDao uDao = new UtenteDao();
		IndirizzoUtenteDao iuDao = new IndirizzoUtenteDao();
		
		RequestDispatcher rd;
		
		String nome = request.getParameter("Nome");
		String cognome = request.getParameter("Cognome");
		String email = request.getParameter("Email");
		String password = request.getParameter("up");
		String numeroTel = request.getParameter("NumTel");
		String città = request.getParameter("citta");
		String cap = request.getParameter("CAP");
		String provincia = request.getParameter("Provincia");
		String indirizzo = request.getParameter("Indirizzo");
		int numCivico = Integer.parseInt(request.getParameter("NumeroCivico"));
		
		Utente utente = new Utente(email, nome, cognome, numeroTel, password, false);
		IndirizzoUtente indirizzoUtente = new IndirizzoUtente(email, città, indirizzo, provincia, numCivico, cap);
		
		try{
			
			uDao.doSave(utente);
			iuDao.doSave(indirizzoUtente);
		
		}catch(SQLIntegrityConstraintViolationException e){
			
			e.printStackTrace();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}	
		
		request.getSession().setAttribute("utente", utente);
		request.setAttribute("successoRegistrazione", "successo");
		rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	
	}
}
