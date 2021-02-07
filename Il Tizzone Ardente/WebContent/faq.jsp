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
  		<link rel="stylesheet" href="style.css">
		<title> FAQ </title>
		
	</head>
	
	<body>
	
		<%@ include file = "elements/header.jsp" %>
		<%@ include file = "elements/navbar.jsp" %>	
	
		<div class = "container-fluid" >
		
			<div class="row">
			
  				<div class="col-sm-12"> 
  					<h2>Frequently Asked Questions</h2>
						
					<ol>
						<li><strong>Perché le armi sono in legno e/o alluminio?</strong></li>
						<li value="1"> Perché se fabbricati con altri materiali non potrebbero essere messe in vendita </li>
						<li><strong>I prodotti sono lavorati a mano?</strong></li>
						<li value="2"> Si i prodotti sono lavorati a mano, tranne alcuni particolari fatti industrialmente. </li>
						<li><strong>Quanto pesa una delle vostre riproduzioni?</strong></li>
						<li value="3"> Il peso,come le altre caratteristche, è indicato nella pagina del singolo prodotto. </li>
						<li><strong>Entro quanto arrivano gli ordini?</strong></li>
						<li value="4"> Per le spedizioni ci vogliono circa 5 giorni lavorativi.</li>
						<li><strong>E' possibile pagare con bonifico bancario?</strong></li>
						<li value="5"> I metodi di pagamento sono indicati alla <a href="metodiPagamento.jsp"> pagina dedicata</a>. </li>
					</ol>
				</div>
			 </div>
	    </div>
	    <%@ include file = "elements/footer.jsp" %> 
	</body>
</html>