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
		
		ProdottoDao pDao = new ProdottoDao();
		IllustrazioneDao iDao = new IllustrazioneDao();
		
		String id = request.getParameter("idProdotto");
		boolean risultatoCancellazione = false;
		
		try{
			
			iDao.doDelete(id);
			risultatoCancellazione = pDao.doDelete(id);
			
		}catch(SQLIntegrityConstraintViolationException e){
			
			request.setAttribute("erroreDB", "errore");
			rd = request.getRequestDispatcher("areaAmministratore.jsp");
			rd.forward(request, response);

		}catch(SQLException e){
						
			request.setAttribute("erroreDB", "errore");
			rd = request.getRequestDispatcher("areaAmministratore.jsp");
			rd.forward(request, response);
			
		}
		
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
