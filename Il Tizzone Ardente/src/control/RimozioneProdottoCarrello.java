package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;

@WebServlet("/RimozioneProdottoCarrello")
public class RimozioneProdottoCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		
		Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
		
		//rimuove il prodotto dal carrello e aggiorna la sessione
		carrello.rimuoviProdottoCarrello(id);
		
		session.setAttribute("carrello", carrello );
		
		response.sendRedirect("GenerazionePaginaCarrello");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
