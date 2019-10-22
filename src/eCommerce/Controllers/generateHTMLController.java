package eCommerce.Controllers;

import eCommerce.MovieData.Movie;
public class generateHTMLController {

	public static String generateInTheatres(Movie movie)
	{
		String addMovieHtml = "<div class=\"row newRow movies\" id=\"" + movie.getMovieTitle()+"\">" +
		"                        <div class=\"col-md-3\">"+
		"                            <ul>"+
		"                                <li><img src=\"images/MoviePhoto/" + movie.getMoviePicture() + "\" alt=\"joker\"></li>"+
		"                                <li>"+
		"                                    <h3>" + movie.getMovieTitle() + "</h3>" +
		"                                </li>"+
		"                                <li><span>Rated: " + movie.getMovieRating() + "</span></li>"+
		"                                <li><span>Released: " + movie.getMovieReleaseDate() + "</span></li>"+
		"                                <li><button class=\"getTickets\" type=\"submit\" name=\"" + movie.getMovieTitle() + "Btn" + "\" value=\"\">Get"+
		"                                        Tickets</button></li>"+
		"                            </ul>"+
		"                        </div>"+
		"                        <div class=\"col-md-9\">"+
		"                            <iframe width=\"560\" height=\"315\" src=\"" + movie.getMovieTrailer() + "\"" +
		"                                frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\""+
		"                                allowfullscreen></iframe>"+
		"                            <h3>Director: " + movie.getMovieDirector() + "</h3>"+
		"                            <h4>Category: " + movie.getMovieCategory() + "</h4>"+
		"                            <span>" + movie.getMovieSynopsis() + "</span>"+
		"                        </div>"+
		"                    </div>";
		return addMovieHtml;
	}
}
