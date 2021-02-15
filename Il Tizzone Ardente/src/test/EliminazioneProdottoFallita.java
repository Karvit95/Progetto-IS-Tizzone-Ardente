package test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import control.EliminazioneProdotto;
import dao.IllustrazioneDao;
import dao.ProdottoDao;
import junit.framework.TestCase;

public class EliminazioneProdottoFallita extends TestCase {

	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	
	@Mock
	RequestDispatcher rd;
	
	@Mock
	ProdottoDao prodottoDao;
	@Mock
	IllustrazioneDao illustrazioneDao;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void test() throws Exception{
		
		EliminazioneProdotto eliminazioneProdotto = new EliminazioneProdotto();
		
		String idProdotto = "idNonPresente";
		
		when(request.getParameter("idProdotto")).thenReturn(idProdotto);
		when(illustrazioneDao.doDelete(idProdotto)).thenReturn(false);
		when(prodottoDao.doDelete(idProdotto)).thenReturn(false);
		when(request.getRequestDispatcher("areaAmministratore.jsp")).thenReturn(rd);
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);
		
		eliminazioneProdotto.setProdottoDao(prodottoDao);
		eliminazioneProdotto.setIllustrazioneDao(illustrazioneDao);
		eliminazioneProdotto.doGet(request, response);
		
		verify(request).setAttribute("prodottoNonTrovato", "KO");
		verify(request).getRequestDispatcher("areaAmministratore.jsp");
		verify(rd).forward(request, response);
		
		String result = sw.getBuffer().toString().trim();
		assertEquals("Eliminazione prdotto non riuscita", result);
		
	}
}
