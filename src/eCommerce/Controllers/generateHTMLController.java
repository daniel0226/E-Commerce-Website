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
	
	//Need to implement
	public static String generateAdminPageMoviesList(Movie movie)
	{
		String adminPageMovieHTML = 
		"<div class=\"row movieObjects\" id=\"" + movie.getMovieTitle() + "\">" +
		"    <div class=\"col-md-1\">"+
		"        <input type=\"checkbox\" name=\"movieCheckbox\" value=\"" + movie.getMovieTitle() + "\" name=\"" + movie.getMovieTitle() + "\">"+
		"    </div>"+
		"    <div class=\"col-md-3 borderL-xs borderR-xs moviePicBody\">"+
		"        <div class=\"moviePic\">"+
		"            <img src=\"images/MoviePhoto/" + movie.getMoviePicture() + "\" alt=\"" + movie.getMovieTitle() + "\">"+
		"            <button class=\"editBtn adminBtn\" id=\"" + movie.getMovieTitle() + "Btn" + "\" onclick=\"showEditTab('"+ movie.getMovieTitle() + "Info" + "', '" + movie.getMovieTitle() + "Btn" +"')\" type=\"button\""+
		"                style=\"width: 100%; display: block;\" value=\"Edit\">Edit</button>"+
		"        </div>"+
		"    </div>"+
		"    <div class=\"col-md-8 movieInfoDisplay\" id=\"" + movie.getMovieTitle() + "Info" + "\">"+
		"        <div class=\"container\">"+
		"            <div class=\"row\">"+
		"                <div class=\"col-md-6\">"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Movie"+
		"                            Picture</label>"+
		"                        <input type=\"file\" name=\"pic\" accept=\"image/*\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Movie"+
		"                            Trailer URL</label>"+
		"                        <input type=\"text\" name=\"video\" placeholder=\"" + movie.getMovieTrailer() +"\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <input type=\"text\" name=\"title\" placeholder=\""+ movie.getMovieTitle() +"\" class=\"textFieldDes2\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <input type=\"text\" name=\"category\" placeholder=\"" + movie.getMovieCategory() + "\" class=\"textFieldDes2\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <input type=\"text\" name=\"director\" placeholder=\"" + movie.getMovieDirector() + "\" class=\"textFieldDes2\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <input type=\"text\" name=\"producer\" placeholder=\"" + movie.getMovieProducer() +"\" class=\"textFieldDes2\">"+
		"                    </div>"+
		"                </div>" + 
		"				 <div class=\"col-md-6\">"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Synopsis</label>"+
		"                        <textarea name=\"synopsis\" placeholder=\"" + movie.getMovieSynopsis() + "\" class=\"textFieldDes2\""+
		"                            style=\"border: 1.5px solid rgb(45,69,121);\"></textarea>" +
		"					 </div>" +
		"                    <div class=\"movieInfo\">"+
		"                        <input type=\"text\" name=\"Rated\" placeholder=\"" + movie.getMovieRating() + "\" class=\"textFieldDes2\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Expiration"+
		"                            Date:</label>"+
		"                        <input type=\"date\" name=\"expirationDate\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Release"+
		"                            Date:</label>"+
		"                        <input type=\"date\" name=\"releaseDate\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\" style=\"margin-top: 20px;\">"+
		"                        <button class=\"adminBtn\" type=\"submit\" value=\"Update\" name=\"update\">Update</button>"+
		"                        <button class=\"adminBtn\" onclick=\"if(!closeForm('"+ movie.getMovieTitle() + "Info" + "', '"+ movie.getMovieTitle() + "Btn" +"'))return false;\""+
		"                            type=\"button\" value=\"cancel\" name=\"cancel\">Cancel</button>"+
		"                    </div>"+
		"                </div>"+
		"            </div>"+
		"        </div>"+
		"    </div>"+
		"</div>";
		return adminPageMovieHTML;
	}
	
	public static String mostPopularMovieHtml(Movie movie)
	{
		String imgHTML = "<img src=\"images/MoviePhoto/" + movie.getMoviePicture() + "\" alt=\"" + movie.getMovieTitle() + "\">";
		return imgHTML;
	}
}
