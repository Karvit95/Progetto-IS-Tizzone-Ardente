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
	
		<title> Registrazione </title>
	
	</head>
	
	<body>
		
		<%@ include file = "elements/header.jsp" %>
		<%@ include file = "elements/navbar.jsp" %>
		
		<% 
			 if(utente != null){
			
				 response.sendRedirect("utenteNonAutorizzato.jsp");
			
			 }
		%>
		
		<div class="container-fluid">
			
			<h2>Form  di registrazione </h2>
  			
  			<p><strong> Inserisci i tuoi dati per registrarti al sito </strong></p>
	
			<form action="Registrazione" id="regform" method="POST" name ="FormRegistrazione" class="form-horizontal needs-validation" novalidate oninput='up2.setCustomValidity(up2.value != up.value ? "Passwords do not match." : "")'>
 		
				<div class="form-group">
   					<div class="col-md-6 mb-3">
      				
      					<label for="inputNome"> Nome </label>
      					<input type="text" class="form-control" id="inputNome" name="Nome" placeholder="Inserire il nome" required pattern="^[a-zA-Z]{1,20}$">
      					
      					<div class="invalid-tooltip"> Il nome inserito non è corretto (solo lettere). </div>
   					
   					</div>
				</div>
			
				<div class="form-group">
    				<div class="col-md-6 mb-3">
     				
     					<label for="inputCognome"> Cognome </label>
      					<input type="text" class="form-control" id="inputCognome" name="Cognome" placeholder="Inserire il cognome" required pattern="^[a-zA-Z]{1,20}$">
      		
      					<div class="invalid-tooltip"> Il conome inserito non è corretto (solo lettere). </div>
    				
    				</div>
    			</div>
    			
    			<div class="form-group">
    				<div class="col-md-6 mb-3">
    				
    					<label for="validationTooltipEmail"> email </label>
      					<input type="text" class="form-control" id="validationTooltipEmail" name="Email" placeholder="Inserire l'email" required pattern="^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$">
       					 
       					<div class="invalid-tooltip"> L'email inserita non è corretta </div>
        		
        			</div>
  				</div>
 			
 				<div class="form-group">
    				<div class="col-md-6 mb-3">
     				
     					<label for="inputPass"> password </label>
      					<input type="password" class="form-control" id="inputPass" name="up" placeholder="Inserire la password" required pattern="^((?=.*\d)(?=.*[a-zA-Z]).{8,20})$">
      					
      					<div class="invalid-tooltip"> Password non valida (usare lettere minuscole e numeri). </div>
    				
    				</div>
    			</div>
    			
    			<div class="form-group">
    				<div class="col-md-6 mb-3">
     				
     					<label for="confPass"> Reinserisci la password </label>
      					<input type="password" class="form-control" id="confPass" name="up2" placeholder="Inserire di nuovo la password" required>
      					
      					<div class="invalid-tooltip"> Password diversa o vuota </div>
    				
    				</div>
    			</div>
    			
    			<div class="form-group">
    				<div class="col-md-6 mb-3">
      				
      					<label for="inputNumTel">Numero di Telefono</label>
     					<input type="text" class="form-control" id="inputNumTel" name="NumTel" placeholder="Inserire numero di telefono" required pattern="^[0-9]{10,10}$">
      				
      					<div class="invalid-tooltip"> Numero di telefono non valido. </div>
   				
   				 	</div>
 				</div>
 				
 				<div class="form-group">
    				<div class="col-md-6 mb-3">
      				
      					<label for="inputCittà">Città</label>
     					<input type="text" class="form-control" id="inputCittà" name="citta" placeholder="Inserire la città" required pattern="^[a-zA-Z ]{1,20}$">
      				
      					<div class="invalid-tooltip"> Inserire una città valida. </div>
   				
   				 	</div>
 				</div>
 				
 				<div class="form-group">
    				<div class="col-md-6 mb-3">
      				
      					<label for="inputCAP">CAP</label>
     					<input type="text" class="form-control" id="inputCAP" name="CAP" placeholder="Inserire il CAP" required pattern="^[0-9]{5,5}$">
      				
      					<div class="invalid-tooltip"> Inserire un CAP valido. </div>
   				
   				 	</div>
 				</div>
 				
 				<div class="form-group">
    				<div class="col-md-6 mb-3">
      				
      					<label for="inputProvincia">Provincia</label>
     					<input type="text" class="form-control" id="inputProvincia" name="Provincia" placeholder="Inserire la provincia" required pattern="^[a-zA-Z]{2,2}$">
      				
      					<div class="invalid-tooltip"> Inserire una provincia valida. </div>
   				
   				 	</div>
 				</div>
 				
 				<div class="form-group">
    				<div class="col-md-6 mb-3">
      				
      					<label for="inputIndirizzo">Indirizzo</label>
     					<input type="text" class="form-control" id="inputIndirizzo" name="Indirizzo" placeholder="Inserire l'indirizzo" required pattern="^[a-zA-Z ]{1,20}$">
      				
      					<div class="invalid-tooltip"> Inserire un indirizzo valido. </div>
   				
   				 	</div>
 				</div>
 				
 				<div class="form-group">
    				<div class="col-md-6 mb-3">
      				
      					<label for="inputCivico"> Numero Civico </label>
     					<input type="text" class="form-control" id="inputCivico" name="NumeroCivico" placeholder="Inserire il numero civico" required pattern="^^[0-9]{1,3}$">
      				
      					<div class="invalid-tooltip"> numero civico non valido. </div>
   				
   				 	</div>
 				</div>
  		
  				<div class="col-sm-2">
  				<button class="btn btn-warning" type="submit"> Registrati </button>
				</div>
			</form>
	
		</div>
		

	</body>
	
	<%@ include file = "elements/footer.jsp" %>
	
	<% 
		if(request.getAttribute("erroreDB") != null){
	%>
		<script>
			$(document).ready(function(){
  				$("#regform").prepend("<div class=\"alert alert-danger\"> Errore durante la registrazione, riprovare </div>");
			});
		</script>
		
	<% 	
			request.removeAttribute("erroreDB");
	} %>
	<% 
		if(request.getAttribute("utenteGiàRegistrato") != null){
	%>
		<script>
			$(document).ready(function(){
  				$("#regform").prepend("<div class=\"alert alert-danger\"> L'email inserita appartiene già a un account</div>");
			});
		</script>
		
	<% 	
			request.removeAttribute("utenteGiàRegistrato");
	} %>
</html>