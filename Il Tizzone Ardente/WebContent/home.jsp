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
  		<link rel="stylesheet" type="text/css" href="style.css">
		<title>Il tizzone ardente</title>
	
	</head>
		
	<body>
	
		<%@ include file = "elements/header.jsp" %>
		<%@ include file = "elements/navbar.jsp" %>
	
		<div class = "container-fluid">
		
			<div class="row">
			
				<!-- Slider di immagini -->
  				<div id="slider" class="carousel slide col-sm-12" data-ride="carousel">
  	
  					<!-- slideshow -->
  					<div class="carousel-inner">
  	
    					<div class="carousel-item active">
							<img class="img-fluid" src="images/elmi.jpg" alt="elmi" width="1100" height="500">
    					</div>
    	
    					<div class="carousel-item">
      						<img class="img-fluid" src="images/immagine.jpg" alt="Spade" width="1100" height="500">
    					</div>
    					
    					<div class="carousel-item">
      						<img class="img-fluid" src="images/battaglia.png" alt="battaglia" width="1100" height="500">
    					</div>
    	
					</div>
  	
  				</div>
  			</div>
  				
  			<div class="row">
  				
  				<!-- Galleria di immagini che illustra i prodotti venduti -->
  				<div class="col-sm-12"> <%@ include file = "elements/imageGallery.jsp" %> </div>
  				
			 </div>
			 
		</div> 
		
		<!-- Modal -->
  		<div class="modal fade" id="successoRegistrazione">
    		<div class="modal-dialog">
    
    			<!-- Modal content-->
    			<div class="modal-content">
       				<div class="modal-body">
       					<p> <strong> Registrazione avvenuta con successo </strong> </p>
       					<button type="button" class="btn btn-warning" id="successoRegistrazioneButton">Continua sul sito</button>
       				</div>
    			</div>
  			</div>
  		</div>

		<% if(request.getAttribute("successoRegistrazione") != null) {%>
	
		<script type="text/javascript">
			$(document).ready(function(){
  			
  				$("#successoRegistrazione").modal("show");
    
  			$("#successoRegistrazioneButton").click(function(){
    			$("#successoRegistrazione").modal("hide");
 	 			});
			});
		</script>
	
		<% request.removeAttribute("successoRegistrazione");
	
		} %>	
		
		<%@ include file = "elements/footer.jsp" %>
	</body>
</html>