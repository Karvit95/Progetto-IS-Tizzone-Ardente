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

import model.Illustrazione;
import model.IllustrazioneDao;
import model.Prodotto;
import model.ProdottoDao;

@WebServlet("/InserimentoProdotto")
public class InserimentoProdotto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		Prodotto prodotto;
		ProdottoDao pDao = new ProdottoDao();
		Illustrazione illustrazione;
		IllustrazioneDao iDao = new IllustrazioneDao();
		
		RequestDispatcher rd;
		
		String id;
		String nome = request.getParameter("nome");
		String modello = request.getParameter("modello");
		String catalogo = request.getParameter("catalogo");
		String materiale = request.getParameter("materiale");
		double peso = Double.parseDouble(request.getParameter("peso"));
		double prezzo = Double.parseDouble(request.getParameter("prezzo"));
		String descrizione = request.getParameter("descrizione");
		String url = request.getParameter("immagine");
		
		int count = 10;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			
		}
		
		id = builder.toString();
		
		try{
			
			prodotto = new Prodotto(id, peso, nome, modello, catalogo, materiale, prezzo, 0, descrizione, 0);
			pDao.doSave(prodotto);
			illustrazione = new Illustrazione (id, url);
			iDao.doSave(illustrazione);
			request.setAttribute("inserimentoRiuscito", "successo");
			rd = request.getRequestDispatcher("areaAmministratore.jsp");
			rd.forward(request, response);
			
		}catch(SQLIntegrityConstraintViolationException e){
			
			request.setAttribute("erroreInserimento", "errore");
			rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			
		}catch(SQLException e){
			
			request.setAttribute("erroreDB", "errore");
			rd = request.getRequestDispatcher("areaAmministratore.jsp");
			rd.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
}
