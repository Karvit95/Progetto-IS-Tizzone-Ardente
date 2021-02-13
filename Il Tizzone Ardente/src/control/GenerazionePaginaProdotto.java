package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Illustrazione;
import model.IllustrazioneDao;
import model.Prodotto;
import model.ProdottoDao;

@WebServlet("/GenerazionePaginaProdotto")
public class GenerazionePaginaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		
		IllustrazioneDao illustrazioneDao = new IllustrazioneDao();
		Illustrazione illustrazione = new Illustrazione();
		
		ProdottoDao prodottoDao = new ProdottoDao();
		Prodotto prodotto = new Prodotto();
		
		
		String idProdotto = request.getParameter("id");
		
		try {
			
			//Recupera dal db il prodotto e la sua immagine
			prodotto = prodottoDao.doRetrieveByKey(idProdotto);
			illustrazione = illustrazioneDao.doRetrieveByKey(idProdotto);
			
			request.setAttribute("immagine", illustrazione);
			request.setAttribute("prodotto", prodotto);
			rd = request.getRequestDispatcher("prodotto.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			
			request.setAttribute("erroreDB", "errore");
			rd = request.getRequestDispatcher("elenco.jsp");
			rd.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
}
