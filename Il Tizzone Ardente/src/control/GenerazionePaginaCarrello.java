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
import model.Prodotto;
import model.ProdottoDao;
import model.ProdottoNelCarrello;

@WebServlet("/GenerazionePaginaCarrello")
public class GenerazionePaginaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Se il carrello è vuoto non esegue queste operazioni e va direttamente alla pagina del carrello che visualizzerà un messaggio che informa l'utente che il carrello è vuoto
		if(request.getSession().getAttribute("carrello") != null) {
			ProdottoDao prodottoDao = new ProdottoDao();
			ProdottoNelCarrello prodottoNelCarrello;
			Prodotto prodotto = new Prodotto();
		
			Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
			ArrayList<ProdottoNelCarrello> prodottiNelCarrello = carrello.getCarrello();
			ArrayList<ProdottoNelCarrello> prodottiAggiornati = new ArrayList<ProdottoNelCarrello>();
		
			for(ProdottoNelCarrello po: prodottiNelCarrello) {
			
				//Mentre che l'utente naviga sul sito, un prodotto potrebbe essere stato modificato (esempio prezzo, sconto),
				// quindi ci si assicura che il prodotto sia correttamente aggiornato anche nel carrello 
				try {
				
					prodotto = prodottoDao.doRetrieveProdottiEIllustrazioneByKey(po.getProdotto().getId());
			
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			
				prodottoNelCarrello = new ProdottoNelCarrello(prodotto, po.getQuantità());
				prodottiAggiornati.add(prodottoNelCarrello);
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
