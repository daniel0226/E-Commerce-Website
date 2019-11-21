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
        	<form method="GET" action="bookingController" class="wrapper seating">
        		<section class="container s-bd" style="background: none;">
        			<div class="row justify-content-center">
        				${errorMsg}
        			</div>
        			<div class="row justify-content-center" style="margin-bottom: 15px; position: relative">
        				<div id="b" class="col-md-2 b">
        					<p>Available</p>
        				</div>
        				<div id="g" class="col-md-2 g">
        					<p>Not Available</p>
        				</div>
        				<div id="w" class="col-md-2 w">
        					<p style="color: black; text-shadow: none;">Selected</p>
        				</div>
        			</div>
        			${seatStructure}
        		</section>
        		<section class="container">
        			<div class="row justify-content-center">
        				<div class="col-md-4">
        					<input style="display: none;" name="max" value="${max}">
        					<button class="sbmS" type="submit" name="bookShowTime" value="${id}">Submit</button>
        				</div>
        			</div>
        		</section>
        		<section style="display: none;">
        			<input style="display: none;" name="child" value="${child}">
        			<input style="display: none;" name="adult" value="${adult}">
        			<input style="display: none;" name="senior" value="${senior}">
        		</section>
        	</form>
        </main>
    </body>
    <footer></footer>
</html>