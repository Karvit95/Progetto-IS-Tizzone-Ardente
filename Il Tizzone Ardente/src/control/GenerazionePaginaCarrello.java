package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrello;
import model.ProdottoConIllustrazione;
import model.ProdottoConIllustrazioneDao;
import model.ProdottoOrdinato;

@WebServlet("/GenerazionePaginaCarrello")
public class GenerazionePaginaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("carrello") != null) {
			ProdottoConIllustrazioneDao pDao = new ProdottoConIllustrazioneDao();
			ProdottoOrdinato prodottoOrdinato;
			ProdottoConIllustrazione p = new ProdottoConIllustrazione();
		
			Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
			ArrayList<ProdottoOrdinato> prodottiNelCarrello = carrello.getCarrello();
			ArrayList<ProdottoOrdinato> prodottiAggiornati = new ArrayList<ProdottoOrdinato>();
		
			for(ProdottoOrdinato po: prodottiNelCarrello) {
			
				try {
				
					p = pDao.doRetrieveByKey(po.getProdottoIllustrato().getProdotto().getId());
			
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			
				prodottoOrdinato = new ProdottoOrdinato(p, po.getQuantità());
				prodottiAggiornati.add(prodottoOrdinato);
			}
		
			carrello.setCarrello(prodottiAggiornati);
			request.getSession().setAttribute("carrello", carrello);
		}
		
		response.sendRedirect("carrello.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
