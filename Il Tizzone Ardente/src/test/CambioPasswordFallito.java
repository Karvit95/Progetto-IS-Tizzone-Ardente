package test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import control.CambioPassword;
import junit.framework.TestCase;
import model.Utente;

public class CambioPasswordFallito extends TestCase{
	
	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	@Mock
	HttpSession session;
	
	@Mock
	RequestDispatcher rd;
	
	@Mock
	Utente utente;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void test() throws Exception{
		
		CambioPassword cambioPassword = new CambioPassword();
		Utente utente = new Utente();
		Utente utenteMock = new Utente("aldarusso@web.it", "Alda", "Russo", "3189084427", "aldarusso", false);
		
		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("utente")).thenReturn(utenteMock);
		when(request.getParameter("passwordAttuale")).thenReturn("passwordDiversa");
		when(request.getRequestDispatcher("cambioPassword.jsp")).thenReturn(rd);
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);
		
		cambioPassword.doGet(request, response);
		
		verify(request).setAttribute("PasswordErrata", "passwordErrata");
		verify(request).getRequestDispatcher("cambioPassword.jsp");
		verify(rd).forward(request, response);
		
		String result = sw.getBuffer().toString().trim();
		assertEquals("Cambio password non riuscito", result);
		
	}
}
