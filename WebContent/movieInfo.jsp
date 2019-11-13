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
	.navbar
	{
		position: relative !important;
	}
	nav
	{
		background: black !important;
	}
</style>

<body>
    <header style="position: relative;">${nav}</header>
    <main class="moviesPageBody">
    	<section class="movieTrailer">
    		${movieTrailer}
    	</section>
    	<section class="movieInfoBody">
    		<div class="container-fluid">
    			<div class="row">
    				<div class="col-sm-12 col-md-12">
    					<h2>${movieTitle}</h2>
    				</div>
    			</div>
    			<div class="row">
    				<div class="col-sm-6 col-md-6">
    					<div class="movieInfo">
    						<label>Director:</label>
    						<p>${Director}</p>
    					</div>
    					<div class="movieInfo">
    						<label>Producer:</label> 
    						<p>${Producer}</p>
    					</div>
    					<div class="movieInfo">
    						<label>Cast: </label>
    						<p>${Cast}</p>
    					</div>
    					<div class="movieInfo">
    						<label>Rating: </label>
    						<p>${Rating}</p>
    					</div>
    					<div class="movieInfo">
    						<label>Category: </label>
    						<p>${Category}</p>
    					</div>
    					<div class="movieInfo">
    						<label>Release Date: </label>
    						<p>${ReleaseDate}</p>
    					</div>
    				</div>
    				<div class="col-sm-6 col-md-6">
    					<p>${Synopsis}</p>
    					${Book}			
		       		</div>
    			</div>
    			<hr>
    			<div class="row" style="margin-top: 10px;">
    				<div class="col-md-12 movieSchedule">
    					<h2>Show Times:</h2>
    					${showTimes}
    				</div>
    			</div>
    			<hr>
    			<div class="row">
    				<div class="col-md-3">
    					<h2>Reviews: </h2>
    				</div>
    				<div class="col-md-9">
    					${Reviews}
    				</div>
    			</div>
    			<hr>
    			${addReview}
    		</div>
    	</section>
    </main>
    <footer>
    </footer>
</body>

</html>