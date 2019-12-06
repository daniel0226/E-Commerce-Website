<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.SQLException, eCommerce.UserData.sessionData, eCommerce.Database.Database, java.util.List, eCommerce.Controllers.dateController, eCommerce.MovieData.Movie, eCommerce.Strings.generateHTMLController"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSCI4050</title>

<!--Responsive design-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Yong Kim">
<meta charset="utf-8">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/animation.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1//jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="js/fields.js"></script>
</head>

<body>
<% 
				session = sessionData.getCurrentSession();
				if(session != null)
				{
					pageContext.setAttribute("nav", generateHTMLController.nav_LI());
				}else
				{
					pageContext.setAttribute("nav", generateHTMLController.nav_LO());
				}
				String html = "";
				String html2 = "";
				Database.validateDatabase(Database.getDatabase());
				try {
					List<Movie> movies = Database.getAllMovies();
					if(movies.size() != 0)
					{
						for(int i = 0; i<movies.size(); i++)
						{
							Movie curMovie = movies.get(i);
							if(dateController.movieIsInTheatres(curMovie))
							{
								html += generateHTMLController.indexInTheatres(curMovie);
							}else if(dateController.movieIsComingSoon(curMovie))
							{
								html2 += generateHTMLController.indexComingSoon(curMovie);
							}
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pageContext.setAttribute("movies", html);
				pageContext.setAttribute("movies2", html2);
			%>
			
	<header>${nav}</header>
	<section class="homePage parallax">
		<div class="container JokerBody">
			<div class="row ">
				<div class="col-md-6">
					<h1 class="movieTitle">
						JOKER
					</h1>
					<h2>"I used to think that my life was a tragedy, but now I
						realize, it's a comedy."</h2>
					<p>Failed comedian Arthur Fleck encounters violent thugs while
						wandering the streets of Gotham City dressed as a clown.
						Disregarded by society, Fleck begins a slow dissent into madness
						as he transforms into the criminal mastermind known as the Joker.</p>
					<a href="loadObjectsToHtmlController?type=Joker">Learn More</a>
				</div>
			</div>
		</div>
	</section>
	<div class="inTheatresHeader">
		<h2>In Theatres Now</h2>
		<button class="Innext">Next</button>
		<button class="Inprev">Prev</button>
	</div>
	<section id="intheatrepage" class="indexInTheatresPage">
		<div class="carouselInTheatre">
			${movies}
		</div>
	</section>
	<div class="inTheatresHeader">
		<h2>Coming Soon</h2>
		<button class="next">Next</button>
		<button class="prev">Prev</button>
	</div>
	<section id="comingSoonPage" class="indexInTheatresPage">
		<div class="carouselComingSoon">
			${movies2}
		</div>
	</section>
	<footer> </footer>
</body>

<script type="text/javascript">setUpCarouselCenter();</script>
<script type="text/javascript">setUpCarouselCenter2();</script>
</html>