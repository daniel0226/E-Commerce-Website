package eCommerce.Strings;

import eCommerce.MovieData.Movie;
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
				"                            <h3>Director: " + movie.getMovieDirector() + "</h3>"+
				"                            <h4>Category: " + movie.getMovieCategory() + "</h4>"+
				"                            <span>" + movie.getMovieSynopsis() + "</span>"+
				"                        </div>"+
				"                    </div>";
				return addMovieHtml;
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
		"                                <li style=\"margin-top: 15px;\"><a class=\"bookA\" name=\"booking\" href=\"bookingController?type=" +  movie.getMovieTitle() + "\">Book Now!</a></li>"+
		"                            </ul>"+
		"                        </div>"+
		"                        <div class=\"col-md-9\">"+
		"                            <iframe width=\"100%\" height=\"100%\" src=\"" + movie.getMovieTrailer() + "\"" +
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
					"	<label for=\"promoCheckbox\">Receive Promotion Email</label>\r\n" + 
					"   <input type=\"checkbox\" name=\"promoCheckBox\" checked>\r\n" + 
					"</div>";
		}else {
			return 	"<div class=\"inputField\">\r\n" + 
					"	<label for=\"promoCheckbox\">Receive Promotion Email</label>\r\n" + 
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
				"                            <img src=\"images/MoviePhoto/"+ movie.getMoviePicture()+ "\" alt=\""+ movie.getMovieTitle()+ "\">"+
				"                        </div>"+
				"                        <div class=\"back\">"+
				"                            <h2>" + movie.getMovieTitle() +"</h2>"+
				"                            <p>"+ movie.getMovieRating() +"</p>"+
				"                            <p>"+ movie.getMovieCategory()+"</p>"+
				"                        </div>"+
				"                    </div>"+
				"                </div>"+
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
		"                            <p>"+ movie.getMovieRating() +"</p>"+
		"                            <p>"+ movie.getMovieReleaseDate() +"</p>"+
		"                            <p>"+ movie.getMovieCategory()+"</p>"+
		"                            <form method=\"GET\" action=\"bookingController\">" +
		"                            <button class=\"bookingBtn\" type=\"submit\" name=\"book\" value=\"" + movie.getMovieTitle() + "\">Book Now!</button>" +
		"                            </form>" +
		"                        </div>"+
		"                    </div>"+
		"                </div>"+
	    "              </div>" + 
		"            </div>";
		return myvar;
	

	}
}
