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

<style>
	.s-2 p{
		border: solid 1px #4C79D3;
	    box-shadow: 0px 0px 3px white;
	    padding: .5rem !important;
	    position: relative;
	}
	.s-2 label
	{
		position: absolute;
	    top: -12px;
	    left: 7px;
	    z-index: 5;
	    background: #131822;
	}
	.s-2 button
	{
	    font-size: 1.25rem;
	    font-weight: 600;
	    padding: 15px 3px;
	    position: relative;
	    width: 100%;
	    text-decoration: none;
	    transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
	    color: white;
	    border: solid 2px #00aeef;
    	box-shadow: 0px 0px 3px white;
    	background: none;
    	border-radius: 8px;
	}
	.s-2 button:hover
	{
		box-shadow: 0px 0px 8px white;
	}
</style>
<body>
    <header>${nav}</header>
    <main class="showTimesBody s-2">
        <div class="wrapper">
       		<section class="container">
       			<div class="row justify-content-center">
       				<div class="col-sm-6 col-md-6">
       					<div class="ticketMovieInfo">
       						<form method="GET" action="orderController" class="orderSummaryBody">
								<h2>Order Summary</h2>
								<div class="promotions">
									<label for="movieTitle">Movie</label>
									<p id="movieTitle">${title}</p>
								</div>
								<div class="promotions">
									<label for="Theatre">Theatre</label>
									<p id="Theatre">${Theatre}
								</div>
								<div class="promotions">
									<label for="ShowTime">ShowTime</label>
									<p id="ShowTime">${ShowTime}</p>
								</div>
								<div class="promotions">
									<label for="Seats">Seats</label>
									<p id="Seats">${Seats}</p>
								</div>
								<div class="promotions">
									<label for="Total">Total</label>
									<p id="Total">${Total}</p>
								</div>
								<div class="promotions">
									<p>Using card ending with: ${CardEnding}</p>
								</div>
								<div class="promotios">
									<input class="p-input-promo" type="text" name="promo" placeholder="Promotion ID">
								</div>
								<div class="promotions">
									<div class="fluid-container removeLeftPadding removeRightPadding">
										<div class="row">
											<div class="col-md-6">
												<input type="text" style="display: none;" value="${seatsEnc}" name="seatsEnc">
												<input type="text" style="display: none;" value="${aT}" name="adult">
												<input type="text" style="display: none;" value="${sT}" name="senior">
												<input type="text" style="display: none;" value="${cT}" name="child">
												<input type="text" style="display: none;" value="${seatingID}" name="seatID">
												<button name="checkout" value="${showtimeId}">Check Out</button>
											</div>
											<div class="col-md-6">
												<button name="cancel" value="cancel">Cancel</button>
											</div>
										</div>
									</div>
								</div>
							</form>
       					</div>
       				</div>
       			</div>
        	</section>
        </div>
       </main>
    <footer></footer>
</body>

</html>