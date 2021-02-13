<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.time.LocalDate" import="java.util.ArrayList" import="model.ProdottoNelCarrello" import="model.Utente" import="model.Carrello" %>
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
		if(request.getSession().getAttribute("codiceFattura") == null){
			
		request.setAttribute("avviso", "avviso");
		RequestDispatcher rd = request.getRequestDispatcher("carrello.jsp");
		rd.forward(request, response);
			
			}else{
			
			String codiceFattura = (String) request.getSession().getAttribute("codiceFattura");
			LocalDate dataAcquisto = (LocalDate) request.getSession().getAttribute("dataAcquisto");
			Utente utenteFattura = (Utente) request.getSession().getAttribute("utente");
			Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
			ArrayList<ProdottoNelCarrello> prodottiNelCarrello = carrello.getCarrello();
	%>
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
		
		<div class="container">		
			<div class="cornice-fattura table-responsive">
    			<table class="table table-sm">
    				<tr>
    					<td class="border-0 align-middle"><img class="immagine-fattura" src="images/tizzone-ardente-logo-2.jpg"></td>
    					<td class="border-0 align-middle"><strong>Fattura: <%=codiceFattura%><br> In data: <%=dataAcquisto%></strong></td>
    				</tr>
    				<tr>
    					<td class="border-0 align-middle">Il Tizzone Ardente<br> Università degli studi di Salerno <br> Via Giovanni Paolo II, 132 - 84084 Fisciano (SA)</td>
    					<td class="border-0 align-middle"><strong><%=utenteFattura.getNome()%><br> <%=utenteFattura.getCognome()%><br> <%=utenteFattura.getEmail()%></strong></td>
    				</tr>
    			</table>
    			<div class="table-responsive">
    				<table class="table table-sm">
						<thead>
            				<tr>
                				<th scope="col" class="border-0 bg-light">
                    				<div class="p-2 text-uppercase">Prodotto</div>
                  				</th>
                  				<th scope="col" class="border-0 bg-light">
                    				<div class="py-2 text-uppercase">Costo al dettaglio</div>
                  				</th>
                  				<th scope="col" class="border-0 bg-light">
                    				<div class="py-2 text-uppercase">Quantità</div>
                  				</th>
                  				<th scope="col" class="border-0 bg-light">
                    				<div class="py-2 text-uppercase">Costo</div>
                  				</th>
                			</tr>
						</thead>				
						<%
											double prezzoTotale = 0;
														for(ProdottoNelCarrello po: prodottiNelCarrello){ 
															prezzoTotale += (po.getProdotto().getPrezzo() - po.getProdotto().getPrezzo() * po.getProdotto().getSconto()/100) * po.getQuantità();
										%>
						<tr>
							<td class="border-0 align-middle"><strong><%=po.getProdotto().getNome()%></strong></td>
                  			<td class="border-0 align-middle"><strong><%=po.getProdotto().getPrezzo()-po.getProdotto().getPrezzo()*po.getProdotto().getSconto()/100%>0€</strong></td>
                  			<td class="border-0 align-middle"><strong><%=po.getQuantità()%></strong></td>
                  			<td class="border-0 align-middle"><strong><%=(po.getProdotto().getPrezzo()-po.getProdotto().getPrezzo()*po.getProdotto().getSconto()/100) * po.getQuantità()%>0€</strong></td>
						</tr>
						<%} %>
						<tr>
	                		<th scope="row" class="border-0">
    	            			<div class="p-2 ml-3 d-inline-block align-middle">Prezzo Totale:</div>
                			</th>
               				<td class="border-0"></td>
               				<td class="border-0"></td>
               				<td class="border-0 align-middle"><strong><%=prezzoTotale%>0€</strong></td>
               			</tr>		
					</table>
				</div>
    		</div>
    		<a href="Acquisto"><button class="btn btn-warning mt-3">Acquista</button></a>
    	</div>
		<%@ include file = "elements/footer.jsp" %>
		<% } %>
	</body>
</html>