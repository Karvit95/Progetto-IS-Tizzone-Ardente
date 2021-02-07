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
		
		<div class="container-fluid">
			
			<%@ include file = "elements/header.jsp" %>
			<%@ include file = "elements/navbar.jsp" %>
			
			<% 
			 if((utente == null) || !(utente.isAmministratore())){
			
				 response.sendRedirect("utenteNonAutorizzato.jsp");
			
			 }
			%>
			
			<h2 class="text-center"> Benvenuto nell'area amministratore </h2>
			<h3 class="text-center"> Scegli l'operazione che vuoi fare </h3>
			<%@ include file = "elements/navbarAmministratore.jsp" %>
			
			<h2> Elimina un prodotto dal catalogo </h2>
			
			<form action="EliminazioneProdotto" method="POST" class="form-horizontal needs-validation" novalidate>	
				<div class="form-group row">
      				
      				<label for="inputIdProdotto" class="col-sm-2 col-form-label"> ID del prodotto </label>
      				<div class="col-sm-10">
      					<input type="text" class="form-control" id="inputIDProdotto" name="idProdotto" placeholder="Inserire l'ID unico del prodotto" required pattern="^[A-Z0-9]{10}$">
      					<div class="invalid-tooltip"> L'id inserito non è corretto (solo lettere maiuscole e numeri). </div>
      				</div>
				</div>
				
				<button class="btn btn-warning mt-2" type="submit">Elimina Prodotto</button>
				
			</form>
			
		</div>
		<%@ include file = "elements/footer.jsp" %>
	</body>
</html>