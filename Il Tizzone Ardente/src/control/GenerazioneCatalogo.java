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

import model.ProdottoConIllustrazione;
import model.ProdottoConIllustrazioneDao;

@WebServlet("/GenerazioneCatalogo")
public class GenerazioneCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		ArrayList<ProdottoConIllustrazione> elencoProdotti = new ArrayList<ProdottoConIllustrazione>();
		ProdottoConIllustrazioneDao pciDao = new ProdottoConIllustrazioneDao();
		
		String nomeCatalogo = request.getParameter("nomeCatalogo");
		
		try{
			
			elencoProdotti = pciDao.doRetrieveByCatalogo(nomeCatalogo);
			
		}catch(SQLException e){
			
			request.setAttribute("erroreDB", "errore");
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			
		}
		
		request.setAttribute("elenco", elencoProdotti);
		rd = request.getRequestDispatcher("elenco.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	
	}
}
