<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Illustrazione" import="model.Prodotto" import="com.google.gson.Gson" %>
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
		<title>Il tizzone ardente</title>
		
	</head>
	
	<%	Prodotto p = (Prodotto) request.getAttribute("prodotto");  
		Illustrazione i = (Illustrazione) request.getAttribute("immagine"); 
		
		Gson gson = new Gson();
		String prodottoInJson = gson.toJson(p);
		
		%>
	<script type="text/javascript">

		 $(document).ready(function(){
			$("#addToCart").click(function(){
				
				var prodottoJson = $("#prodottoNascosto").val();
				
				$.post("InserimentoNelCarrello", {prodottoJson: prodottoJson}, function(resp){
					
					$("#prodottoAggiunto").modal("show");
				})
	
			 })
		})
		
	</script>	
	<body>
		
		<%@ include file = "elements/header.jsp" %>
		<%@ include file = "elements/navbar.jsp" %>
	
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<img id="immagine-pagina-prodotto" src="<%=i.getUrl() %>" class="float-left img-fluid">	
				</div>

				<div class="col-sm-8">
					
					<h2><%= p.getNome() %></h2>
					<p><%= p.getDescrizione()%></p>
					
					<%if(p.getSconto()==0){ %>
					<p class="price"><%=p.getPrezzo()%>0€</p>
					<%}else{ %>
					<span class="prezzo-pagina-prodotto"><%=p.getPrezzo()-(p.getPrezzo()*p.getSconto()/100)%>0€</span> <p><del><%=p.getPrezzo()%></del> <strong>sconto:<%=p.getSconto()%>%</strong></p>
					<% } %>

					<input type="hidden" id="prodottoNascosto" name="prodottoNascosto" value='<%=prodottoInJson%>'>
					<% if(p.getQuantità() > 0) { %>
						<button id="addToCart" type="submit" class="btn btn-warning"> aggiungi al carrello </button>
					<% }else { %>
					<p><strong>Prodotto non disponibile</strong></p>
					<% } %>
					
				</div>
					
			</div>
			
			<div class="row">
				
				<h2> Scheda Tecnica</h2>
			
				<div class="table-responsive">
					
					<table class="table table-sm table-bordered">
					
						<tr>
						
							<th scope="row">Modello</th>
							<td><%=p.getModello() %></td>
							
						</tr>
						<tr>
							<th scope="row">Materiale</th>
							<td><%=p.getMateriale() %></td>
						</tr>
						<tr>
							<th scope="row">Peso</th>
							<td><%=p.getPeso() %> kg</td>
						
						</tr>
								
					</table>
						
				</div>
			</div>
				
		</div>
		
		<!-- Modal -->
  		<div class="modal fade" id="prodottoAggiunto" role="dialog">
    		<div class="modal-dialog">
    
    			<!-- Modal content-->
    			<div class="modal-content">
       				<div class="modal-body">
       					<p> <strong> Prodotto aggiunto al carrello </strong> </p>
       					<button type="button" class="btn btn-warning" id="prodottoAggiuntoButton">Continua sul sito</button>
       				</div>
    			</div>
  			</div>
  		</div>
			
		<script type="text/javascript">
			$(document).ready(function(){
    
  				$("#prodottoAggiuntoButton").click(function(){
    				$("#prodottoAggiunto").modal("hide");
 	 				});
				});
		</script>
		<%@ include file = "elements/footer.jsp" %>
	</body>
</html>