<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Effettuato" import="java.util.ArrayList" %>
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
		<title>Il tizzone ardente</title>
		<script type="text/javascript" src="js/validazione.js"></script>

	</head>
	
	
	<body>
	
		<%@ include file = "elements/header.jsp" %>
		<%@ include file = "elements/navbar.jsp" %>
		
		<% 
			if((utente == null) || !(utente.isAmministratore())){
			
				response.sendRedirect("utenteNonAutorizzato.jsp");
			
			}
		%> 
		
		<div class="container-fluid">
			
  			<h2 class="text-center"> Visualizza Ordini effettuati</h2>
  			<p class="text-center"><strong>Filtra per:</strong></p>
  	
  			<form action="ListaOrdiniAmministratore" method="GET" class="form-inline d-flex justify-content-center needs-validation" novalidate>
  				
  				<label for="dataInizio"> <strong> Periodo Inizio: </strong> </label>
  		  		<input type="date" class="form-control mr-2" id="dataInizio" placeholder="prima data" name="dataInizio">
  			
  				
    			<label for="dataFine"> <strong> Periodo Fine: </strong> </label>
  				<input type="date" class="form-control mr-2" id="dataFine" placeholder="seconda data" name="dataFine">
  			
    			<label for="persona"> <strong> Utente: </strong> </label>
    			<input type="email" class="form-control mr-2" id="persona" placeholder="persona" name="persona" pattern="^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$">
    			<div class="invalid-tooltip"> L'email inserita non è corretta </div>
    			<button type="submit" id="ordiniButton" class="btn btn-warning">Filtra</button>
    		
  			</form>
		</div>
		
		<% ArrayList<Effettuato> elenco = (ArrayList<Effettuato>) request.getAttribute("ordini");%>
		
		<div class="container-fluid">
			
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
                  				<div class="py-2 text-uppercase">Email Utente</div>
               				</th>
               				<th scope="col" class="border-0 bg-light">
                  				<div class="py-2 text-uppercase">Dettagli</div>
               				</th>
						</tr>
					</thead>
					<tbody>
					<% for(Effettuato e: elenco) { %>
						<tr>
							<td class="border-0 align-middle"> <%= e.getCodiceFattura()%></td>
							<td class="border-0 align-middle"> <%= e.getDataAcquisto()%></td>
							<td class="border-0 align-middle"> <%= e.getEmail()%></td>
							<td class="border-0 align-middle"> <a href="DettaglioOrdine?fattura=<%=e.getCodiceFattura()%>"> visualizza dettagli </a></td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>
		</div>
		<%@ include file = "elements/footer.jsp" %>
	</body>
</html>