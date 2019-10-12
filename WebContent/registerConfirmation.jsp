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


    <script src="js/fields.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</head>

<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark">
            <div class="container">
                <a href="index.html">
                    <h1 id="header" class="navbar-brand hLink st">Cinema E-Booking</h1>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <!-- For portability, if user is using a smaller screen, collapse links-->
                <div class="navbar-collapse collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <div class="dropdown">
                                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Movies
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <!-- Will Redirect to Search Movie Page and autofilter with "in Theatres"-->
                                    <li><input class="navlogout" onclick="searchNav(0)" value="In Theatres" spellcheck="false"></li>
                                    
                                    <li><input class="navlogout" onclick="searchNav(1)" value="Coming Soon"></li>
                                    
                                    <li><a href="SearchView.html">Search Movies</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Profile
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <!-- About Us/Contact-->
                                    <li><a href="editProfile.html">Edit Profile</a></li>
                                    <li>
                                    <form action="../php/logout.php" method="GET">
                                        <input class="navlogout" type="submit" value="logout">
                                    </form></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                            <div class="dropdown">
                                <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Login
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <!-- About Us/Contact-->
                                    <li><a href="login.html">Login</a></li>
                                    
                                    <li><a href="register.html">Register</a></li>
                                </ul>
                            </div>
                        </li>
                        <li class="nav-item">
                                <div class="dropdown">
                                    <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">Promotions
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <!-- About Us/Contact-->
                                        <li><a href="currentPromotions.html">Promotions</a></li>
                                        
                                    </ul>
                                </div>
                            </li>
                    </ul>
                    <div class="navbar-nav search-container">
                        <form action="../php/searchMovies.php" method="get">
                            <input type="text" name="searchMovie" placeholder="Search for a movie">
                            <button type="submit" class="searchIcon">
                                <i class="fas fa-search"></i>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <section class="bg-blueAbstract">
        <div class="container">
            <div class="registered">
                <h1>Congratulations! You've successfully registered!</h1>
            </div>
            <div>
                <a href="SearchView.html">Search for Movies!</a>
            </div>
        </div>
    </section>
    <footer>
            <div class="footer-Body">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <h1>Stay up to date with Promotions!
                                
                            </h1>
                            <hr>
                            <div>
                                <p>Join over thousands of users who recieve bi-weekly promotional updates! </p>
                                <a href="register.html" class="emailSignUp">Sign Up!</a>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <h2>NAVIGATE</h2>
                            <div class="fll Navigate">
                                <a href="#">In Theatres<i class="right"></i></a>
                                <a href="#">In Theatres<i class="right"></i></a>
                                <a href="#">In Theatres<i class="right"></i></a>
                            </div>
                            <div class="flr Navigate">
                                <a href="#">In Theatres<i class="right"></i></a>
                                <a href="#">In Theatres<i class="right"></i></a>
                                <a href="#">In Theatres<i class="right"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
    
            </div>
            <hr>
            <div class="row justify-content-center">
                <p>Copyright of Daniel Kim, Oscar Lopez, Kranthi, Padmanaban</p>
            </div>
        </footer>
</body>

</html>