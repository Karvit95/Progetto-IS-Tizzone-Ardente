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
  		<title> Cambio password </title>
	
	</head>
	
	<body>
		
		<%@ include file = "elements/header.jsp" %>
		<%@ include file = "elements/navbar.jsp" %>
		
		<% 
			 if((utente == null)){
			
				 response.sendRedirect("utenteNonAutorizzato.jsp");
			
			 }
		%>
		<div class="container">
			
			<h2> Cambio Password </h2>
	
			<form action="CambioPassword" method="POST" id="cambioPassword"  name ="FormRegistrazione" class="form-horizontal needs-validation" novalidate oninput='up2.setCustomValidity(up2.value != up.value ? "Passwords do not match." : "")'>
  
 				<div class="form-group row">
     				
     				<label for="inputPassAttuale" class="col-sm-2 col-form-label"> password attuale: </label>
      				<div class="col-sm-10">
      					<input type="password" class="form-control" id="inputPassAttuale" name="passwordAttuale" placeholder="Inserire la password attuale" required pattern="^((?=.*\d)(?=.*[a-zA-Z]).{8,20})$">
      					<div class="invalid-tooltip"> Password non valida (usare lettere minuscole e numeri). </div>
      				</div>
    			</div>
 		
 				<div class="form-group row">
     					
     				<label for="inputPass" class="col-sm-2 col-form-label"> Nuova Password </label>
      				<div class="col-sm-10">
      					<input type="password" class="form-control" id="inputPass" name="up" placeholder="Inserire la password" required pattern="^((?=.*\d)(?=.*[a-zA-Z]).{8,20})$">
      					<div class="invalid-tooltip"> Password non valida (usare lettere minuscole e numeri). </div>	
    				</div>
    			</div>
    			
    			<div class="form-group row">
     				
    				<label for="confPass" class="col-sm-2 col-form-label"> Reinserisci password </label>
      				<div class="col-sm-10">
      					<input type="password" class="form-control" id="confPass" name="up2" placeholder="Inserire di nuovo la password" required>
      					<div class="invalid-tooltip"> Password diversa o vuota </div>
    				</div>
    			</div>
  		
  				<div class="form-group row">
  					<div class="col-sm-10">
  						<button class="btn btn-warning" type="submit">Submit form</button>
  					</div>
				</div>
			</form>
		</div>
	</body>
	
	<% 
		if(request.getAttribute("PasswordErrata") != null){
	%>
		<script>
			$(document).ready(function(){
  			// Show the Modal on load
  				$("#cambioPassword").prepend("<div class=\"alert alert-danger\"> La password inserita è sbagliata </div>");
			});
		</script>
		
	<% 	
			request.removeAttribute("PasswordErrata");
	} %>
	
	<% 
		if(request.getAttribute("erroreDB") != null){
	%>
		<script>
			$(document).ready(function(){
  				$("#regform").prepend("<div class=\"alert alert-danger\"> Errore durante il cambio password, riprovare </div>");
			});
		</script>
		
	<% 	
			request.removeAttribute("erroreDB");
	} %>
	
	<!-- Modal -->
  	<div class="modal fade" id="successoCambioPassword" role="dialog">
    	<div class="modal-dialog">
    
    		<!-- Modal content-->
    		<div class="modal-content">
       			<div class="modal-body">
       				<p> <strong> Cambio Password avvenuto con successo</strong> </p>
       				<button type="button" class="btn btn-warning" id="successoCambioPasswordButton">Continua sul sito</button>
       			</div>
    		</div>
  		</div>
  	</div>

	<% if(request.getAttribute("successoCambioPassword") != null)  {%>
	
	<script>
		$(document).ready(function(){
  		// Show the Modal on load
  			$("#successoCambioPassword").modal("show");
    
  		// Hide the Modal
  		$("#successoCambioPasswordButton").click(function(){
    		$("#successoCambioPassword").modal("hide");
 	 		});
		});
	</script>
	
	<% request.removeAttribute("successoCambioPassword");
		} %>	
	
		<%@ include file = "elements/footer.jsp" %>
	
</html>