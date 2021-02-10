<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList" import="model.Prodotto"%>
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
  		<title> Il Tizzone Ardente </title>
	
	</head>
	<body>
		
		<%@ include file = "elements/header.jsp" %>
		<%@ include file = "elements/navbar.jsp" %>
		
		<% ArrayList<Prodotto> elenco = (ArrayList<Prodotto>) request.getAttribute("elenco");
		   if(elenco.isEmpty()){ %>
		   
		<h1> Nessun Risultato</h1>  
		
		<% }else{ %>
		<div class="container-fluid">
			<div class="row">
				
				<% for(Prodotto prodotto: elenco){%>	
    	
    			<div class="col-sm-3">
      				<div class="prodottoInElenco">
      			
      					<img class="img-fluid" src="<%=prodotto.getImmagine()%>">
      					<a href="GenerazionePaginaProdotto?id=<%=prodotto.getId()%>">
      						<h3><%=prodotto.getNome()%></h3>
      					</a>
      					
      					<%if(prodotto.getSconto() == 0) {%>
      					
      					<p class="price">prezzo:<%=prodotto.getPrezzo()%>0€</p>
      					
      					<%} else { %>
      				
      					<p class="price"><%=prodotto.getPrezzo()-prodotto.getPrezzo()*prodotto.getSconto()/100%>0€</p>
      					<p><strong>prezzo:<del><%=prodotto.getPrezzo()%>0</del></strong>(-<%=prodotto.getSconto()%>%)</p>
      					
      					<% } %>
      					
      					<p><%=prodotto.getDescrizione()%></p>
      				
      				</div>
    			  </div>
				
				<% } %>
			</div>	
		</div>
		
		<% } %>
		<%@ include file = "elements/footer.jsp" %>
	</body>
</html>