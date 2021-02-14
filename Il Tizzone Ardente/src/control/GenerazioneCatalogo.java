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

import dao.ProdottoDao;
import model.Prodotto;


@WebServlet("/GenerazioneCatalogo")
public class GenerazioneCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		ArrayList<Prodotto> elencoProdotti = new ArrayList<Prodotto>();
		ProdottoDao prodottoDao = new ProdottoDao();
		
		String nomeCatalogo = request.getParameter("nomeCatalogo");
		
		try{
			
			//Recupera dal db i prodotti che fanno parte del catalogo specificato
			elencoProdotti = prodottoDao.doRetrieveByCatalogo(nomeCatalogo);
			
		}catch(SQLException e){
			
			request.setAttribute("erroreDB", "errore");
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			
		}
		
		//Invia i dati al front end, in modo da poter visualizzare i prodotti
		request.setAttribute("elenco", elencoProdotti);
		rd = request.getRequestDispatcher("elenco.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	
	}
}
