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

import model.Composizione;
import model.ComposizioneConProdotto;
import model.ComposizioneDao;
import model.Effettuato;
import model.EffetuatoDao;
import model.OrdineCompleto;
import model.ProdottoConIllustrazione;
import model.ProdottoConIllustrazioneDao;
import model.Utente;
import model.UtenteDao;

@WebServlet("/DettaglioOrdine")
public class DettaglioOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd;
		
		String codiceFattura = request.getParameter("fattura");
		
		Effettuato ef = new Effettuato();
		ArrayList<Composizione> c = new ArrayList<Composizione>();
		OrdineCompleto oc;
		Utente u = new Utente();
		ProdottoConIllustrazione p;
		ComposizioneConProdotto cp;
		ArrayList<ComposizioneConProdotto> listaCp = new ArrayList<ComposizioneConProdotto>();
		double prezzoTotale = 0;
		
		EffetuatoDao eDao = new EffetuatoDao();
		ComposizioneDao cDao = new ComposizioneDao();
		UtenteDao uDao = new UtenteDao();
		ProdottoConIllustrazioneDao pDao = new ProdottoConIllustrazioneDao();
		
		try {
			
			ef = eDao.doRetrieveByKey(codiceFattura);
			c = cDao.doRetrieveByKey(codiceFattura);
			u = uDao.doRetrieveByKey(ef.getEmail());
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
		for(Composizione comp: c) {
			
			try {
				
				p = pDao.doRetrieveByKey(comp.getIDProdotto());
				cp = new ComposizioneConProdotto(p, comp);
				listaCp.add(cp);
				
			} catch (SQLException e) {
	
				e.printStackTrace();
			}
			prezzoTotale += comp.getPrezzoPagato();
			
		}	
		
		oc = new OrdineCompleto(codiceFattura, ef.getEmail(), ef.getDataAcquisto(), listaCp, prezzoTotale);
		
		request.setAttribute("dettagliOrdine", oc);
		request.setAttribute("utente", u);
		rd = request.getRequestDispatcher("dettaglioOrdine.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	
	}

}
