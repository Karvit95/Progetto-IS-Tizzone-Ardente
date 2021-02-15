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

import control.ModificaProdotto;
import dao.ProdottoDao;
import junit.framework.TestCase;

public class ModificaPrezzoRiuscito extends TestCase{
	
	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	
	@Mock
	RequestDispatcher rd;
	
	@Mock
	ProdottoDao pDao;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
 
	@Test
	public void test() throws Exception {
		
		ModificaProdotto mp = new ModificaProdotto();
		
		String idProdotto = "0MOQCUBOE3";
		String nuovoPrezzo = "212";
		
		when(request.getParameter("idModificaPrezzoProdotto")).thenReturn(idProdotto);
		when(request.getParameter("nuovoPrezzo")).thenReturn(nuovoPrezzo);
		when(request.getParameter("sceltaModifica")).thenReturn("0");
		when(pDao.cambioPrezzo(idProdotto, Double.parseDouble(nuovoPrezzo))).thenReturn(true);
		when(request.getRequestDispatcher("areaAmministratore.jsp")).thenReturn(rd);
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);
		
		mp.setpDao(pDao);
		mp.doGet(request, response);
		
		verify(request).setAttribute("cambioPrezzoRiuscito", "OK");
		verify(request).getRequestDispatcher("areaAmministratore.jsp");
		
		String result = sw.getBuffer().toString().trim();
		assertEquals("Cambio prezzo riuscito", result);

	}
}
