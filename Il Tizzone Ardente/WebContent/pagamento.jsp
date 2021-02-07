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
 		<script src='https://kit.fontawesome.com/a076d05399.js'></script>
 		<link rel="stylesheet" href="style.css">
  		<script type="text/javascript" src="js/validazione.js"></script>
  		
	</head>
	<body>
	
		<%@ include file = "elements/header.jsp" %>
		<%@ include file = "elements/navbar.jsp" %>
		
		<% if((utente == null) || (request.getSession().getAttribute("indirizzoOrdine") == null)){
				
			request.setAttribute("avviso", "avviso");
			RequestDispatcher rd = request.getRequestDispatcher("carrello.jsp");
			rd.forward(request, response);
			
			}
			
		 %>
	
		<div class="container pagamento-container">
			<div class="row">
				<div class="col-sm-12">
					<h2 class="d-flex justify-content-center"> Pagamento con carta di credito</h2>
            		<h3 class="d-flex justify-content-center">Pagamento</h3>
            		<label class="d-flex justify-content-center" for="fname">Carte accettato</label>
            		<div class="icon-container d-flex justify-content-center">
              			<i class="fab fa-cc-visa"></i>
              			<i class="fab fa-cc-amex"></i>
              			<i class="fab fa-cc-mastercard"></i>
              			<i class="fab fa-cc-discover"></i>
            		</div>
            	</div>
            </div>
            <div class="row">
            	<div class="col-sm-12">
            		<p><strong> Inserisci i dati della carta </strong></p>
            		<form action="GenerazioneFattura" method="POST" class="form-horizontal needs-validation" novalidate>
            			<div class="form-group">
            				<div class="col-md-12 mb-3">
           						<label for="cname"> Nome proprietario</label>
            			 		<input type="text" class="form-control" id="cname" name="cardname" placeholder="Inserisci il nome sulla carta" required pattern="^[a-zA-Z ]{1,20}$">
            					<div class="invalid-tooltip"> Inserire un nome correttto </div>
            				</div>
            			</div>
            			<div class="form-group">
            				<div class="col-md-12 mb-3">
           						<label for="ccnum">Numero di carta di credito</label>
           	 					<input type="text" class="form-control" id="ccnum" name="cardnumber" placeholder="1111-2222-3333" required pattern="^[0-9]{4,4}-[0-9]{4,4}-[0-9]{4,4}$">
            					<div class="invalid-tooltip"> Inserire un numero valido. </div>
            				</div>
            			</div>
            			<div class="form-group"> 
            				<div class="col-md-12 mb-3">
            					<label for="expmonth">Mese di scadenza</label>
            					<input type="text" class="form-control" id="expmonth" name="expmonth" placeholder="settembre" required pattern="^[a-zA-Z ]{1,20}$">
            					<div class="invalid-tooltip"> Inserire un mese. </div>
            				</div>
            			</div>
            			<div class="form-row">
            				<div class="form-group col-md-6">
                				<label for="expyear">Anno di scadenza </label>
                				<input type="text" class="form-control" id="expyear" name="expyear" placeholder="2018" required required pattern="^[0-9]{4,4}$">
                				<div class="invalid-tooltip"> Inserire un anno valido. </div>
              				</div>
              				<div class="form-group col-md-6">
               					<label for="cvv">CVV</label>
                				<input type="text" class="form-control" id="cvv" name="cvv" placeholder="352" required required pattern="^[0-9]{3,3}$">
                				<div class="invalid-tooltip"> Inserire un numero valido. </div>
              				</div>
           			 	</div>
           			 	<button type="submit" class="btn btn-warning mt-5">continua</button>
        			</form>
	    		</div>
	    	</div>
     	</div>
	</body>
</html>