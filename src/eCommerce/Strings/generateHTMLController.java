package eCommerce.Strings;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import eCommerce.Controllers.dateController;
import eCommerce.Database.Database;
import eCommerce.MovieData.*;
import eCommerce.UserData.Order;
import eCommerce.UserData.sessionData;
import eCommerce.users.Administrator;
import eCommerce.users.WebUser;
public class generateHTMLController {

	public static String generateComingSoon(Movie movie)
	{
		String addMovieHtml = "<div class=\"row newRow movies\" id=\"" + movie.getMovieTitle()+"\">" +
				"                        <div class=\"col-md-3\">"+
				"                            <ul>"+
				"                                <li><img src=\"images/MoviePhoto/" + movie.getMoviePicture() + "\" alt=\"joker\"></li>"+
				"                                <li>"+
				"                                    <h3>" + movie.getMovieTitle() + "</h3>" +
				"                                </li>"+
				"                                <li><span>Rated: " + movie.getMovieRating() + "</span></li>"+
				"                                <li><span>Releases: " + movie.getMovieReleaseDate() + "</span></li>"+
				"                            </ul>"+
				"                        </div>"+
				"                        <div class=\"col-md-9\">"+
				"                            <iframe width=\"100%\" height=\"100%\" src=\"" + movie.getMovieTrailer() + "\"" +
				"                                frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\""+
				"                                allowfullscreen></iframe>"+
				"                            <span>" + movie.getMovieSynopsis() + "</span>"+
				"                        </div>"+
				"                    </div>";
				return addMovieHtml;
	}
	public static String movieInfoTrailer(Movie movie)
	{
		return "<iframe width=\"100%\" height=\"100%\" src=\"" + movie.getMovieTrailer() + "\"" +
				"                                frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\""+
				"                                allowfullscreen></iframe>";
	}
	public static String bookMovieForm(Movie movie)
	{

		return "<form style=float-left method=GET action=bookingController>"+
		"			<button class=\"bookingBtn\" type=\"submit\" name=\"book\" value=\"" + movie.getMovieTitle() + "\">Book Now!</button>"+
		"		</form>";
	}
	
	public static String movieReviews(Movie movie)
	{
		List<movieReviews> reviewsList = Database.getMovieReviews(movie);
		System.out.println(reviewsList.size());
		if(reviewsList.size() == 0)
		{
			return "<h2>No Reviews currently!</h2>";
			
		}else
		{
			String html = "";
			for(int i = 0; i<reviewsList.size(); i++)
			{
				html += movieReviewsHTML(reviewsList.get(i));
			}
			return html;
		}
	}
	
	public static String movieReviewsHTML(movieReviews movie)
	{
		return "<div class=\"movieReviewBody\">"+
		"    		<div class=\"reviewBody\">"+
		"    			<label>By: " + movie.getUserName()  + " on " + movie.getDate() + " </label>"+
		"    			<p>" + movie.getReview() + "</p>"+
		"    		</div>" +
		"       </div>";
	}
	
	public static String movieReviewForm(Movie movie)
	{

		return "		<div class=\"row justify-content-center\">"+
		"    				<div class=\"col-md-6\">"+
		"    					<div class=\"userMovieReview\">"+
		"    						<h2>Add a Review!</h2>"+
		"	    					<form method=\"GET\" action=\"movieController\">" +
		"                           	<textarea maxlength=\"255\" required name=\"movieReview\" placeholder=\"Review\"></textarea>" +
		"								<button class=\"submitBtn\" type=\"submit\" name=\"reviewSubmit\" value=\"" + movie.getMovieTitle() + "\">Submit</button>"+
		"	    					</form>"+
		"    					</div>"+
		"    				</div>"+
		"    			</div>";
			

	}
	
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
		"                                <li style=\"margin-top: 30px;\"><a class=\"bookA\" href=\"loadObjectsToHtmlController?type=" +  movie.getMovieTitle() + "\">Learn More!</a></li>"+
		"                            </ul>"+
		"                        </div>"+
		"                        <div class=\"col-md-9\">"+
		"                            <iframe width=\"100%\" height=\"100%\" src=\"" + movie.getMovieTrailer() + "\"" +
		"                                frameborder=\"0\" allow=\"accelerometer; encrypted-media; gyroscope; picture-in-picture\""+
		"                                allowfullscreen></iframe>"+
		"                            <span>" + movie.getMovieSynopsis() + "</span>"+
		"                        </div>"+
		"                    </div>";
		return addMovieHtml;
	}
	
	//public static String generateMovie
	
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
		"                        <input type=\"file\" name=\"pic" + movie.getMovieTitle() + "\" accept=\"image/*\" value=\""+ movie.getMoviePicture() +"\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Movie"+
		"                            Trailer URL</label>"+
		"                        <input type=\"text\" name=\"video" + movie.getMovieTitle() +"\" value=\"" + movie.getMovieTrailer() +"\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Title</label>" +  
		"                        <input type=\"text\" name=\"title" + movie.getMovieTitle() + "\" value=\""+ movie.getMovieTitle() +"\" class=\"textFieldDes2\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Category</label>" +
		"                        <input type=\"text\" name=\"category" + movie.getMovieTitle() + "\" value=\"" + movie.getMovieCategory() + "\" class=\"textFieldDes2\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Director</label>" + 
		"                        <input type=\"text\" name=\"director" + movie.getMovieTitle() + "\" value=\"" + movie.getMovieDirector() + "\" class=\"textFieldDes2\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Producer</label>" + 
		"                        <input type=\"text\" name=\"producer" + movie.getMovieTitle() + "\" value=\"" + movie.getMovieProducer() +"\" class=\"textFieldDes2\">"+
		"                    </div>"+
		"                </div>" + 
		"				 <div class=\"col-md-6\">"+
		"                    <div class=\"movieInfo\">"+
		"                        <label for=\"syn\">Synopsis</label>"+
		"                        <textarea name=\"synopsis" + movie.getMovieTitle() + "\" id=\"syn\" class=\"textFieldDes2\""+
		"                            style=\"border: 1.5px solid rgb(45,69,121);\">" + movie.getMovieSynopsis() + "</textarea>" +
		"					 </div>" +
		"                    <div class=\"movieInfo\">"+
		"                        <label>Rated</label>" +
		"                        <input type=\"text\" name=\"Rated" + movie.getMovieTitle() + "\" value=\"" + movie.getMovieRating() + "\" class=\"textFieldDes2\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Expiration"+
		"                            Date:</label>"+
		"                        <input type=\"date\" name=\"expirationDate" + movie.getMovieTitle() + "\" value=\"" + movie.getMovieExpDate() + "\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Release"+
		"                            Date:</label>"+
		"                        <input type=\"date\" name=\"releaseDate" + movie.getMovieTitle() + "\" value=\"" + movie.getMovieReleaseDate() + "\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\">"+
		"                        <label>Cast</label>"+
		"                        <input class=\"textFieldDes2\" type=\"text\" name=\"cast" + movie.getMovieCast() + "\" value=\"" + movie.getMovieCast() + "\">"+
		"                    </div>"+
		"                    <div class=\"movieInfo\" style=\"margin-top: 20px;\">"+
		"                        <button class=\"adminBtn\" type=\"submit\" value=\"" + movie.getMovieTitle() + "\" name=\"update" + "\">Update</button>"+
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
	public static String logoutSuccessful()
	{
		String logoutHTML = 
				"<p style=\"color:white; margin: 0; text-align: center; padding: 0;\">" + 
				"Successfully logged out.";
		return logoutHTML;
	}
	public static String profileMovieBooking(Movie movie)
	{

		String myvar ="<div class=\"row container\">" + 
		"				<div class=\"col-sm-9 col-md-9 removeLeftPadding\">"+
		"               	<img src=\"images/MoviePhoto/" + movie.getMoviePicture() + "\" alt=\"Joker\">"+
		"               </div>"+
		"               <div class=\"col-sm-3 col-md-3 removeRightPadding\">"+
		"               	<div class=\"verticleAlignBody\">"+
		"                   	<div class=\"verticle\">"+
		"                       	<div class=\"page-break\">"+
		"                           	<p>" + movie.getMovieTitle() + "</p>"+
		"                               <p>" + "Booking show time" +"</p>"+
		"                               <p>" + "Booking show date" + "</p>"+
		"                           </div>"+
		"                       </div>"+
		"                  </div>"+
		"            	</div>" + 
		"             </div>";	
		return myvar;
	}
	public static String passwordSuccessfullyUpdated()
	{

		String html = "<p style=\"color:white; margin: 0; padding: 0;\">" + 
	            "Password was successfully updated. Please login with new password.</p>";
		return html;
	}
	public static String updatedProfile()
	{
		String html = "<p style=\"color:white; margin: 0; padding: 0;\">" + 
	            "Profile was successfuly updated!</p>";
		return html;
	}
	public static String selectOptionValue(String value)
	{
		return "";
	}
	public static String promoCheckBox(boolean checked)
	{
		if(checked)
		{
			return 	"<div class=\"inputField\">\r\n" + 
					"	<label style=\"margin-left: 10px;\"for=\"promoCheckbox\">Receive Promotion Email</label>\r\n" + 
					"   <input type=\"checkbox\" name=\"promoCheckBox\" checked>\r\n" + 
					"</div>";
		}else {
			return 	"<div class=\"inputField\">\r\n" + 
					"	<label style=\"margin-left: 10px;\" for=\"promoCheckbox\">Receive Promotion Email</label>\r\n" + 
					"   <input type=\"checkbox\" name=\"promoCheckBox\">\r\n" + 
					"</div>";
		}
	}
	public static String indexComingSoon(Movie movie)
	{
		String myvar = "<div class=\"post\">"+
				"                <div class=\"postPic " + movie.getMovieTitle() + "\" >" +
				"                <div class=\"perspective\" onmouseover=\"mouseOver('"+ movie.getMoviePicture() + "', '" + movie.getMovieTitle() + "')\""+
				"                    onmouseout=\"mouseOut('" + movie.getMovieTitle() + "')\">"+
				"                    <div class=\"card\">"+
				"                        <div class=\"front\">"+
				"                            <a href=\"loadObjectsToHtmlController?type=" + movie.getMovieTitle() + "\"><img src=\"images/MoviePhoto/"+ movie.getMoviePicture()+ "\" alt=\""+ movie.getMovieTitle()+ "\"></a>"+
				"                        </div>"+
				"                        <div class=\"back\">"+
				"                            <h2>" + movie.getMovieTitle() +"</h2>"+
				"                            <p>"+ movie.getMovieRating() +"</p>"+
				"                            <p>"+ movie.getMovieCategory()+"</p>"+
				"                            <p>Coming: " + movie.getMovieReleaseDate() + "</p>" +
				"                        </div>"+
				"                    </div>"+
				"                </div>"+
			    "              </div>" +
			    "              <div style=\"width: 100%\">" +
				"              			<a class=\"movieInfoBtn\" href=\"loadObjectsToHtmlController?type=" + movie.getMovieTitle() + "\"><p>Learn More</p></a>"+
				"              </div>" + 
				"            </div>";
				return myvar;
	}
	public static String indexInTheatres(Movie movie)
	{

		String myvar = "<div class=\"post\">"+
		"                <div class=\"postPic " + movie.getMovieTitle() + "\" >" +
		"                <div class=\"perspective\" onmouseover=\"mouseOver('"+ movie.getMoviePicture() + "', '" + movie.getMovieTitle() + "')\""+
		"                    onmouseout=\"mouseOut('" + movie.getMovieTitle() + "')\">"+
		"                    <div class=\"card\">"+
		"                        <div class=\"front\">"+
		"                            <img src=\"images/MoviePhoto/"+ movie.getMoviePicture()+ "\" alt=\""+ movie.getMovieTitle()+ "\">"+
		"                        </div>"+
		"                        <div class=\"back\">"+
		"                            <h2>" + movie.getMovieTitle() +"</h2>"+
		"                           <p>"+ movie.getMovieRating() +"</p>"+
		"                           <p>"+ movie.getMovieReleaseDate() +"</p>"+
		"                           <p>"+ movie.getMovieCategory()+"</p>"+
		"                           <form style=\"float-left\" method=\"GET\" action=\"bookingController\">" +
			    "      						<button class=\"bookingBtn\" type=\"submit\" name=\"book\" value=\"" + movie.getMovieTitle() + "\">Book Now!</button>" +
		"      						</form>" +
		"                        </div>"+
		"                    </div>"+
		"                </div>"+
	    "              </div>" + 
		"              <div style=\"width: 100%\">" +
		"              			<a class=\"movieInfoBtn\" href=\"loadObjectsToHtmlController?type=" + movie.getMovieTitle() + "\"><p>Learn More</p></a>"+
		"              </div>" + 
		"            </div>";
		return myvar;
	}
	public static String nav_LO()
	{
		return "<nav class=\"navbar navbar-expand-md navbar-dark\">            <div class=\"container-fluid\">                <a href=\"index.jsp\">                    <h1 id=\"header\" class=\"navbar-brand hLink st\">9C Dawgs</h1>                </a>                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">                    <span class=\"navbar-toggler-icon\"></span>                </button>                <!-- For portability, if user is using a smaller screen, collapse links-->                <div class=\"navbar-collapse collapse\" id=\"collapsibleNavbar\">                    <ul class=\"navbar-nav\">                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Movies                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                    <li><a href=\"loadObjectsToHtmlController?type=inTheatres\">In Theatres</a></li><a href=\"loadObjectsToHtmlController?type=inTheatres\">                                    </a><li><a href=\"loadObjectsToHtmlController?type=inTheatres\"></a><a href=\"loadObjectsToHtmlController?type=comingSoon\">Coming Soon</a></li><a href=\"loadObjectsToHtmlController?type=comingSoon\">                                    </a><li><a href=\"loadObjectsToHtmlController?type=comingSoon\"></a><a href=\"loadObjectsToHtmlController?type=searchMovies\">Search Movies</a></li>                                </ul>                            </div>                        </li>                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Account                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                    <li><a name=\"session\" href=\"sessionController?type=profile\">My Profile</a></li>                                    <li><a name=\"session\" href=\"sessionController?type=edit\">Edit Profile</a></li>                                </ul>                            </div>                        </li>                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Login                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                    <!-- About Us/Contact-->                                    <li><a name=\"session\" href=\"sessionController?type=login\">Login</a></li>                                    <li><a name=\"session\" href=\"sessionController?type=register\">Register</a></li>									                                 </ul>                            </div>                        </li>                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Promotions                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                    <!-- About Us/Contact-->                                    <li><a href=\"sessionController?type=promotion\">Promotions</a></li>                                </ul>                            </div>                        </li>                    </ul>                    <div class=\"navbar-nav search-container\">                        <form action=\"searchMovieController\" method=\"get\">                            <input type=\"text\" name=\"input\" placeholder=\"Search for a movie\">                            <button type=\"submit\" class=\"searchIcon\">                                <i class=\"fas fa-search\"></i>                            </button>                        </form>                    </div>                </div>            </div>        </nav>";
	}
	public static String nav_LI()
	{

		if(sessionData.getCurrentSessionUser().getSessionType().equals("admin"))
		{
			return "<nav class=\"navbar navbar-expand-md navbar-dark\">            <div class=\"container-fluid\">                <a href=\"index.jsp\">                    <h1 id=\"header\" class=\"navbar-brand hLink st\">9C Dawgs</h1>                </a>                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">                    <span class=\"navbar-toggler-icon\"></span>                </button>                <!-- For portability, if user is using a smaller screen, collapse links-->                <div class=\"navbar-collapse collapse\" id=\"collapsibleNavbar\">                    <ul class=\"navbar-nav\">                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Movies                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                    <li><a href=\"loadObjectsToHtmlController?type=inTheatres\">In Theatres</a></li><a href=\"loadObjectsToHtmlController?type=inTheatres\">                                    </a><li><a href=\"loadObjectsToHtmlController?type=inTheatres\"></a><a href=\"loadObjectsToHtmlController?type=comingSoon\">Coming Soon</a></li><a href=\"loadObjectsToHtmlController?type=comingSoon\">                                    </a><li><a href=\"loadObjectsToHtmlController?type=comingSoon\"></a><a href=\"loadObjectsToHtmlController?type=searchMovies\">Search Movies</a></li>                                </ul>                            </div>                        </li>                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Account                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                <li><a href=\"loadObjectsToHtmlController?type=admin\">Admin Page</a></li>    <li><a name=\"session\" href=\"sessionController?type=profile\">My Profile</a></li>                                    <li><a name=\"session\" href=\"sessionController?type=edit\">Edit Profile</a></li>                                </ul>                            </div>                        </li>                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Logout                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                    <!-- About Us/Contact-->                                     <li><a name=\"session\" href=\"sessionController?type=logout\">Logout</a></li>                                </ul>                            </div>                        </li>                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Promotions                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                    <!-- About Us/Contact-->                                    <li><a href=\"sessionController?type=promotion\">Promotions</a></li>                                </ul>                            </div>                        </li>                    </ul>                    <div class=\"navbar-nav search-container\">                        <form action=\"searchMovieController\" method=\"get\">                            <input type=\"text\" name=\"input\" placeholder=\"Search for a movie\">                            <button type=\"submit\" class=\"searchIcon\">                                <i class=\"fas fa-search\"></i>                            </button>                        </form>                    </div>                </div>            </div>        </nav>";
		}else
		{
			return "<nav class=\"navbar navbar-expand-md navbar-dark\">            <div class=\"container-fluid\">                <a href=\"index.jsp\">                    <h1 id=\"header\" class=\"navbar-brand hLink st\">9C Dawgs</h1>                </a>                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">                    <span class=\"navbar-toggler-icon\"></span>                </button>                <!-- For portability, if user is using a smaller screen, collapse links-->                <div class=\"navbar-collapse collapse\" id=\"collapsibleNavbar\">                    <ul class=\"navbar-nav\">                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Movies                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                    <li><a href=\"loadObjectsToHtmlController?type=inTheatres\">In Theatres</a></li><a href=\"loadObjectsToHtmlController?type=inTheatres\">                                    </a><li><a href=\"loadObjectsToHtmlController?type=inTheatres\"></a><a href=\"loadObjectsToHtmlController?type=comingSoon\">Coming Soon</a></li><a href=\"loadObjectsToHtmlController?type=comingSoon\">                                    </a><li><a href=\"loadObjectsToHtmlController?type=comingSoon\"></a><a href=\"loadObjectsToHtmlController?type=searchMovies\">Search Movies</a></li>                                </ul>                            </div>                        </li>                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Account                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                    <li><a name=\"session\" href=\"sessionController?type=profile\">My Profile</a></li>                                    <li><a name=\"session\" href=\"sessionController?type=edit\">Edit Profile</a></li>                                </ul>                            </div>                        </li>                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Logout                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                    <!-- About Us/Contact-->                                     <li><a name=\"session\" href=\"sessionController?type=logout\">Logout</a></li>                                </ul>                            </div>                        </li>                        <li class=\"nav-item\">                            <div class=\"dropdown\">                                <button class=\"btn dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\">Promotions                                    <span class=\"caret\"></span></button>                                <ul class=\"dropdown-menu\">                                    <!-- About Us/Contact-->                                    <li><a href=\"currentPromotions.jsp\">Promotions</a></li>                                </ul>                            </div>                        </li>                    </ul>                    <div class=\"navbar-nav search-container\">                        <form action=\"searchMovieController\" method=\"get\">                            <input type=\"text\" name=\"input\" placeholder=\"Search for a movie\">                            <button type=\"submit\" class=\"searchIcon\">                                <i class=\"fas fa-search\"></i>                            </button>                        </form>                    </div>                </div>            </div>        </nav>";
		}
	}
	public static String navigateDiv(String btn, String div)
	{
		return "<script>openAdminTab('" + btn + "','" + div + "');</script>";
	}
	public static String adminShowTimeResults(String userSearch)
	{
		List<Movie> movies = null;
		try {
			movies = Database.getMoviesbyTitle(userSearch);
			String html = "";
			if(movies != null && movies.size() != 0)
			{
				for(int i = 0; i<movies.size(); i++)
				{
					html += showTimeResults(movies.get(i));	
				}
			}
			return html;
		}catch(SQLException e)
		{
			System.err.print(e);
			return "";
		}
	}
	
	public static String showTimeResults(Movie movie)
	{

		return "<div class=\"searchResultsBody\">"+
		"															<div class=\"row\">"+
		"																<div class=\"col-sm-3 col-md-3 removeRightPadding\">"+
		"																	<div class=\"moviePic\">"+
		"																		<img src=\"images/MoviePhoto/" + movie.getMoviePicture() + "\" alt=\"Joker\">"+
		"																	</div>"+
		"																</div>"+
		"																<form method=\"GET\" action=\"showTimesController\" class=\"col-sm-5 col-md-5\">"+
		"																	<h3>Add A Show Time</h3>"+
		"																	<div class=\"addST\">"+
		"																		<label for=\"cid\">Theatre Number</label>"+
		"																		<select id=\"cid\" name=\"cinemaID\">"+
		"																			<option value=\"1\">Cinema 1</option>"+
		"																			<option value=\"2\">Cinema 2</option>"+
		"																			<option value=\"3\">Cinema 3</option>"+
		"																		</select>"+
		"																	</div>"+
		"																	<div class=\"addST\">"+
		"																		<label for=\"time\">Time</label>"+
		"																		<input type=\"time\" id=\"time\" name=\"time\" required>"+
		"																	</div>"+
		"																	<div class=\"addST\">"+
		"																		<label for=\"date\">Date</label>"+
		"																		<input type=\"date\" id=\"date\" name=\"date\" required>"+
		"																	</div>"+
		"																	<div class=\"addST\">"+
		"																		<button type=\"submit\" name=\"showtimeSubmit\" value=\"" + movie.getMovieTitle() + "\">Submit</button>"+
		"																	</div>"+
		"																</form>"+
															"<div class=\"col-md-4\">" +
																"<div class=\"currentShowTimesBody\">" +
																		generateAdminShowTimeEditBody(movie) +
																		"															</div>"+
																		"															</div>"+
		"															</div>"+
		"														</div>";
	}
	
	public static String generateAdminShowTimeEditBody(Movie movie)
	{
		List<ShowTimes> sts = Database.getMovieShowTimes(movie);
		String html = "";
		for(int i = 0; i<sts.size(); i++)
		{
			ShowTimes st = sts.get(i);
			String st1 = "<option value=\"1\">Cinema 1</option>";
			String st2 = "<option value=\"2\">Cinema 2</option>";
			String st3 = "<option value=\"3\">Cinema 3</option>";
			if(st.getCinemaID() == 1)
			{
				st1 = "<option selected=\"selected\" value=\"1\">Cinema 1</option>";
			}else if(st.getCinemaID() == 2)
			{
				st2 = "<option selected=\"selected\" value=\"2\">Cinema 2</option>";
			}else if(st.getCinemaID() == 3)
			{
				st3 = "<option selected=\"selected\" value=\"3\">Cinema 3</option>";
			}
			html += "<form action=\"showTimesController\" method=\"GET\" class=\"showingEdit\">"+
					"																		<div class=\"showTimeInfo\">"+
					"																			<label>Cinema Room ID</label>"+
					"																			<select name=\"cinemaID\">"+
																									st1 +
																									st2 +
																									st3 +
					"																			</select>"+
					"																		</div>"+
					"																		<div class=\"showTimeInfo\">"+
					"																			<label>Date</label>"+
					"																			<input type=\"date\" name=\"date\" value=\"" + st.getDate() + "\" required></input>"+
					"                                                                           <input style=\"display: none;\" type=\"text\" name=\"id\" value=\"" + st.getID() + "\"></input>" +
					"																		</div>"+
					"																		<div class=\"showTimeInfo\">"+
					"																			<label>Time</label>"+
					"																			<input name=\"time\" type=\"time\" required value=\"" + st.getShowTimes() + "\">"+
					"                                                                           <input style=\"display: none;\" type=\"text\" name=\"ot\" value=\"" + st.getShowTimes() + "\">" +
					"																		</div>"+
					"																		<div class=\"showTimeInfo\">"+
					"																			<button type=\"submit\" value=\"" + movie.getMovieTitle() + "\"name=\"edit\">Update</button>"+
					"																		</div>	"+
					"                                                                       <div class=\"showTimeInfo\">"+
							"																	<button type=\"submit\" value=\"" + movie.getMovieTitle() + "\"name=\"delete\">Delete</button>"+
							"																</div>	"+
					"																	</form>";
		}
		return html;
	}
	
	public static String adminShowTimeBody()
	{	
		try {
			List<Movie> movies = Database.getAllMovies();
			String html = "";
			for(Movie movie : movies)
			{
				html += generateAdminShowTimeBody(movie);
			}
			return html;
		}catch(SQLException e)
		{
			System.err.println(e);
			return "";
		}
	}
	public static String generateMovieInfoShowTimeBody(Movie movie)
	{
		List<ShowTimes> list = Database.getMovieShowTimes(movie);
		list.sort((o1, o2) -> o1.getShowTimes().compareTo(o2.getShowTimes()));
		if(list == null || list.size() == 0)
		{
			return "<h3>No Bookings Available At This Time</h3>";
		}
		
		String html = "";
		String class_Label = "<div class=\"schedule\">";
		String ending_Div = "</div>";
		String theatre1 = "	<div>" +
								"<p>Theatre 1:</p>";
		String theatre2 = "	<div>" + 
								"<p>Theatre 2:</p>";
		String theatre3 = " <div>" +
								"<p>Theatre 3:</p>";
		boolean theatre1IsShowing = false;
		boolean theatre2IsShowing = false;
		boolean theatre3IsShowing = false;
		
		for(int i = 0; i<list.size(); i++)
		{
			ShowTimes currentMovie = list.get(i);
			if(!dateController.dateIsToday(currentMovie.getDate()))
			{
				continue;
			}
			Movie m = Database.getMovie(currentMovie.getMovieTitle());
			//Make sure movie is in Theaters
			if(!dateController.movieIsInTheatres(m))
			{
				continue;
			}
			
			String times = currentMovie.getShowTimes();
			String p = "<p>" + dateController.convertToTwelve(times) + "</p>";
			if(currentMovie.getCinemaID() == 1)
			{	
				theatre1IsShowing = true;
				theatre1 += p;
			}
			else if(currentMovie.getCinemaID() == 2)
			{
				theatre2IsShowing = true;
				theatre2 += p;
			}else if(currentMovie.getCinemaID() == 3)
			{
				theatre3IsShowing = true;
				theatre3 += p;
			}
		}
		
		if(!theatre1IsShowing)
		{
			theatre1 += "<p> NOT SHOWING </p>";
		}
		if(!theatre2IsShowing)
		{
			theatre2 += "<p> NOT SHOWING </p>";
		}
		if(!theatre3IsShowing)
		{
			theatre3 += "<p> NOT SHOWING </p>";
		}
		
		html += class_Label + theatre1 + ending_Div + theatre2 + ending_Div +  theatre3 + ending_Div + ending_Div;	
		return html;
	}
	public static String generateAdminShowTimeBody(Movie movie)
	{
		List<ShowTimes> list = Database.getMovieShowTimes(movie);
		list.sort((o1, o2) -> o1.getShowTimes().compareTo(o2.getShowTimes()));
		if(list == null || list.size() == 0)
		{
			System.out.println("ADMIN: NO SHOWTIMES FOUND: " + list.size());
			return "";
		}
		
		String html = "";
		String class_Label = "<div class=\"schedule\">"+
				"				<label>" + list.get(0).getMovieTitle() + "</label>";
		String ending_Div = "</div>";
		String theatre1 = "	<div>" +
								"<p>Theatre 1:</p>";
		String theatre2 = "	<div>" + 
								"<p>Theatre 2:</p>";
		String theatre3 = " <div>" +
								"<p>Theatre 3:</p>";
		boolean theatre1IsShowing = false;
		boolean theatre2IsShowing = false;
		boolean theatre3IsShowing = false;
		
		for(int i = 0; i<list.size(); i++)
		{
			ShowTimes currentMovie = list.get(i);
			if(!dateController.dateIsToday(currentMovie.getDate()))
			{
				System.out.println("ADMIN DATE ISSUE: " + currentMovie.getDate());
				continue;
			}
			Movie m = Database.getMovie(currentMovie.getMovieTitle());
			//Make sure movie is in Theaters
			if(!dateController.movieIsInTheatres(m))
			{
				System.out.println("IN THEATRES ISSUE: " + currentMovie.getDate());
				continue;
			}
			
			String times = currentMovie.getShowTimes();
			String p = "<p>" + dateController.convertToTwelve(times) + "</p>";
			System.out.println("Current Movie: " + currentMovie.getMovieTitle() + " " + currentMovie.getCinemaID());
			if(currentMovie.getCinemaID() == 1)
			{	
				theatre1IsShowing = true;
				theatre1 += p;
			}
			else if(currentMovie.getCinemaID() == 2)
			{
				theatre2IsShowing = true;
				theatre2 += p;
			}else if(currentMovie.getCinemaID() == 3)
			{
				theatre3IsShowing = true;
				theatre3 += p;
			}
		}
		if(!theatre1IsShowing)
		{
			theatre1 += "<p> NOT SHOWING </p>";
		}
		if(!theatre2IsShowing)
		{
			theatre2 += "<p> NOT SHOWING </p>";
		}
		if(!theatre3IsShowing)
		{
			theatre3 += "<p> NOT SHOWING </p>";
		}
		
		html += class_Label + theatre1 + ending_Div + theatre2 + ending_Div +  theatre3 + ending_Div + ending_Div;	
		return html;
	}
	public static String loadDates(Movie movie)
	{
		List<ShowTimes> list = Database.getMovieShowTimes(movie);
		List<ShowTimes> uniqueList = new ArrayList<>();
		Set<String> dates = new HashSet<String>();
		for(int i = 0; i<list.size(); i++)
		{
			String currentDate = list.get(i).getDate();
			if(!dates.contains(currentDate))
			{
				uniqueList.add(list.get(i));
			}
			dates.add(currentDate);
		}
		if(uniqueList.size() == 0)
		{
			return "<h2> NO SHOW TIMES AVAILABLE </h2>";
		}
		String topHalf = "<section class=\"container s-bd\">"+
				"       	<div class=\"row justify-content-center\">"+
				"        		<div class=\"col-sm-3 col-md-3\">"+
				"        			<h2>Theater Dates</h2>"+
				"        		</div> "+
				"        		<div class=\"col-sm-9 col-md-9 removeLeftPadding removeRightPadding\">"+
				"        			<ul>";
		String bottomHalf = "       </ul>"+
				"        		</div>"+
				"        	</div>"+
				"        </section>";
		List<ShowTimes> l = new ArrayList<>(uniqueList);
		l.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));
		for(int i = 0; i<l.size(); i++)
		{
			topHalf += "<li><a href=\"bookingController?date=" + l.get(i).getID() + "\">" + dateController.convertToLocalDate(l.get(i).getDate()) + "</a></li>";
		}
		return topHalf + bottomHalf;
	}
	public static String Theatre(Movie movie, int theatreID, String Date)
	{
		List<ShowTimes> list = Database.getMovieShowTimes(movie);
		list.sort((o1, o2) -> o1.getShowTimes().compareTo(o2.getShowTimes()));
		String topHalf = "<section class=\"container s-bd\">"+
				"       	<div class=\"row justify-content-center\">"+
				"        		<div class=\"col-sm-3 col-md-3\">"+
				"        			<h2>Theater " + theatreID + "</h2>"+
				"        		</div> "+
				"        		<div class=\"col-sm-9 col-md-9 removeLeftPadding removeRightPadding\">"+
				"        			<ul>";
		String bottomHalf = "       </ul>"+
				"        		</div>"+
				"        	</div>"+
				"        </section>";
		for(int i = 0; i<list.size(); i++)
		{
			if(list.get(i).getCinemaID() == theatreID && list.get(i).getDate().equals(Date))
			{
				topHalf += "<li><a href=\"bookingController?type=" + list.get(i).getID() + "\">" + dateController.convertToTwelve(list.get(i).getShowTimes()) + "</a></li>";
			}
		}
		return topHalf + bottomHalf;
	}
	public static String seatStructure(Seatings seats)
	{
		String row = "		<div class=\"row justify-content-center\">";
		String endingDiv = "</div>";
		String html = row;
		List<Boolean> arr = seats.getSeatArray();
		for(int i = 0, counter = 1; i<arr.size(); i++, counter++)
		{
			html += addRow(arr.get(i), i+1); //4 9
			if(counter != 0 && counter != 25 && counter%5 == 0)
			{
				html += endingDiv;
				html += row;
			}
		}
		html += endingDiv;
		return html;
	}
	public static String addRow(boolean seatAvailable, int num)
	{
		String blue = "color: #00aeef;";
		String gray = "color: #484848;";
		String color = seatAvailable ? blue : gray;
		String disable = seatAvailable ? " " : " disabled ";
		
		String seat =		"	<div class=\"col-md-2 col-md-offset-1\">"+
				"        			<button" + disable + " onclick=\"selectSeat(" + num + ", " + (double)(num + .1) + ")\"type=\"button\">"+
				"        				<i style=\"" + color + "\" id=\"" + num + "\" class=\"fas fa-couch\"></i>"+
				"        				<p>Seat " +  num + "</p>"+
				"                       <input type=\"text\" id=\"" + (double)(num+.1) + "\" style=\"display: none;\" name=\"seat\" value=\"-1\">" +
				"        			</button>"+
				"        		</div>";
		return seat;
	}
	public static String promotionsBody()
	{
		List<Promotions> list = Database.getAllPromotions();
		if(list == null || list.size() == 0)
		{
			return noPromotions();
		}else {
			String html ="";
			for(int i = 0; i<list.size(); i++){
				html += generatePromoBody(list.get(i));
			}
			return html;
		}
	}
	public static String generatePromoBody(Promotions p)
	{

		String myvar = "<div class=\"promo-i\">"+
		"               	<h2>Promotion ID: " + p.getID() + "</h2>"+
		"                   <p>Promotion Expiration Date: " + p.getExpirationDate() + "</p>"+
		"                   <p>Promotion Discount: " + p.getDiscountAmountString() + " <p>"+
		"               </div>";
		return myvar;
	

	}
	public static String noPromotions()
	{
		return "<h2> No Promotions at the moment. </h2>";
	}
	public static String adminPromoBody()
	{
		List<Promotions> list = Database.getAllPromotions();
		if(list == null || list.size() == 0)
		{
			return "";
		}else
		{
			String html = "";
			for(int i = 0; i<list.size(); i++)
			{
				html += adminPromoBodyGenerator(list.get(i));
			}
			return html;
		}
	}
	public static String adminPromoBodyGenerator(Promotions p)
	{

		String myvar = "<form method=\"GET\" action=\"promotionController\" class=\"promoBody\">"+
		"					<h2>Promotion ID: " + p.getID() + "</h2>"+
		"						<div class=\"promoField\">"+
		"							<label for=\"addDate\">Expiration Date</label>"+
		"							<input id=\"addDate\" required type=\"date\" name=\"date\" value=\"" + p.getExpirationDate() + "\">"+
		"						</div>"+
		"						<div class=\"promoField\">"+
		"							<label for=\"addDiscount\">Discount Amount</label>"+
		"							<input id=\"addDiscount\" step=\"0.01\" min=\"0.00\" placeholder=\"0.00\" required type=\"number\" name=\"discount\" value=\"" + p.getDiscountAmountString() + "\">"+
		"						</div>		"+
		"						<div class=\"buttons\">"+
		"							<button type=\"submit\" value=\"" + p.getID() + "\" name=\"update\">UPDATE</button>"+
		"							<button type=\"submit\" value=\"" + p.getID() + "\" name=\"delete\">DELETE</button>"+
		"						</div>"+
		"				</form>";
		return myvar;
	}
	public static String orderHistory(WebUser user)
	{
		List<Order> list = Database.getOrderByEmail(user.getEmail());
		if(list == null || list.size() == 0)
		{
			return "<div style=\"width: 85%;\" class=\"inputField orderHistoryProfile\">"+
			"										<h2>No Orders!</h2>"+
			"									</div>";
		}else
		{
			String html = "";
			for(int i = 0; i<list.size(); i++)
			{
				html += orderHistoryGenerator(list.get(i));
			}
			return html;
		} 
	}
	public static String orderHistoryGenerator(Order order)
	{
		
		ShowTimes st = Database.getShowTimeByID(Integer.toString(order.getShowTimeID()));
		String seatStr = "Seat ";
		List<Integer> seats = order.getSeatArray();
		for(int i = 0; i<seats.size(); i++)
		{
			seatStr += Integer.toString(seats.get(i)) + ", ";
		}
		String total = "$" + String.format("%.2f", order.getTotal());
		seatStr = seatStr.substring(0, seatStr.length()-2);
		return 								"<div class=\"inputField orderHistoryProfile\">"+
		"										<h2>Order ID: " + order.getOrderID() + "</h2>"+
		"										<div class=\"promotions\">"+
		"											<label for=\"movieTitle\">Movie Title</label>"+
		"											<p id=\"movieTitle\">" + st.getMovieTitle() + "</p>"+
		"										</div>"+
		"										<div class=\"promotions\">"+
		"											<label for=\"Theatre\">Theatre</label>"+
		"											<p id=\"Theatre\">Cinema " + st.getCinemaID() + "</p>"+
		"										</div>"+
		"										<div class=\"promotions\">"+
		"											<label for=\"ShowTime\">ShowTime</label>"+
		"											<p id=\"ShowTime\">" + dateController.convertToTwelve(st.getShowTimes()) + " at " + st.getDate() + "</p>"+
		"										</div>"+
		"										<div class=\"promotions\">"+
		"											<label for=\"Seats\">Seats</label>"+
		"											<p id=\"Seats\">" + seatStr + "</p>"+
		"										</div>"+
		"										<div class=\"promotions\">"+
		"											<label for=\"Total\">Total</label>"+
		"											<p id=\"Total\">" + total + "</p>"+
		"										</div>"+
		"									</div>";
	
	}
	public static String adminUserSearchBody(WebUser user)
	{
		String suspendButtonType = "";
		if(user.getSessionType().equals("suspended"))
		{
			suspendButtonType = "<button type=\"submit\" value=\"UnSuspend\" name=\"UnSuspend\">UnSuspend</button>";
		}
		else
		{
			suspendButtonType = "<button type=\"submit\" value=\"Suspend\" name=\"Suspend\">Suspend</button>";
		}
		return  "<form method=\"GET\" action=\"userController\" class=\"userForm\">"+
						"																		<div class=\"promotions\">"+
						"																			<label>Name</label>"+
						"																			<input type=\"text\" name=\"Name\" value=\"" + user.getFullName() + "\" readonly>"+
						"																		</div>"+
						"																		<div class=\"promotions\">"+
						"																			<label>Email</label>"+
						"																			<input type=\"text\" name=\"Email\" value=\"" + user.getEmail() + "\" readonly>"+
						"																		</div>"+
						"																		<div class=\"promotions\">"+
						"																			<div class=\"container removeLeftPadding removeRightPadding\">"+
						"																				<div class = \"row\">"+
						"																					<div class=\"col-sm-6\">"+
																												suspendButtonType +
						"                                                                                   </div>"+
						"																					<div class=\"col-sm-6\">"+
						"																						<button type=\"submit\" value=\"Delete\" name=\"Delete\">Delete</button>"+
						"																					</div>"+
						"																				</div>"+
						"																			</div>"+
						"																		</div>"+
						"																	</form>";
							

	}
	public static String employeeBody()
	{
		List<Administrator> list = Database.getAllAdmins();
		if(list == null)
		{
			return "";
		}
		String html = "";
		for(int i = 0; i<list.size(); i++)
		{
			html += generateEmployeeBody(list.get(i));
		}
		return html;
	}
	public static String generateEmployeeBody(Administrator admin)
	{
		return  "<div style=\"float: left; margin: 15px; width: auto; padding: 8px 16px; box-shadow: 0px 0px 3px white;\" class=\"promotions\">"+
						"													<p>Name: " + admin.getFullName() + "</p>"+
						"													<p>Email: " + admin.getEmail() + "</p>"+
						"													<p>Phone Number: " + admin.getPhoneNumber() + "</p>"+
						"												</div>";
							

	}
}
