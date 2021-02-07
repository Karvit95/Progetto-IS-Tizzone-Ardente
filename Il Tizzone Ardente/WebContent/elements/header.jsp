<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Utente" %>
<!DOCTYPE html>

<% 
	Utente utente = (Utente) request.getSession().getAttribute("utente");
%>

<html>

	<head>
 	
 		<meta name="Author" content="Pietro Coppola e Carlo Vitale"/>
 	 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, inital-scale=1.0"/>
		<script src='https://kit.fontawesome.com/a076d05399.js'></script>
		
	</head>

		<div class="container-fluid">
			<div class="row">
  			
  				<div class="col-sm-3">
  				
  					<a href="home.jsp"><img class="img-fluid" src="images/tizzone-ardente-logo-2.jpg" alt="logo"></a>
			
				</div>	
  			
  				<div class="col-sm-3">
  			
  					<!--  Barra di ricerca -->
  					<%@ include file = "search.jsp" %>
  			
  				</div>	
  				
  				<div class="col-sm-1"> </div>
  			
  				<div class="headerPosizione col-sm-3">	
  			
  					<% if(utente == null ){ %>
  					
  						<!-- Form di login -->
  						<%@ include file = "login.jsp" %>
  					
  					<% } %>
  					
  					<% if(utente != null){ %>
  					
  					<div class="dropdown">
  							
  						<button class="btn btn-warning dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"> Ciao <%= utente.getNome() %> </button>
  							
  						<div class="dropdown-menu bg-warning">
  							
    						<a class="dropdown-item" href="cambioPassword.jsp"> Cambio Password </a>
    							
    						<a class="dropdown-item" href="ListaOrdiniUtente"> Ordini effettuati </a>
    							
    						<% if (utente.isAmministratore()) { %>
    							
    						<a class="dropdown-item" href="areaAmministratore.jsp"> Area amministratore </a>
    						
    						<a class="dropdown-item" href="ListaOrdiniAmministratore"> Ordini complessivi</a>
    						
    						<% } %>
    							
    						<a class="dropdown-item" href="Logout">Logout</a>
  					
  						</div>
					</div>
  					
  					<% } %>
  				
  				</div>
  			
  				<div class="col-sm-2">	
  					<a href="GenerazionePaginaCarrello"><button class="headerPosizione btn btn-warning"><i class='fas fa-shopping-cart'></i> CARRELLO</button></a>
  			
  				</div>
  			
  			</div>
  		</div>
  		
</html>