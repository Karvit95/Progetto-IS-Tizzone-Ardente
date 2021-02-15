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

import dao.IllustrazioneDao;
import dao.ProdottoDao;

@WebServlet("/EliminazioneProdotto")
public class EliminazioneProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProdottoDao prodottoDao;
	IllustrazioneDao illustrazioneDao;
	
	@Override
	public void init() throws ServletException {
		prodottoDao = new ProdottoDao();
		illustrazioneDao = new IllustrazioneDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd; 
		
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
			
			response.getWriter().append("Eliminazione prdotto non riuscita");
			
			request.setAttribute("prodottoNonTrovato", "KO");
			rd = request.getRequestDispatcher("areaAmministratore.jsp");
			rd.forward(request, response);
			
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

	public ProdottoDao getProdottoDao() {
		return prodottoDao;
	}

	public void setProdottoDao(ProdottoDao prodottoDao) {
		this.prodottoDao = prodottoDao;
	}

	public IllustrazioneDao getIllustrazioneDao() {
		return illustrazioneDao;
	}

	public void setIllustrazioneDao(IllustrazioneDao illustrazioneDao) {
		this.illustrazioneDao = illustrazioneDao;
	}
}
