<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	
	<head>
	
		<meta name="Author" content="Pietro Coppola e Carlo Vitale">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, inital-scale=1.0">
		<link rel="icon" href="images/favicon.png" sizes="16x16" type="image/png">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  		<link rel="stylesheet" href="style.css">
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
		
			<h2 class="text-center"> Benvenuto nell'area amministratore </h2>
			<h3 class="text-center"> Scegli l'operazione che vuoi fare </h3>
			<%@ include file = "elements/navbarAmministratore.jsp" %>
  			
  			<h2>Modifica prodotto</h2>
 			<p> <strong> Cambia sconto, prezzo o quantità:</strong></p>
  
 			<form action="ModificaProdotto" method="POST" class="form-horizontal needs-validation" novalidate>	
				
				<div class="form-group">
      				<label for="modifica">Select list (select one):</label>
      				<select class="form-control" id="modifica" name="sceltaModifica" placeholder="Scegli un opzione">
      					<option> scegli un opzione </option>
        				<option value="0">prezzo</option>
        				<option value="1">sconto</option>
        				<option value="2">quantità</option>
        			</select>
    			</div>
				
				<button id="buttonModifica" class="btn btn-warning" type="submit">Modifica</button>
				
			</form>
		</div>
		
		<script>
		$("#modifica").change(function () {
			
			$("#modificaProdotto").remove();
			$("#modificaProdotto2").remove();
			
		    var value = $("#modifica option:selected").val();
		   
		    if(value == 0){
		    	
		    	$("#buttonModifica").before("<div class=\"form-group row\" id=\"modificaProdotto\"><label id=\"labelModifica\" class=\"col-sm-3 col-form-label\" for=\"inputModifica\"> ID del prodotto </label> <div class=\"col-sm-9\"> <input id=\"inputModifica\" type=\"text\" class=\"form-control\" name=\"idModificaPrezzoProdotto\" placeholder=\"Inserire l'ID unico del prodotto a cui cambiare il prezzo\" required pattern=\"^[a-zA-Z0-9]*$\"> <div class=\"invalid-tooltip\"> l'id inserito non è corretto (inserire una stringa alfanumerica). </div> </div> </div> <div class=\"form-group row\" id=\"modificaProdotto2\"> <label id=\"labelModifica2\" class=\"col-sm-3 col-form-label\" for=\"inputModifica2\"> Nuovo prezzo (IVA inclusa) </label> <div class=\"col-sm-9\"> <input id=\"inputModifica2\" type=\"text\" class=\"form-control\" name=\"nuovoPrezzo\" placeholder=\"Inserire il nuovo prezzo\" required pattern=\"^\\d*\.?\\d*$\"> <div class=\"invalid-tooltip\"> il prezzo non è corretto (inserire un numero decimale). </div> </div> </div>");
		    	
		    }
		    
			if(value == 1){
		    	
		    	$("#buttonModifica").before("<div class=\"form-group row\" id=\"modificaProdotto\"><label id=\"labelModifica\" for=\"inputModifica\" class=\"col-sm-2 col-form-label\"> ID del prodotto </label> <div class=\"col-sm-10\"> <input id=\"inputModifica\" type=\"text\" class=\"form-control\" name=\"idModificaScontoProdotto\" placeholder=\"Inserire l'ID unico del prodotto a cui applicare lo sconto\" required pattern=\"^[a-zA-Z0-9]*$\"> <div class=\"invalid-tooltip\"> l'id inserito non è corretto (inserire una stringa alfanumerica). </div> </div> </div> <div class=\"form-group row\" id=\"modificaProdotto2\"> <label id=\"labelModifica2\" class=\"col-sm-2 col-form-label\" for=\"inputModifica2\"> Sconto </label> <div class=\"col-sm-10\"> <input id=\"inputModifica2\" type=\"text\" class=\"form-control\" name=\"nuovoSconto\" placeholder=\"Inserire lo sconto da applicare\" required pattern=\"^^[0-9]{1,3}$\"> <div class=\"invalid-tooltip\"> lo sconto non è corretto (inserire un numero). </div> </div> </div>");
		    			    
		    }
			
			if(value == 2){
	
				$("#buttonModifica").before("<div class=\"form-group row\" id=\"modificaProdotto\"><label id=\"labelModifica\" class=\"col-sm-2 col-form-label\" for=\"inputModifica\"> ID del prodotto </label> <div class=\"col-sm-10\"> <input id=\"inputModifica\" type=\"text\" class=\"form-control\" name=\"idModificaQuantitaProdotto\" placeholder=\"Inserire l'ID unico del prodotto a cui cambiare la quantità\" required pattern=\"^[a-zA-Z0-9]*$\"> <div class=\"invalid-tooltip\"> l'id inserito non è corretto (inserire una stringa alfanumerica). </div> </div> </div> <div class=\"form-group row\" id=\"modificaProdotto2\"> <label id=\"labelModifica2\" class=\"col-form-label col-sm-2\" for=\"inputModifica2\"> Quantità </label> <div class=\"col-sm-10\"> <input id=\"inputModifica2\" type=\"text\" class=\"form-control\" name=\"nuovaQuantita\" placeholder=\"Inserire la nuova quantità\" required pattern=\"^^[0-9]{1,3}$\"> <div class=\"invalid-tooltip\"> la quantità non è corretta (inserire un numero decimale). </div> </div> </div>");
		    	
			}
		  })
		</script>
		
	</body>

</html>