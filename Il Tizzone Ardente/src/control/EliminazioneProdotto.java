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

import model.IllustrazioneDao;
import model.ProdottoDao;

@WebServlet("/EliminazioneProdotto")
public class EliminazioneProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd; 
		
		ProdottoDao prodottoDao = new ProdottoDao();
		IllustrazioneDao illustrazioneDao = new IllustrazioneDao();
		
		//l'id del prodotto è necessario per identificare univocamente il prodotto che si desidera eliminare dal sito
		String id = request.getParameter("idProdotto");
		
		//Il risultato dell'operazione di cancellazione che dovrà essere visualizzato dall'amministratore
		boolean risultatoCancellazione = false;
		
		try{
			
			//Elimina il prodotto dal db, prima elimina la sua illustrazione e poi il prodotto vero e proprio
			illustrazioneDao.doDelete(id);
			risultatoCancellazione = prodottoDao.doDelete(id);
			
		}catch(SQLIntegrityConstraintViolationException e){
			
			request.setAttribute("erroreDB", "errore");
			rd = request.getRequestDispatcher("areaAmministratore.jsp");
			rd.forward(request, response);

		}catch(SQLException e){
						
			request.setAttribute("erroreDB", "errore");
			rd = request.getRequestDispatcher("areaAmministratore.jsp");
			rd.forward(request, response);
			
		}
		
		//Controlla se l'eliminazione del prodotto è andata a buon fine inviando un messaggio adatto al front end
		if(risultatoCancellazione) {
		
			request.setAttribute("eliminazioneRiuscita", "OK");
			rd = request.getRequestDispatcher("areaAmministratore.jsp");
			rd.forward(request, response);
		
		}
		
		else {
			
			request.setAttribute("prodottoNonTrovato", "KO");
			rd = request.getRequestDispatcher("areaAmministratore.jsp");
			rd.forward(request, response);
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
}
