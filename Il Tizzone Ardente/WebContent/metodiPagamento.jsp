<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  		<link rel="stylesheet" type="text/css" href="style.css">
		<title>Metodi di pagamento</title>
		
	</head>
	
	<body>
	
	
	<%@ include file = "elements/header.jsp" %>
	<%@ include file = "elements/navbar.jsp" %>

		<div class = "container-fluid" >
		
			<div class="row">
			
  				<div class="col-sm-12">
  				
  				<h2> Metodi di pagamento </h2>
  				
  				<div class="spiegazione-pagamento">
  					<p> Puoi utilizzare diversi metodi di pagamento per effettuare acquisti sul nostro sito: <strong>carte di credito, buoni regalo o codici</strong> per ricaricare il tuo account, che puoi pagare in contanti presso i punti vendita selezionati. </p>
  				</div>
  				
  					<div class="col-md-6 mb-3">
  						<ul>
  							<li> Visa </li>
  							<li> Postepay </li>
  							<li> Mastercard </li>
  							</ul>
  					</div>
			 </div>
			</div>
		</div> 
		
	</body>
	
	<%@ include file = "elements/footer.jsp" %>
	
</html>