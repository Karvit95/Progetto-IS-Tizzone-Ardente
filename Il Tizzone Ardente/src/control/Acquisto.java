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
import model.ProdottoOrdinato;
import model.Utente;

@WebServlet("/Acquisto")
public class Acquisto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codiceFattura = (String) request.getSession().getAttribute("codiceFattura");
		LocalDate dataAcquisto = (LocalDate) request.getSession().getAttribute("dataAcquisto");
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
		ArrayList<ProdottoOrdinato> prodottiNelCarrello = carrello.getCarrello();
		IndirizzoOrdine indirizzoOrdine = (IndirizzoOrdine) request.getSession().getAttribute("indirizzoOrdine");
		
		Ordine o = new Ordine(codiceFattura);
		OrdineDao oDao = new OrdineDao();
		
		Effettuato ef = new Effettuato(utente.getEmail(), codiceFattura, dataAcquisto);
		EffetuatoDao eDao = new EffetuatoDao();
		
		IndirizzoOrdine indirizzo = new IndirizzoOrdine(codiceFattura, indirizzoOrdine);
		IndirizzoOrdineDao ioDao = new IndirizzoOrdineDao();
		
		Composizione c;
		ComposizioneDao cDao = new ComposizioneDao();
		
		try {
			
			oDao.doSave(o);
			eDao.doSave(ef);
			ioDao.doSave(indirizzo);
			
			for(ProdottoOrdinato po: prodottiNelCarrello) {
				
				c = new Composizione(po.getQuantità(), codiceFattura, 22, po.getProdottoIllustrato().getProdotto().getId(), (po.getProdottoIllustrato().getProdotto().getPrezzo()-po.getProdottoIllustrato().getProdotto().getPrezzo()*po.getProdottoIllustrato().getProdotto().getSconto()/100)*po.getQuantità());
				
					cDao.doSave(c);
				
			}
			
			carrello.svuotaCarrello();
			request.getSession().setAttribute("carrello", carrello);
			request.getSession().removeAttribute("codiceFattura");
			request.getSession().removeAttribute("dataAcquisto");
			request.getSession().removeAttribute("indirizzoOrdine");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		response.sendRedirect("acquistoRiuscito.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
