<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList" import="model.ProdottoConIllustrazione"%>
<!DOCTYPE html>

<html>

	<head>
	
		<meta name="Author" content="Pietro Coppola e Carlo Vitale">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, inital-scale=1.0">
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.6.0/slick.css"/>
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.6.0/slick.min.css"/>
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.css"/>
		
	</head>

	<% if(getServletContext().getAttribute("galleriaImmagini") != null && getServletContext().getAttribute("galleriaImmagini") !=null) {
		ArrayList<ProdottoConIllustrazione> listaProdotti = (ArrayList<ProdottoConIllustrazione>) getServletContext().getAttribute("galleriaImmagini");
		ArrayList<ProdottoConIllustrazione> listaProdottiScontati = (ArrayList<ProdottoConIllustrazione>) getServletContext().getAttribute("galleriaImmaginiSconti");
		%>
	
	<div class="galleria-prodotti fontFantasy col-sm-12">
		<h1><strong>PRODOTTI SCONTATI</strong></h1>
		<div class="galleria"> 
			<% for(ProdottoConIllustrazione prodottoScontato: listaProdottiScontati) {%>
					<div class="prodottoInGalleria"><img class="img-fluid" src="<%=prodottoScontato.getImmagine().getUrl()%>"><a href="GenerazionePaginaProdotto?id=<%=prodottoScontato.getProdotto().getId()%>"><h4><%=prodottoScontato.getProdotto().getNome()%></h4></a><p class="price"><%=prodottoScontato.getProdotto().getPrezzo()-prodottoScontato.getProdotto().getPrezzo()*prodottoScontato.getProdotto().getSconto()/100%>0€</p><p class="titlePrice"><strong>prezzo: <del><%=prodottoScontato.getProdotto().getPrezzo()%>0</del></strong>(-<%=prodottoScontato.getProdotto().getSconto()%>%)</p><p><%=prodottoScontato.getProdotto().getDescrizione()%></p></div>
			<% } %>
			</div>
		</div>
		
		<div class="galleria-prodotti fontFantasy col-sm-12">
		<h1><strong>PRODOTTI IN EVIDENZA</strong></h1>
		<div class="galleria"> 
			<% for(ProdottoConIllustrazione prodottoInEvidenza: listaProdotti) {%>
				<div class="prodottoInGalleria"><img class="img-fluid" src="<%=prodottoInEvidenza.getImmagine().getUrl()%>"><a href="GenerazionePaginaProdotto?id=<%=prodottoInEvidenza.getProdotto().getId()%>"><h4><%=prodottoInEvidenza.getProdotto().getNome()%></h4></a><p class="price"><p class="titlePrice"><strong>prezzo: <%=prodottoInEvidenza.getProdotto().getPrezzo()%>0€</strong></p><p><%=prodottoInEvidenza.getProdotto().getDescrizione()%></p></div>
			<% } %>
			</div>
		</div>
		
		
  		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.1.0/jquery-migrate.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
		<script type="text/javascript">
		
		$(document).ready(function(){
  			$(".galleria").slick({
  			slidesToShow: 5,
  			arrows: true,
 			dots:true,
 			slidesToScroll: 1,
 			centerMode: true,
 			variableWidth: true,
 			responsive: [
 			    {
 			      breakpoint: 1024,
 			      settings: {
 			        slidesToShow: 3,
 			        slidesToScroll: 3,
 			        infinite: true,
 			        dots: true
 			      }
 			    },
 			    {
 			      breakpoint: 600,
 			      settings: {
 			        slidesToShow: 2,
 			        slidesToScroll: 2
 			      }
 			    },
 			    {
 			      breakpoint: 480,
 			      settings: {
 			        slidesToShow: 1,
 			        slidesToScroll: 1
 			      }
 			    }
 			  ]
 			});
		});
		</script>
	<% }%>
</html>