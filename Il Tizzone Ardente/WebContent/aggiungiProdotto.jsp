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
			
			<h2> Aggiungi un nuovo prodotto al catalogo </h2>
			
			<form action="InserimentoProdotto" id="insform" method="POST" name ="FormInserimentoProdotto" class=" form-horizontal needs-validation" novalidate >
				
				<div class="form-group">
   					<div class="col-md-6 mb-3">
      				
      					<label for="inputNomeProdotto"> Nome </label>
      					<input type="text" class="form-control" name="nome" id="inputNomeProdotto" placeholder="Inserire il nome del prodotto" required pattern="^[a-zA-Z ]{1,20}$">
      					
      					<div class="invalid-tooltip"> Il nome inserito non è corretto (solo lettere). </div>
   					
   					</div>
				</div>
				
				<div class="form-group">
   					<div class="col-md-6 mb-3">
      				
      					<label for="inputModelloProdotto"> Modello </label>
      					<input type="text" class="form-control" name="modello" id="inputModelloProdotto" placeholder="Inserire il modello del prodotto" required pattern="^[a-zA-Z]{1,20}$">
      					
      					<div class="invalid-tooltip"> Il modello inserito non è corretto (solo lettere). </div>
   					
   					</div>
				</div>
				
				<div class="form-group">
   					<div class="col-md-6 mb-3">
      				
      					<label for="inputCatalogoProdotto"> catalogo </label>
      					<input type="text" class="form-control" name="catalogo" id="inputCatalogoProdotto" placeholder="Inserire il prodotto in un catalogo" required pattern="^[a-zA-Z]{1,20}$">
      					
      					<div class="invalid-tooltip"> Il catalogo non è corretto (solo lettere). </div>
   					
   					</div>
				</div>
				
				<div class="form-group">
   					<div class="col-md-6 mb-3">
      				
      					<label for="inputMaterialeProdotto"> Materiale </label>
      					<input type="text" class="form-control" name="materiale" id="inputMaterialeProdotto" placeholder="Inserire il materiale con cui è fatto il prodotto" required pattern="^[a-zA-Z ]{1,20}$">
      					
      					<div class="invalid-tooltip"> Il materiale non è corretto (solo lettere). </div>
   					
   					</div>
				</div>
				
				<div class="form-group">
   					<div class="col-md-6 mb-3">
      				
      					<label for="inputPesoProdotto"> Peso </label>
      					<input type="text" class="form-control" name="peso" id="inputPesoProdotto" placeholder="Inserire il nome del prodotto" required pattern="^\d*\.?\d*$">
      					
      					<div class="invalid-tooltip"> Il peso inserito non è corretto (inserire un valido numero decimale). </div>
   					
   					</div>
				</div>
				
				<div class="form-group">
   					<div class="col-md-6 mb-3">
      				
      					<label for="inputPrezzoProdotto"> Prezzo (assicurati di inserire il prezzo compreso di IVA) </label>
      					<input type="text" class="form-control" name="prezzo" input="inputPrezzoProdotto" placeholder="Inserire il nome del prodotto" required pattern="^\d*\.?\d*$">
      					
      					<div class="invalid-tooltip"> Il prezzo inserito non è corretto (inserire un valido numero decimale). </div>
   					
   					</div>
				</div>
				
				<div class="form-group">
					<div class="col-md-6 mb-3">
					
  						<label for="descrizione">Descrizione:</label>
  						<textarea class="form-control" rows="5" name="descrizione" id="descrizione" required></textarea>
					</div>
				</div>
				
				<label for="immagine"> Carica un'immagine: </label>
				<input type="file" id="immagine" name="immagine" placeholder="inserisci l'immagine del prodotto" accept="image/png, image/jpeg" required>
				
				<br>
				
				<button class="btn btn-warning" type="submit">Aggiungi il prodotto</button>
				
			</form>
			
		</div>
</html>