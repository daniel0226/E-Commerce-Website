$(document).ready(function() {
	//console.log("running");
    generateHeader();
    generateFooter();
    getTodaysDate();
    $("#confirmPassword").keyup(validatePassword);
    $("input[type=submit][name='infS']").attr("disabled", "disabled");
});


$(window).scroll(() => {
    controlSideBarPos();
});

function openAddMovie(ele)
{
    var body = document.getElementById(ele);
    body.style.display = "block";
}

function closeAddForm(ele)
{
    var body = document.getElementById(ele);
    body.style.display = "none";
}

function controlSideBarPos()
{
    var footerTopOffset = $('#footer').position().top;
    var navHeight = $("#fixedAdminNav").outerHeight();
    var scrollDistanceFromTopOfDoc = $(document).scrollTop() + navHeight;
    var scrollDistanceFromTopOfFooter = scrollDistanceFromTopOfDoc - footerTopOffset;
    if(scrollDistanceFromTopOfDoc > footerTopOffset)
    {
        $('#fixedAdminNav').css('margin-top', 0-scrollDistanceFromTopOfFooter);
    }else
    {
        $('#fixedAdminNav').css('margin-top', 0);
    }
}

/*
* Function makes all payment fields required
* if a user adds any input to any payment field.
* UPDATE: This function is obsolete, add a controller in Java files to handle this.
*/
function makePaymentFieldRequired()
{
	var inputField = document.getElementsByClassName("js-payment");
	for(var i = 0; i<inputField.length; i++)
	{
		inputField[i].required = true;
	}
}

function generateFooter()
{
    var myvar = '<div class="footer-Body">'+
    '            <div class="container">'+
    '                <div class="row">'+
    '                    <div class="col-md-6">'+
    '                        <h1>Stay up to date with Promotions!'+
    '                        </h1>'+
    '                        <hr>'+
    '                        <div>'+
    '                            <p>Join over thousands of users who recieve bi-weekly promotional updates! </p>'+
    '                            <a href="register.jsp" class="emailSignUp">Sign Up!</a>'+
    '                        </div>'+
    '                    </div>'+
    '                    <div class="col-md-6">'+
    '                        <h2>NAVIGATE</h2>'+
    '                        <div class="fll Navigate">'+
    '                            <a href="#">In Theatres<i class="right"></i></a>'+
    '                            <a href="#">In Theatres<i class="right"></i></a>'+
    '                            <a href="#">In Theatres<i class="right"></i></a>'+
    '                        </div>'+
    '                        <div class="flr Navigate">'+
    '                            <a href="#">In Theatres<i class="right"></i></a>'+
    '                            <a href="#">In Theatres<i class="right"></i></a>'+
    '                            <a href="#">In Theatres<i class="right"></i></a>'+
    '                        </div>'+
    '                    </div>'+
    '                </div>'+
    '            </div>'+
    '        </div>'+
    '        <hr>'+
    '        <div class="row justify-content-center">'+
    '            <p>Copyright of Daniel Kim, Oscar Lopez, Kranthi, Padmanaban</p>'+
    '        </div>';
        
    $("footer").append(myvar);
}


function generateHeader()
{
    var myvar = '<nav class="navbar navbar-expand-md navbar-dark">'+
    '            <div class="container">'+
    '                <a href="index.html">'+
    '                    <h1 id="header" class="navbar-brand hLink st">Cinema E-Booking</h1>'+
    '                </a>'+
    '                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">'+
    '                    <span class="navbar-toggler-icon"></span>'+
    '                </button>'+
    '                <!-- For portability, if user is using a smaller screen, collapse links-->'+
    '                <div class="navbar-collapse collapse" id="collapsibleNavbar">'+
    '                    <ul class="navbar-nav">'+
    '                        <li class="nav-item">'+
    '                            <div class="dropdown">'+
    '                                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Movies'+
    '                                    <span class="caret"></span></button>'+
    '                                <ul class="dropdown-menu">'+
    '                                    <!-- Will Redirect to Search Movie Page and autofilter with "in Theatres"-->'+
    '                                    <li><input class="navlogout" onclick="searchNav(0)" value="In Theatres"'+
    '                                            spellcheck="false"></li>'+
    '                                    <li><input class="navlogout" onclick="searchNav(1)" value="Coming Soon"></li>'+
    '                                    <li><a href="SearchView.html">Search Movies</a></li>'+
    '                                </ul>'+
    '                            </div>'+
    '                        </li>'+
    '                        <li class="nav-item">'+
    '                            <div class="dropdown">'+
    '                                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Profile'+
    '                                    <span class="caret"></span></button>'+
    '                                <ul class="dropdown-menu">'+
    '                                    <!-- About Us/Contact-->'+
    '                                    <li><a href="checkSessionController">Edit Profile</a></li>'+
    '                                    <li>'+
    '                                        <form action="../php/logout.php" method="GET">'+
    '                                            <input class="navlogout" type="submit" value="logout">'+
    '                                        </form>'+
    '                                    </li>'+
    '                                </ul>'+
    '                            </div>'+
    '                        </li>'+
    '                        <li class="nav-item">'+
    '                            <div class="dropdown">'+
    '                                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Login'+
    '                                    <span class="caret"></span></button>'+
    '                                <ul class="dropdown-menu">'+
    '                                    <!-- About Us/Contact-->'+
    '                                    <li><a href="login.html">Login</a></li>'+
    '                                    <li><a href="register.jsp">Register</a></li>'+
    '                                </ul>'+
    '                            </div>'+
    '                        </li>'+
    '                        <li class="nav-item">'+
    '                            <div class="dropdown">'+
    '                                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Promotions'+
    '                                    <span class="caret"></span></button>'+
    '                                <ul class="dropdown-menu">'+
    '                                    <!-- About Us/Contact-->'+
    '                                    <li><a href="currentPromotions.html">Promotions</a></li>'+
    '                                </ul>'+
    '                            </div>'+
    '                        </li>'+
    '                    </ul>'+
    '                    <div class="navbar-nav search-container">'+
    '                        <form action="../php/searchMovies.php" method="get">'+
    '                            <input type="text" name="searchMovie" placeholder="Search for a movie">'+
    '                            <button type="submit" class="searchIcon">'+
    '                                <i class="fas fa-search"></i>'+
    '                            </button>'+
    '                        </form>'+
    '                    </div>'+
    '                </div>'+
    '            </div>'+
    '        </nav>';

    var myvarAdmin = "";

    $("#adminH").append(myvarAdmin);
    $("#navH").append(myvar);
}


/*
 * Validates that the password and confirmation password matches
 * live on webpage.
 */
function validatePassword()
{ 
    var password = $("#password").val();
    var confPassword = $("#confirmPassword").val();
    var btn = $("infS");
    
    if(password == confPassword) {
        $("#confStatus").text("");  
        $("input[type=submit][name='infS']").removeAttr("disabled");       
     }
     else {
        $("input[type=submit][name='infS']").attr("disabled", "disabled"); 
         $("#confStatus").text("Passwords do not match!");  
     }
}


function openTab(event, TabID)
{
    var i, tabBody, tabLinks;
    tabBody = document.getElementsByClassName("tabcontent");
    for(i = 0; i<tabBody.length; i++)
    {
        tabBody[i].style.display = "none";
    }
    tabLinks = document.getElementsByClassName("tablinks");
    for(i = 0; i<tabLinks.length; i++)
    {
        tabLinks[i].className = tabLinks[i].className.replace("tabActive", "");
    }
    document.getElementById(TabID).style.display = "block";
    event.currentTarget.className += " tabActive";
}

function openAdminTab(button, adminTab)
{
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("adminTabContent");
    for(i = 0; i<tabcontent.length; i++)
    {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("adminTabLink");
    for(i = 0; i<tablinks.length; i++)
    {
        if(tablinks[i].classList.contains("activeAdminTab"))
        {
            tablinks[i].classList.remove("activeAdminTab");
        }
    }
    document.getElementById(adminTab).style.display = "block";
    document.getElementById(button).classList.add("activeAdminTab");
}

function getTodaysDate()
{
    var date = new Date();
    var todayIndex = date.getDay();
    var d_names = ["Sunday","Monday", "Tuesday", "Wednesday", 
"Thursday", "Friday", "Saturday"];
    var today = d_names[todayIndex];

    var MonthIndex = date.getMonth();
    var m_names = ["January", "February", "March", 
"April", "May", "June", "July", "August", "September", 
"October", "November", "December"];
    var Month = m_names[MonthIndex];

    var day = date.getDate();
    var year = date.getFullYear();

    var dateToDisplay = today + ", " + Month + " " + day + ", " + year;
    document.getElementById("js-getTodaysDate").innerHTML = dateToDisplay;
}

function toggleAll(source)
{
    checkboxes = document.getElementsByName('movieCheckbox');
    for(var i=0, n=checkboxes.length;i<n;i++) {
      checkboxes[i].checked = source.checked;
    }
}

function adminSearchMovie()
{
    var input = document.getElementById("AdmSearchMovie");
    var filter = input.value.toUpperCase();
    var movies = document.getElementsByClassName("movieObjects");
    
    for(var i = 0; i<movies.length; i++)
    {
        var movieId = movies[i].id.toUpperCase();
        var indexValue = movieId.indexOf(filter);
        if(indexValue < 0)
        {
            movies[i].style.display = "none";
        }else{
            movies[i].style.display = "flex";
        }
    }
}

function showEditTab(tab_, btn)
{
    var tab = document.getElementById(tab_);
    tab.style.display = "block";
    
    var movieTabs = document.getElementsByClassName("movieInfoDisplay");
    for(var i = 0; i<movieTabs.length; i++)
    {
        if(movieTabs[i].id != tab.id)
        {
            movieTabs[i].style.display = "none";
        }
    }
    document.getElementById("movieManagementForm").reset();
}
function closeForm(tab_, btn)
{
    var tab = document.getElementById(tab_);
    tab.style.display = "none";
    var editButton = document.getElementById(btn);
    editButton.style.display = "block";
    document.getElementById("movieManagementForm").reset();
    var buttons = document.getElementsByClassName("editBtn");
    for(var i = 0; i<buttons.length; i++)
    {
        buttons[i].disabled = false;
    }
}