$(document).ready(function () {
    console.log("running");
    generateFooter();
    generateHeader();
    $("#confirmPassword").keyup(validatePassword);
    $("input[type=submit][name='infS']").attr("disabled", "disabled");
    setUpAnimation();
    
    document.getElementById("p-about").style.display = "block";
});


$(window).scroll(() => {
    if (window.location.href == "../adminPage.jsp") {
        controlSideBarPos();
    }
});

function setUpCarousel()
{
    $('.carouselInTheatre').slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 3000,
        nextArrow: $('.next'),
        prevArrow: $('.prev'),
      });
}
function setUpCarouselCenter()
{
	console.log("Creating carousel");
    $('.carouselInTheatre').slick({
        centerMode: true,
        centerPadding: '60px',
        slidesToShow: 3,
        nextArrow: $('.next'),
        prevArrow: $('.prev'),
        responsive: [
          {
            breakpoint: 768,
            settings: {
              arrows: false,
              centerMode: true,
              centerPadding: '40px',
              slidesToShow: 3
            }
          },
          {
            breakpoint: 480,
            settings: {
              arrows: false,
              centerMode: true,
              centerPadding: '40px',
              slidesToShow: 1
            }
          }
        ]
      });
}
function setUpAnimation()
{
    $(".animated").addClass("delay-1s");
}

function isAdminPage() {
    var adminConf = document.getElementById("adminPage");
    if (adminConf != null) {
        return true;
    } else {
        return false;
    }
}

function confirmPost() {
    if (confirm("Are you sure you want to delete checked movies?")) {
        return true;
    } else {
        return false;
    }
}

function animateNum(tag, start, end, duration) {
    var range = end - start;
    var minTimer = 10;
    var stepTime = Math.abs(Math.floor(duration / range));
    stepTime = Math.max(stepTime, minTimer);

    var startTime = new Date().getTime();
    var endTime = startTime + duration;
    var timer;

    function run() {
        var now = new Date().getTime();
        var remaining = Math.max((endTime - now) / duration, 0);
        var value = Math.round(end - (remaining * range));
        tag.innerHTML = value;

        if (value == end) {
            clearInterval(timer);
        }
    }

    timer = setInterval(run, stepTime);
    run();
}

function openAddMovie(ele) {
    var body = document.getElementById(ele);
    body.style.display = "block";
}

function closeAddForm(ele) {
    var body = document.getElementById(ele);
    body.style.display = "none";
}

function controlSideBarPos() {
    var footerTopOffset = $('#footer').position().top;
    var navHeight = $("#fixedAdminNav").outerHeight();
    var scrollDistanceFromTopOfDoc = $(document).scrollTop() + navHeight;
    var scrollDistanceFromTopOfFooter = scrollDistanceFromTopOfDoc - footerTopOffset;
    if (scrollDistanceFromTopOfDoc > footerTopOffset) {
        $('#fixedAdminNav').css('margin-top', 0 - scrollDistanceFromTopOfFooter);
    } else {
        $('#fixedAdminNav').css('margin-top', 0);
    }
}

/*
* Function makes all payment fields required
* if a user adds any input to any payment field.
* UPDATE: This function is obsolete, add a controller in Java files to handle this.
*/
function makePaymentFieldRequired() {
    var inputField = document.getElementsByClassName("js-payment");
    for (var i = 0; i < inputField.length; i++) {
        inputField[i].required = true;
    }
}

function generateFooter() {
    var myvar = '<div class="footer-Body">' +
        '            <div class="container">' +
        '                <div class="row">' +
        '                    <div class="col-md-6">' +
        '                        <h1>Stay up to date with Promotions!' +
        '                        </h1>' +
        '                        <hr>' +
        '                        <div>' +
        '                            <p>Join over thousands of users who recieve bi-weekly promotional updates! </p>' +
        '                            <a href="register.jsp" class="emailSignUp">Sign Up!</a>' +
        '                        </div>' +
        '                    </div>' +
        '                    <div class="col-md-6">' +
        '                        <h2>NAVIGATE</h2>' +
        '                        <div class="fll Navigate">' +
        '                            <a href="#">In Theatres<i class="right"></i></a>' +
        '                            <a href="#">In Theatres<i class="right"></i></a>' +
        '                            <a href="#">In Theatres<i class="right"></i></a>' +
        '                        </div>' +
        '                        <div class="flr Navigate">' +
        '                            <a href="#">In Theatres<i class="right"></i></a>' +
        '                            <a href="#">In Theatres<i class="right"></i></a>' +
        '                            <a href="#">In Theatres<i class="right"></i></a>' +
        '                        </div>' +
        '                    </div>' +
        '                </div>' +
        '            </div>' +
        '        </div>' +
        '        <hr>' +
        '        <div class="row justify-content-center">' +
        '            <p>Copyright of Daniel Kim, Oscar Lopez, Kranthi, Padmanaban</p>' +
        '        </div>';

    $("footer").append(myvar);
}


function generateHeader() {
    var myvar = '<nav class="navbar navbar-expand-md navbar-dark">' +
        '            <div class="container">' +
        '                <a href="index.jsp">' +
        '                    <h1 id="header" class="navbar-brand hLink st">Cinema E-Booking</h1>' +
        '                </a>' +
        '                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">' +
        '                    <span class="navbar-toggler-icon"></span>' +
        '                </button>' +
        '                <!-- For portability, if user is using a smaller screen, collapse links-->' +
        '                <div class="navbar-collapse collapse" id="collapsibleNavbar">' +
        '                    <ul class="navbar-nav">' +
        '                        <li class="nav-item">' +
        '                            <div class="dropdown">' +
        '                                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Movies' +
        '                                    <span class="caret"></span></button>' +
        '                                <ul class="dropdown-menu">' +
        '                                    <li><a href="loadObjectsToHtmlController?type=inTheatres">In Theatres</li>' +
        '                                    <li><a href="loadObjectsToHtmlController?type=comingSoon">Coming Soon</li>' +
        '                                    <li><a href="loadObjectsToHtmlController?type=searchMovies">Search Movies</a></li>' +
        '                                </ul>' +
        '                            </div>' +
        '                        </li>' +
        '                        <li class="nav-item">' +
        '                            <div class="dropdown">' +
        '                                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Account' +
        '                                    <span class="caret"></span></button>' +
        '                                <ul class="dropdown-menu">' +
        '                                    <li><a name="session" href="sessionController?type=profile">My Profile</a></li>' +
        '                                    <li><a name="session" href="sessionController?type=edit">Edit Profile</a></li>' +
        '                                </ul>' +
        '                            </div>' +
        '                        </li>' +
        '                        <li class="nav-item">' +
        '                            <div class="dropdown">' +
        '                                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Login' +
        '                                    <span class="caret"></span></button>' +
        '                                <ul class="dropdown-menu">' +
        '                                    <!-- About Us/Contact-->' +
        '                                    <li><a name="session" href="sessionController?type=login">Login</a></li>' +
        '                                    <li><a name="session" href="sessionController?type=register">Register</a></li>' +
        '									 <li><a name="session" href="sessionController?type=logout">Logout</a></li>' +
        '                                </ul>' +
        '                            </div>' +
        '                        </li>' +
        '                        <li class="nav-item">' +
        '                            <div class="dropdown">' +
        '                                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Promotions' +
        '                                    <span class="caret"></span></button>' +
        '                                <ul class="dropdown-menu">' +
        '                                    <!-- About Us/Contact-->' +
        '                                    <li><a href="currentPromotions.html">Promotions</a></li>' +
        '                                </ul>' +
        '                            </div>' +
        '                        </li>' +
        '                    </ul>' +
        '                    <div class="navbar-nav search-container">' +
        '                        <form action="../php/searchMovies.php" method="get">' +
        '                            <input type="text" name="searchMovie" placeholder="Search for a movie">' +
        '                            <button type="submit" class="searchIcon">' +
        '                                <i class="fas fa-search"></i>' +
        '                            </button>' +
        '                        </form>' +
        '                    </div>' +
        '                </div>' +
        '            </div>' +
        '        </nav>';
    $("#navH").append(myvar);
}


/*
 * Validates that the password and confirmation password matches
 * live on webpage.
 */
function validatePassword() {
    var password = $("#password").val();
    var confPassword = $("#confirmPassword").val();
    var btn = $("infS");

    if (password == confPassword) {
        $("#confStatus").text("");
        $("input[type=submit][name='infS']").removeAttr("disabled");
    }
    else {
        $("input[type=submit][name='infS']").attr("disabled", "disabled");
        $("#confStatus").text("Passwords do not match!");
    }
}


function openPTab(TabID) {
    var i, tabBody;
    tabBody = document.getElementsByClassName("profileTab");
    for (i = 0; i < tabBody.length; i++) {
        tabBody[i].style.display = "none";
    }
    document.getElementById(TabID).style.display = "block";
}

function openTab(event, TabID) {
    var i, tabBody, tabLinks;
    tabBody = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabBody.length; i++) {
        tabBody[i].style.display = "none";
    }
    tabLinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tabLinks.length; i++) {
        tabLinks[i].className = tabLinks[i].className.replace("tabActive", "");
    }
    document.getElementById(TabID).style.display = "block";
    event.currentTarget.className += " tabActive";
}

function openAdminTab(button, adminTab) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("adminTabContent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("adminTabLink");
    for (i = 0; i < tablinks.length; i++) {
        if (tablinks[i].classList.contains("activeAdminTab")) {
            tablinks[i].classList.remove("activeAdminTab");
        }
    }
    document.getElementById(adminTab).style.display = "block";
    document.getElementById(button).classList.add("activeAdminTab");
}



function toggleAll(source) {
    checkboxes = document.getElementsByName('movieCheckbox');
    for (var i = 0, n = checkboxes.length; i < n; i++) {
        checkboxes[i].checked = source.checked;
    }
}

function adminSearchMovie() {
    var input = document.getElementById("AdmSearchMovie");
    var filter = input.value.toUpperCase();
    var movies = document.getElementsByClassName("movieObjects");

    for (var i = 0; i < movies.length; i++) {
        var movieId = movies[i].id.toUpperCase();
        var indexValue = movieId.indexOf(filter);
        if (indexValue < 0) {
            movies[i].style.display = "none";
        } else {
            movies[i].style.display = "flex";
        }
    }
}

function searchMovies() {
    var input = document.getElementById("searchMovies");
    var filter = input.value.toUpperCase();
    var movies = document.getElementsByClassName("movies");

    for (var i = 0; i < movies.length; i++) {
        var movieId = movies[i].id.toUpperCase();
        var indexValue = movieId.indexOf(filter);
        if (indexValue < 0) {
            movies[i].style.display = "none";
        } else {
            movies[i].style.display = "flex";
        }
    }
}
function searchMovie()
{
	var input = document.getElementById("searchMovies");
    var filter = input.value.toUpperCase();
    var movies = document.getElementsByClassName("movies");

    for (var i = 0; i < movies.length; i++) {
        var movieId = movies[i].id.toUpperCase();
        var indexValue = movieId.indexOf(filter);
        if (indexValue < 0) {
            movies[i].style.display = "none";
        } else {
            movies[i].style.display = "flex";
        }
    }
}

function showEditTab(tab_, btn) {
    var tab = document.getElementById(tab_);
    tab.style.display = "block";

    var movieTabs = document.getElementsByClassName("movieInfoDisplay");
    for (var i = 0; i < movieTabs.length; i++) {
        if (movieTabs[i].id != tab.id) {
            movieTabs[i].style.display = "none";
        }
    }
    document.getElementById("movieManagementForm").reset();
}
function closeForm(tab_, btn) {
    var tab = document.getElementById(tab_);
    tab.style.display = "none";
    var editButton = document.getElementById(btn);
    editButton.style.display = "block";
    document.getElementById("movieManagementForm").reset();
    var buttons = document.getElementsByClassName("editBtn");
    for (var i = 0; i < buttons.length; i++) {
        buttons[i].disabled = false;
    }
}

function mouseOver(img)
{
    var imagePath = "url('images/MoviePhoto/" + img + "')";
    var doc = document.getElementById("intheatrepage");
    doc.style.backgroundImage = imagePath;
    doc.style.backgroundRepeat = "no-repeat";
    doc.style.backgroundSize = "contain";
}
function mouseOut()
{
    document.getElementById("intheatrepage").style.background = "black";
}