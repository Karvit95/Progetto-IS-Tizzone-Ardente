package control;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GenerazioneFattura")
public class GenerazioneFattura extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		HttpSession session = request.getSession();
		
		String codiceFattura;
		LocalDate dataAcquisto;
		
		int count = 20;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
			
		}
		
		codiceFattura = builder.toString();
		
		dataAcquisto = LocalDate.now();
		
		session.setAttribute("codiceFattura", codiceFattura);
		session.setAttribute("dataAcquisto", dataAcquisto);
		
		response.sendRedirect("fattura.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
		
	}
}
