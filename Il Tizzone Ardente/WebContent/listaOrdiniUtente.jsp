<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList" import="model.Effettuato"%>
<!DOCTYPE html>

<html>

	<head>
	
		<meta name="Author" content="Pietro Coppola e Carlo Vitale"/>
 	 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, inital-scale=1.0"/>
		<link rel="icon" href="images/favicon.png" sizes="16x16" type="image/png"> 
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  		<link rel="stylesheet" href="style.css">
 		<title> Il Tizzone ardente </title>
	
	</head>

	

	<body>
	
		<%@ include file = "elements/header.jsp" %>
		<%@ include file = "elements/navbar.jsp" %>
	
		<% 
			if(utente == null){
			
				response.sendRedirect("utenteNonAutorizzato.jsp");
			
			}
		%> 
		
		<% ArrayList<Effettuato> elenco = (ArrayList<Effettuato>) request.getAttribute("ordini"); %>
		<div class="container">
			<h2> elenco dei tuoi ordini </h2>
			<div class="table-responsive">
				<table class="table table-striped table-sm">			
					<thead>
						<tr>
							<th scope="col" class="border-0 bg-light">
                    			<div class="py-2 text-uppercase">Fattura</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-light">
                    			<div class="py-2 text-uppercase">Data</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-light">
                    			<div class="py-2 text-uppercase">Dettagli</div>
                  			</th>
						</tr>
					</thead>
					<tbody>
						<% for (Effettuato e: elenco) { %>
						<tr>
							<td class="border-0 align-middle"> <%= e.getCodiceFattura()%></td>
							<td class="border-0 align-middle"> <%= e.getDataAcquisto()%></td>
							<td class="border-0 align-middle"> <a href="DettaglioOrdine?fattura=<%=e.getCodiceFattura()%>"> visualizza dettagli </a></td>
						</tr>
						
						<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</body>
	
	<%@ include file = "elements/footer.jsp" %>
	
</html>