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

import model.Prodotto;
import model.ProdottoDao;

@WebServlet("/Ricerca")
public class Ricerca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ricerca = request.getParameter("ricerca");
		ArrayList<Prodotto> risultatoRicerca = new ArrayList<Prodotto>();
		ProdottoDao prodottoDao = new ProdottoDao();
		RequestDispatcher rd;
		
		try {
			
			//Recupera dal db i prodotti cercati dall'utente
			risultatoRicerca = prodottoDao.ricerca(ricerca);
			request.setAttribute("elenco", risultatoRicerca);
			rd = request.getRequestDispatcher("elenco.jsp");
			rd.forward(request, response);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);

	}

}
