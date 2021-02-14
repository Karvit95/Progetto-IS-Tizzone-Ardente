package test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import control.Login;
import junit.framework.TestCase;
import model.Utente;

public class LoginRiuscito extends TestCase{

	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	@Mock
	HttpSession session;
	
	Utente utente;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		utente = new Utente("aldarusso@web.it", "Alda", "Russo", "3189084427", "aldarusso", false);
	}

	@Test
	public void test() throws Exception {
		
		when(request.getParameter("email")).thenReturn("aldarusso@web.it");
		when(request.getParameter("password")).thenReturn("aldarusso");
		when(request.getSession()).thenReturn(session);
	

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);
		
		new Login().doGet(request, response);
		
		verify(session).setAttribute("utente", utente);
		
		String result = sw.getBuffer().toString().trim();
		assertEquals("Login riuscito", result);
		
	}
}
