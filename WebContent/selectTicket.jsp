<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="en">
    
    <head>
        <title>CSCI4050</title>
    
        <!--Responsive design-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Yong Kim">
        <meta charset="utf-8">
    
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/animation.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
            integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    
    
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
            <script src="js/fields.js"></script>
    </head>
    
    <body>
        <header>${nav}</header>
        <main class="showTimesBody">
        	<div class="wrapper">
        		<section class="container">
        			<div class="row">
        				<div class="col-sm-4 col-md-4">
        					<div class="ticketMovieInfo" style="padding: 5px 16px;">
        						<img src="images/MoviePhoto/${moviePhoto}" alt ="pic">
        						<h2 style="text-align: left;">${cinemaID}</h2>
        						<p>${Date}</p>
        						<p>At ${Time}</p>
        					</div>
        				</div>
        				<div class="col-sm-8 col-md-8">
        					<div class="container removeLeftPadding removeRightPadding">
        						<div class="row">
        							<div class="col-sm-12 col-md-12">
        								<div class="ticketMovieInfo">
        									<h2 style="font-size: 2rem; text-align: center;">${title}</h2>
        									${errorMsg}
        								</div>
        							</div>
        						</div>
        						<div class="row" style="margin-top: 15px; text-align: center;">
        							<div class="col-sm-4 col-md-4">
        								<div class="ticketMovieInfo">
        									<h2>Tickets</h2>
        								</div>
        							</div>
        							<div class="col-sm-4 col-md-4">
        								<div class="ticketMovieInfo">
        									<h2>Price</h2>
        								</div>
        							</div>
        							<div class="col-sm-4 col-md-4">
        								<div class="ticketMovieInfo">
        									<h2>Quantity</h2>
        								</div>
        							</div>
        						</div>
        						<div class="row" style="margin-top: 15px; text-align: center;">
        							<div class="col-sm-4 col-md-4">
        								<div class="ticketMovieInfo">
        									<div class="ticketInfo">
        										<p>SENIOR</p>
        									</div>
        									<div class="ticketInfo">
        										<p>ADULT</p>
        									</div>
        									<div class="ticketInfo">
        										<p>CHILD</p>
        									</div>
        								</div>
        								
        							</div>
        							<div class="col-sm-4 col-md-4">
        								<div class="ticketMovieInfo">
        									<div class="ticketInfo">
        										<p>${senior}</p>
        									</div>
        									<div class="ticketInfo">
        										<p>${adult}</p>
        									</div>
        									<div class="ticketInfo">
        										<p>${child}</p>
        									</div>
        								</div>
        							</div>
        							<form method="GET" action="bookingController" class="col-sm-4 col-md-4">
        								<div class="ticketMovieInfo" style="margin-bottom: 15px;">
        									<div class="ticketInfo i-b">
        										<button type="button" onclick="decreaseCount('senior')">-</button>
        										<input id="senior" type="number" value="0" name="senior" readonly>
        										<button type="button" onclick="increaseCount('senior')">+</button>
        									</div>
        									<div class="ticketInfo i-b">
        										<button type="button" onclick="decreaseCount('adult')">-</button>
        										<input id="adult" type="number" value="0" name="adult" readonly>
        										<button type="button" onclick="increaseCount('adult')">+</button>
        									</div>
        									<div class="ticketInfo i-b">
        										<button type="button" onclick="decreaseCount('child')">-</button>
        										<input id="child" type="number" value="0" name="child" readonly>
        										<button type="button" onclick="increaseCount('child')">+</button>
        									</div>
        								</div>
        								<div class="submitTicketForm">
        									<button type="submit" name="submitTicket" value="${id}">Submit</button>
        								</div>
        							</form>
        						</div>
        					</div>
        				</div>
        			</div>
        		</section>
        	</div>
        </main>
    </body>
    <footer></footer>
</html>