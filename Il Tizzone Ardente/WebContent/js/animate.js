$(document).ready(function(){
  $("#immagine-pagina-prodotto").mouseenter(function(){
	  
	  $("#immagine-pagina-prodotto").animate({opacity: "0.5"});
	  
  });
  
 $("#immagine-pagina-prodotto").mouseleave(function(){
	  
	  $("#immagine-pagina-prodotto").animate({opacity: "1"});
	  
  });
});