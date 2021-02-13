<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Carrello" import="java.util.ArrayList" import="model.ProdottoNelCarrello"%>
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
	
	</head>
	
	<body>
	
	<%@ include file = "elements/header.jsp" %>
	<%@ include file = "elements/navbar.jsp" %>
	
	<%
			Carrello carrello;
				ArrayList<ProdottoNelCarrello> prodottiNelCarrello = new ArrayList<ProdottoNelCarrello>();
				double prezzoTotale = 0;
				
				if(request.getSession().getAttribute("carrello") != null){
			carrello = (Carrello) request.getSession().getAttribute("carrello");
			prodottiNelCarrello = carrello.getCarrello();
				}
				
				if((request.getSession().getAttribute("carrello") == null) || prodottiNelCarrello.isEmpty()){
		%>
		
			<h2> Il tuo carrello è vuoto. </h2>
			<p>	Il tuo carrello è vuoto. Per aggiungere articoli al tuo carrello naviga su <a href="home.jsp"> Il Tizzone Ardente </a>, e quando trovi un articolo che ti interessa clicca su "Aggiungi al carrello". </p>
			<p> Continua a fare acquisti sul sito web Il tizzone ardente, scopri i nostri prodotti.</p>
			<p> I prezzi degli articoli nel tuo carrello riflettono sempre il prezzo più recente visualizzato sulle relative pagine prodotto. </p>
		
	<%
				}else{
			%>
 	
 		<div class="container">
		<h2> Carrello </h2>
			
			<div class="table-responsive">
    			<table class="table table-sm table-bordered">
        			<thead>
            			<tr>
                			<th scope="col" class="border-0 bg-warning">
                    			<div class="py-2 text-uppercase">Prodotto</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-warning">
                    			<div class="py-2 text-uppercase">Prezzo</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-warning">
                    			<div class="py-2 text-uppercase">Quantità</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-warning">
                    			<div class="py-2 text-uppercase">Prezzo Totale</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-warning">
                    			<div class="py-2 text-uppercase">Rimuovi</div>
                  			</th>
                		</tr>
					</thead>
 					<tbody>
 						<%
 							for(ProdottoNelCarrello po: prodottiNelCarrello){
 						%>
            			<tr>
            				<th scope="row" class="border-0">
                				<div class="p-2">
                      				<img src="<%=po.getProdotto().getImmagine()%>" alt="" width="70" class="img-fluid rounded shadow-sm">
                      				<div class="ml-3 d-inline-block align-middle">
                        				<h5 class="mb-0"> <a href="GenerazionePaginaProdotto?id=<%=po.getProdotto().getId()%>" class="text-dark d-inline-block align-middle"><%= po.getProdotto().getNome()%></a></h5><span class="text-muted font-weight-normal font-italic d-block">Categoria: <%=po.getProdotto().getCatalogo()%></span>
                      				</div>
                    			</div>
                  			</th>
                  			<td class="border-0 align-middle"><strong><%=po.getProdotto().getPrezzo()-po.getProdotto().getPrezzo()*po.getProdotto().getSconto()/100%>0</strong></td>
                  			<td class="border-0 align-middle"><strong><%=po.getQuantità() %></strong></td>
                  			<td class="border-0 align-middle"><strong><%=(po.getProdotto().getPrezzo()-po.getProdotto().getPrezzo()*po.getProdotto().getSconto()/100) * po.getQuantità()%>0</strong></td>
                  			<td class="border-0 align-middle"><a href="RimozioneProdottoCarrello?id=<%=po.getProdotto().getId()%>"><button  type="submit" class="remove btn btn-warning"> <i class='fas fa-times'></i> Rimuovi dal carrello </button></a></td>
                		</tr>
                		
                		<%
                	
                		prezzoTotale += (po.getProdotto().getPrezzo()-po.getProdotto().getPrezzo()*po.getProdotto().getSconto()/100) * po.getQuantità();
                		
                		 }
                		 %>
                		<tr>
                			<th scope="row" class="border-0">
                				<div class="p-2 ml-3 d-inline-block align-middle">
                					<p> Prezzo totale del carrello: </p>
                				</div>
                			</th>
                			<td class="border-0"></td>
                			<td class="border-0"></td>
                			<td class="border-0 align-middle"><strong><%=prezzoTotale%>0€</strong></td>
                		</tr>
                		<tr>
                			<th scope="row" class="border-0">
                				<div class="p-2 ml-3 d-inline-block align-middle">
                					<a href="spedizione.jsp"><button class="btn btn-warning">Procedi all'ordine</button></a>
                				</div>
                			</th>
						</tr>
					</tbody>
				</table>
			</div>
			
				
			
		</div>
		<% } %>
		
		<!-- Modal -->
  			<div class="modal fade" id="avviso">
    		<div class="modal-dialog">
    
    			<!-- Modal content-->
    			<div class="modal-content">
       				<div class="modal-body" id="modalCarrelloBody">
       					
       					<button type="button" class="btn btn-warning" id="avvisoLoginButton">Continua</button>
       				</div>
    			</div>
  			</div>
  		</div>

		<% if(request.getAttribute("avviso") != null) {%>
	
		<script type="text/javascript">
			$(document).ready(function(){
  			
  				$("#avviso").modal("show");
  				$("#modalCarrelloBody").prepend("<p> <strong> Errore, se visualizzi questo messaggio accedi col tuo account oppure segui il percorso corretto per effettuare un acquisto </strong> </p>");
  				
    
  			$("#avvisoLoginButton").click(function(){
    			$("#avviso").modal("hide");
 	 			});
			});
		</script>
	
		<% request.removeAttribute("avviso");
	
		} %>	
		<%@ include file = "elements/footer.jsp" %>
	</body>
</html>