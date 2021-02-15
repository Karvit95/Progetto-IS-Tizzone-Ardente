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

import control.Login;
import dao.UtenteDao;
import junit.framework.TestCase;
import model.Utente;

public class LoginEmailErrata extends TestCase{

	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	
	@Mock
	RequestDispatcher rd;
	
	@Mock
	UtenteDao utenteDao;
	
	Utente utente;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		utente = new Utente("alda@web.it", "Alda", "Russo", "3189084427", "aldarusso", false);
	}

	@Test
	public void test() throws Exception {
		
		Login login = new Login();
		utenteDao = new UtenteDao();
		
		when(request.getParameter("email")).thenReturn("alda@web.it");
		when(request.getParameter("password")).thenReturn("aldarusso");
		when(request.getRequestDispatcher("home.jsp")).thenReturn(rd);

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);
		
		login.setUtenteDao(utenteDao);
		login.doGet(request, response);
		
		verify(request).setAttribute("emailNonTrovata", "emailnonesiste");
		verify(request).getRequestDispatcher("home.jsp");
		verify(rd).forward(request, response);
		
		String result = sw.getBuffer().toString().trim();
		assertEquals("Login fallito", result);
		
	}
}
