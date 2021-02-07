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
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-12 d-flex justify-content-center">
					<h2>Non sei autorizzato ad accedere a questa pagina, torna alla <a href="home.jsp">home</a></h2>
				</div>
			</div>
			
		</div>
		
		<%@ include file = "elements/footer.jsp" %>
		
	</body>

</html>