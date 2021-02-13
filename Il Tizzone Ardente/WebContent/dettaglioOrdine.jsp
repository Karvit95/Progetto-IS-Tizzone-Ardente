<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList" import="model.DettagliOrdine" import="model.ProdottoAcquistato" import="model.Utente" %>
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
		<title>Il tizzone ardente</title>
		
	</head>	
	
	<%
				DettagliOrdine dettagliOrdine = (DettagliOrdine) request.getAttribute("dettagliOrdine");
						   Utente utenteOrdine = (Utente) request.getAttribute("utente");
			%>

	<body>
	
		<%@ include file = "elements/header.jsp" %>
		<%@ include file = "elements/navbar.jsp" %>
		
		<div class="container">		
			<div class="table-responsive">
    			<table class="table table-sm">
    				<thead>
            			<tr>
                			<th scope="col" class="border-0 bg-light">
                    			<div class="py-2 text-uppercase">Codice Fattura</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-light">
                    			<div class="py-2 text-uppercase">Data Acquisto</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-light">
                    			<div class="py-2 text-uppercase">Nome</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-light">
                    			<div class="py-2 text-uppercase">Cognome</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-light">
                    			<div class="py-2 text-uppercase">Email</div>
                  			</th>
                		</tr>
					</thead>
						<tr>
							<td class="border-0 align-middle"><strong><%=dettagliOrdine.getCodiceFattura()%></strong></td>
                  			<td class="border-0 align-middle"><strong><%=dettagliOrdine.getDataDiAcquisto()%></strong></td>
                  			<td class="border-0 align-middle"><strong><%=utenteOrdine.getNome()%></strong></td>
                  			<td class="border-0 align-middle"><strong><%=utenteOrdine.getCognome()%></strong></td>
                  			<td class="border-0 align-middle"><strong><%=utenteOrdine.getEmail()%></strong></td>
                		</tr>
				</table>
			</div>
			<div class="table-responsive">
    			<table class="table table-sm">
					<thead>
            			<tr>
                			<th scope="col" class="border-0 bg-light">
                    			<div class="p-2 px-3 text-uppercase">Prodotto</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-light">
                    			<div class="py-2 text-uppercase">IVA</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-light">
                    			<div class="py-2 text-uppercase">Quantità</div>
                  			</th>
                  			<th scope="col" class="border-0 bg-light">
                    			<div class="py-2 text-uppercase">Prezzo Pagato</div>
                  			</th>
                		</tr>
					</thead>
					<%
						for (ProdottoAcquistato c: dettagliOrdine.getProdottiAcquistati()) {
					%>
					<tr>
            			<th scope="row" class="border-0">
                			<div class="p-2">
                    			<img src="<%=c.getProdotto().getImmagine()%>" alt="" width="70" class="img-fluid rounded shadow-sm">
                      			<div class="ml-3 d-inline-block align-middle">
                        			<h5 class="mb-0"> <a href="GenerazionePaginaProdotto?id=<%=c.getProdotto().getId()%>" class="text-dark d-inline-block align-middle"><%= c.getProdotto().getNome()%></a></h5><span class="text-muted font-weight-normal font-italic d-block">Categoria: <%=c.getProdotto().getCatalogo()%></span>
                      			</div>
                    		</div>
                  		</th>
                  		<td class="border-0 align-middle"><strong><%=c.getComposizione().getIva() %></strong></td>
                  		<td class="border-0 align-middle"><strong><%=c.getComposizione().getQuantità() %></strong></td>
                  		<td class="border-0 align-middle"><strong><%=c.getComposizione().getPrezzoPagato()%>0</strong></td>
                	</tr>
		
					<% } %>
					<tr>
                		<th scope="row" class="border-0">
                			<div class="p-2 ml-3 d-inline-block align-middle">
                				Prezzo Totale:
                			</div>
                		</th>
               			<td class="border-0"></td>
               			<td class="border-0"></td>
               			<td class="border-0 align-middle"><strong><%=dettagliOrdine.getPrezzoTotale()%>0</strong></td>
               		</tr>	
				</table>
			</div>
		</div>
		
		<%@ include file = "elements/footer.jsp" %>
		
	</body>
</html>