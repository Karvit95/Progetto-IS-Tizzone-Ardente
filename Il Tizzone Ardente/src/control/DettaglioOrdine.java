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

import dao.ComposizioneDao;
import dao.EffetuatoDao;
import dao.ProdottoDao;
import dao.UtenteDao;
import model.Composizione;
import model.ProdottoAcquistato;
import model.Effettuato;
import model.DettagliOrdine;
import model.Prodotto;
import model.Utente;

@WebServlet("/DettaglioOrdine")
public class DettaglioOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd;
		
		//Codice fattura è necessatio per generare l'oggetto che rappresenta il dettallio dell'ordine
		String codiceFattura = request.getParameter("fattura");
		
		Effettuato effettuato = new Effettuato();
		ArrayList<Composizione> listaComposizione = new ArrayList<Composizione>();
		DettagliOrdine dettagliOrdine;
		Utente utente = new Utente();
		Prodotto prodotto;
		ProdottoAcquistato prodottoAcquistato;
		ArrayList<ProdottoAcquistato> listaProdottiAcquistati = new ArrayList<ProdottoAcquistato>();
		double prezzoTotale = 0;
		
		EffetuatoDao effettuatoDao = new EffetuatoDao();
		ComposizioneDao composizioneDao = new ComposizioneDao();
		UtenteDao utenteDao = new UtenteDao();
		ProdottoDao prodottoDao = new ProdottoDao();
		
		try {
			
			//Recupera dal db i dati relativi all'ordine effettuato da un utente con specificato un codice fattura
			effettuato = effettuatoDao.doRetrieveByKey(codiceFattura);
			listaComposizione = composizioneDao.doRetrieveByKey(codiceFattura);
			utente = utenteDao.doRetrieveByKey(effettuato.getEmail());
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
		//Recupera le informazioni sui prodotti acquistati nell'ordine
		for(Composizione composizione: listaComposizione) {
			
			try {
				
				prodotto = prodottoDao.doRetrieveProdottiEIllustrazioneByKey(composizione.getIdProdotto());
				prodottoAcquistato = new ProdottoAcquistato(prodotto, composizione);
				listaProdottiAcquistati.add(prodottoAcquistato);
				
			} catch (SQLException e) {
	
				e.printStackTrace();
			
			}
			
			// calcola il prezzo totale che è stato pagato
			prezzoTotale += composizione.getPrezzoPagato();
			
		}	
		
		//Genera l'oggetto che rappresenta il dettaglio dell'ordine
		dettagliOrdine = new DettagliOrdine(codiceFattura, effettuato.getEmail(), effettuato.getDataAcquisto(), listaProdottiAcquistati, prezzoTotale);
		
		//Invia i dati al front-end che visualizza il dettaglio dell'ordine
		request.setAttribute("dettagliOrdine", dettagliOrdine);
		request.setAttribute("utente", utente);
		rd = request.getRequestDispatcher("dettaglioOrdine.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	
	}

}
