<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Utente"%>
<!DOCTYPE html>

<html>

	<head>

		<meta name="Author" content="Pietro Coppola e Carlo Vitale"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, inital-scale=1.0"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  		<link rel="stylesheet" href="style.css">
	
	</head>
			
	<button id="loginERegistrazioneButton" type="button" class="btn btn-warning" data-toggle="modal" data-target="#LoginModal"> Login/registrati </button>
	
	<div class="modal fade" id="LoginModal">
  		<div class="modal-dialog">
    		<div class="modal-content">
    			<div class="modal-header">
       				<h3 class="modal-title" id="LoginModalLabel"> Login </h3>
       				<button type="button" class="close" data-dismiss="modal">
        		    	<span aria-hidden="true">&times;</span>
    				</button>
                </div>
    	            
    			<div class="modal-body">
					<form action="Login" method="post">
						<div class="form-group row">
   	
   							<label class="col-sm-2 col-form-label" for="email">Email:</label>
    						<div class="col-sm-10">
        						<input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
      			 			</div>
    					</div>
     					<div class="form-group row">
      				
      						<label class="col-sm-2 col-form-label" for="pwd">Password:</label>
      						<div class="col-sm-10">          
  								<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
   							</div>
   						</div>
    						
   						<div class="form-group">        
   							<div class="col-sm-offset-2 col-sm-10">
   								<button type="submit" class="btn btn-warning">Accedi</button>
   							</div>
   						</div>
 					</form>
				</div>
      				
   				<div class="modal-footer">				
     				<p> se non hai un account, <a href="registrazione.jsp"> registrati </a>
     			</div>
   			</div>
  		</div>
	</div>
	
	<% 
		if(request.getAttribute("emailNonTrovata") != null){
	%>
		<script>
			$(document).ready(function(){
  			
  				$("#LoginModal").modal("show");
  				$("#LoginModalLabel").append("<div class=\"alert alert-danger\"> L'email inserita non appartiene a nessun account</div>");
				
  				$("#LoginModal").on('hidden.bs.modal', function(){
  				    $(".alert").remove()
  				  });
			});
		</script>
		
	<% 	
			request.removeAttribute("EmailNonTrovata");
	} %>
	
	<% 
		if(request.getAttribute("PasswordErrata") != null){
	%>
		<script>
			$(document).ready(function(){
  			
  				$("#LoginModal").modal("show");
  				$("#LoginModalLabel").append("<div class=\"alert alert-danger\"> La password inserita è sbagliata </div>");
  				
  				$("#LoginModal").on('hidden.bs.modal', function(){
  				    $(".alert").remove()
  				  });
			});
		</script>
		
	<% 	
			request.removeAttribute("PasswordErrata");
	} %>
</html>