<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.SQLException, eCommerce.UserData.sessionData, eCommerce.users.WebUser, eCommerce.Database.Database, java.util.List, eCommerce.Controllers.dateController, eCommerce.MovieData.Movie, eCommerce.Strings.generateHTMLController"%>
	
<%
	if(Database.getDatabase() == null) {
   		try {
   			new Database();
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   	}

   	WebUser user = sessionData.getCurrentSessionUser();
   	
   	if (user == null){
   		System.out.println("User was not found");
   	}
   	
   	pageContext.setAttribute("userName",user);
%>
	
<!DOCTYPE html>
<html lang = "en">
	<head>
		<meta charset="ISO-8859-1">
		<!-- Required meta tags -->
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    	<!-- Bootstrap CSS -->
    	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	 	<link rel="stylesheet" type="text/css" href="./css/OrderSummary.css">
		
		<title>CSCI 4050</title>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  			<a class="navbar-brand" href="index.jsp">Return to Home Page</a>
  			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    			<span class="navbar-toggler-icon"></span>
  			</button>
  			<div class="collapse navbar-collapse" id="navbarNav">
    			<ul class="navbar-nav">
    			</ul>
  			</div>
		</nav>
		<div class="container center mt-5">
			<div class="card text-center bg-dark text-white see-thru">
  				<div class="card-body">
    				<h5 class="card-title display-3">Order Summary</h5>
   					<p class="card-text"><em>Enjoy the show, ${userName}!</em></p>
   					
   					

   					
   					
   					
   					<div class="row lead font-weight-bold">
   						<div class="col"><u>Movie Title</u></div>
   						<div class="col"><u>Tickets</u></div>   						
   					</div>
   					<div class="row lead">
   						<div class="col"><p>#movieTitleHere</p></div>
   						<div class="col"><p>#selectedTicketsHere</p></div>
   					</div>
   					
   					<div class="row lead font-weight-bold">
   						<div class="col"><u>Movie Rating</u></div>
   						<div class="col"><u>Total Price</u></div>
   					</div>
   					<div class="row lead">   					
   					   	<div class="col"><p>#movieRatingHere</p></div>
   						<div class="col"><p>#totalPriceHere</p></div>
   					</div>
   					
   					<div class="row lead font-weight-bold">
   						<div class="col"><u>Movie Showtime</u></div>
   						<div class="col"><u>Order Number</u></div>
   					</div>
   					<div class="row lead">				
   					   	<div class="col"><p>#movieShowtimeHere</p></div>
   						<div class="col"><p>#orderNumberHere</p></div>
   					</div>
    				<button onclick="printPage()" class="btn btn-primary">Print this page</button>
    				
    				
  				</div>
			</div>
		</div>
		
    	<!-- Optional JavaScript -->
    	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    	<script>
    		function printPage() {
    			window.print();
    		}
    	</script>
	</body>
</html>