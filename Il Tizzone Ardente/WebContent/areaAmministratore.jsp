<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Utente" %>
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
		<link rel ="stylesheet" href="style.css" type="text/css">
		<script type="text/javascript" src="js/validazione.js"></script>
 		<title> Area amministratore </title>
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
			<div class="row">
				<div class="col-sm-12">
					<h2 class="text-center"> Benvenuto nell'area amministratore </h2>
					<h3 class="text-center"> Scegli l'operazione che vuoi fare </h3>
					<%@ include file = "elements/navbarAmministratore.jsp" %>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12" id="areaAmministratore"> </div>		
			</div>
		
		<!-- Modal -->
  		<div class="modal fade" id="modalAreaAdmin">
    		<div class="modal-dialog">
    			<!-- Modal content-->
    			<div class="modal-content">
       				<div class="modal-body" id="modalAreaAdminBody">
       					
       					<button type="button" class="btn btn-warning" id="modalAreaAdminButton">Continua sul sito</button>
       				</div>
    			</div>
  			</div>
  		</div>
  	</div>
  		
		<script type="text/javascript">
		$(document).ready(function(){
			
			<% if(request.getAttribute("erroreInserimento") != null) {%>

  			$("#modalAreaAdmin").modal("show");
    		
			$("#modalAreaAdminBody").prepend("<p> <strong> inserimento del prodotto non riuscito, riprovare) </strong> </p>")

  	  		$("#modalAreaAdminButton").click(function(){
  	    		$("#modalAreaAdmin").modal("hide");
  	    		
  	 	 		});
  		
  			<% request.removeAttribute("erroreInserimento");
				
			} 
			
			%>
			<% if(request.getAttribute("inserimentoRiuscito") != null)  {%>

  			$("#modalAreaAdmin").modal("show");
    		
			$("#modalAreaAdminBody").prepend("<p> <strong> inserimento del prodotto riuscito </strong> </p>")

  	  		$("#modalAreaAdminButton").click(function(){
  	    		$("#modalAreaAdmin").modal("hide");  	    		
  	    		
  	 	 		});
  		
  			<% request.removeAttribute("inserimentoRiuscito");
				
			} 
			
			%>
			
			<% if(request.getAttribute("cambioPrezzoRiuscito") != null)  {%>

  			$("#modalAreaAdmin").modal("show");
    		
			$("#modalAreaAdminBody").prepend("<p> <strong> Cambio del prezzo del prodotto riuscito </strong> </p>")

  	  		$("#modalAreaAdminButton").click(function(){
  	    		$("#modalAreaAdmin").modal("hide");
  	    		
  	 	 		});
  		
  			<% request.removeAttribute("cambioPrezzoRiuscito");
				
			} 
			
			%>
			
			<% if(request.getAttribute("cambioScontoRiuscito") != null)  {%>

  			$("#modalAreaAdmin").modal("show");
    		
			$("#modalAreaAdminBody").prepend("<p> <strong> Cambio dello sconto del prodotto riuscito </strong> </p>")

  	  		$("#modalAreaAdminButton").click(function(){
  	    		$("#modalAreaAdmin").modal("hide");
  	    		
  	 	 		});
  		
  			<% request.removeAttribute("cambioScontoRiuscito");
				
			} 
			
			%>
			
			<% if(request.getAttribute("cambioQuantitaRiuscito") != null)  {%>

  			$("#modalAreaAdmin").modal("show");
    		
			$("#modalAreaAdminBody").prepend("<p> <strong> Cambio della quantità del prodotto riuscito </strong> </p>")

  	  		$("#modalAreaAdminButton").click(function(){
  	    		$("#modalAreaAdmin").modal("hide");
  	    		
  	 	 		});
  		
  			<% request.removeAttribute("cambioQuantitaRiuscito");
				
			} 
			
			%>
			
			<% if(request.getAttribute("eliminazioneRiuscita") != null)  {%>

  			$("#modalAreaAdmin").modal("show");
    		
			$("#modalAreaAdminBody").prepend("<p> <strong> Prodotto eliminato correttamente </strong> </p>")

  	  		$("#modalAreaAdminButton").click(function(){
  	    		$("#modalAreaAdmin").modal("hide");
  	    		
  	 	 		});
  		
  			<% request.removeAttribute("cambioQuantitaRiuscito");
				
			} 
			
			%>
			
			<% if(request.getAttribute("prodottoNonTrovato") != null)  {%>

  			$("#modalAreaAdmin").modal("show");
    		
			$("#modalAreaAdminBody").prepend("<p> <strong> Il prodotto a cui moddificare il prezzo non esiste nel database </strong> </p>")

  	  		$("#modalAreaAdminButton").click(function(){
  	    		$("#modalAreaAdmin").modal("hide");
  	    		
  	 	 		});
  		
  			<% request.removeAttribute("prodottoNonTrovato");
				
			} 
			
			%>
			
			<% if(request.getAttribute("erroreDB") != null)  {%>

  			$("#modalAreaAdmin").modal("show");
    		
			$("#modalAreaAdminBody").prepend("<p> <strong> Errore sul DB </strong> </p>")

  	  		$("#modalAreaAdminButton").click(function(){
  	    		$("#modalAreaAdmin").modal("hide");
  	    		
  	 	 		});
  		
  			<% request.removeAttribute("cambioQuantitaRiuscito");
				
			} 
			
			%>
			
		});
	</script>
	<%@ include file = "elements/footer.jsp" %>
	</body>
	
</html>