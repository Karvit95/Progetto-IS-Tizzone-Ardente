<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		
		<meta charset="UTF-8">
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
 		<title> Spedizione </title>
	</head>
	
	<body>
	
	<%@ include file = "elements/header.jsp" %>
	<%@ include file = "elements/navbar.jsp" %>
	
	<%
		if(utente == null){
			
			request.setAttribute("avviso", "avviso");
			RequestDispatcher rd = request.getRequestDispatcher("carrello.jsp");
			rd.forward(request, response);
			
		}
	 %>
		
	<h2>Indirizzo di consegna</h2>

	<p><strong> Se vuoi utilizzare l'indirizzo associato al tuo account <a href="Spedizione?value=0">clicca qui</a> altrimenti compila la form </strong></p>

	<form action="Spedizione?value=1" id="regform" method="POST" name ="FormRegistrazione" class=" form-horizontal needs-validation" novalidate>
 				
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
  		
  			<button class="btn btn-warning" type="submit">procedi</button>
	
		</form>
		
		<%@ include file = "elements/footer.jsp" %>
	</body>
</html>