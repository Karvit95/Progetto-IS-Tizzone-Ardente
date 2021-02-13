package control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrello;
import model.Composizione;
import model.ComposizioneDao;
import model.Effettuato;
import model.EffetuatoDao;
import model.IndirizzoOrdine;
import model.IndirizzoOrdineDao;
import model.Ordine;
import model.OrdineDao;
import model.ProdottoNelCarrello;
import model.Utente;

@WebServlet("/Acquisto")
public class Acquisto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Dati necessari per effettuare un acquisto
		String codiceFattura = (String) request.getSession().getAttribute("codiceFattura");
		LocalDate dataAcquisto = (LocalDate) request.getSession().getAttribute("dataAcquisto");
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
		ArrayList<ProdottoNelCarrello> prodottiNelCarrello = carrello.getCarrello();
		IndirizzoOrdine indirizzoOrdine = (IndirizzoOrdine) request.getSession().getAttribute("indirizzoOrdine");
		
		Ordine ordine = new Ordine(codiceFattura);
		OrdineDao ordineDao = new OrdineDao();
		
		Effettuato effettuato = new Effettuato(utente.getEmail(), codiceFattura, dataAcquisto);
		EffetuatoDao effettuatoDao = new EffetuatoDao();
		
		IndirizzoOrdine indirizzo = new IndirizzoOrdine(codiceFattura, indirizzoOrdine);
		IndirizzoOrdineDao indirizzoOrdineDao = new IndirizzoOrdineDao();
		
		Composizione c;
		ComposizioneDao cDao = new ComposizioneDao();
		
		//Salva sul db le info sull'acquisto
		try {
			
			ordineDao.doSave(ordine);
			effettuatoDao.doSave(effettuato);
			indirizzoOrdineDao.doSave(indirizzo);
			
			for(ProdottoNelCarrello po: prodottiNelCarrello) {
				
				c = new Composizione(po.getQuantità(), codiceFattura, 22, po.getProdotto().getId(), (po.getProdotto().getPrezzo()-po.getProdotto().getPrezzo()*po.getProdotto().getSconto()/100)*po.getQuantità());
				
					cDao.doSave(c);
				
			}
			
			//Svuota il carrello e rimuove i dati degli acquisti dalla sessione
			carrello.svuotaCarrello();
			request.getSession().setAttribute("carrello", carrello);
			request.getSession().removeAttribute("codiceFattura");
			request.getSession().removeAttribute("dataAcquisto");
			request.getSession().removeAttribute("indirizzoOrdine");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		//Reindirizza alla pagina di acquisto riuscito
		response.sendRedirect("acquistoRiuscito.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
