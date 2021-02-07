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

@WebServlet("/Ricerca")
public class Ricerca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ricerca = request.getParameter("ricerca");
		ArrayList<ProdottoConIllustrazione> risultatoRicerca = new ArrayList<ProdottoConIllustrazione>();
		ProdottoConIllustrazioneDao pciDao = new ProdottoConIllustrazioneDao();
		RequestDispatcher rd;
		
		try {
			
			risultatoRicerca = pciDao.doRetrieveByNome(ricerca);
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
