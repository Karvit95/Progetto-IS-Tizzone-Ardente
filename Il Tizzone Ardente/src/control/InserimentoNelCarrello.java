package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Carrello;
import model.Prodotto;

@WebServlet("/InserimentoNelCarrello")
public class InserimentoNelCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		Prodotto p = gson.fromJson(request.getParameter("prodottoJson"), Prodotto.class);
		
		HttpSession session = request.getSession();
		Carrello carrello;
		
		synchronized(session) {
			
			carrello = (Carrello)session.getAttribute("carrello");
			
			if(carrello == null) {
				
				carrello = new Carrello();
				session.setAttribute("carrello", carrello);
				
			}
		}
		
		carrello.aggiungiProdottoCarrello(p);
		session.setAttribute("carrello", carrello );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
