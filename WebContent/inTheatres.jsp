<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <main class="inTheatresBody">
        <form style="width: 100%; height: 100%;" action="GET" method="bookingController">
            <div class="container-fluid">
                <div class="row">
						<div class="col-md-3">
							<h2 style="text-align: center; font-weight: bold;">Movies In Theatres</h2>
						</div>
						<div class="col-md-9">
							<input id="searchMovies" class="searchMovies-c" type="text" placeholder="Search Movies" onkeyup="searchMovie()" style="width: 100%;">
						</div>
						<hr>
				</div>
                <div id="comingSoonBody">
                	${moviesInTheatresList}
                </div>
            </div>
        </form>
    </main>

    <footer>
    </footer>
</body>

</html>