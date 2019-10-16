<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<title>CSCI4050</title>

<head>

    <!--Responsive design-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Yong Kim">
    <meta charset="utf-8">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/animation.css">
    <link rel="stylesheet" href="css/admin.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="js/fields.js"></script>

</head>

<body>
    <main class="adminPageWrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2 removeLeftPadding removeRightPadding">
                    <div class="sideNavWrapper">
                        <div>
                            <h1 style="font-size: 1.5rem; padding-left: 15px; padding-top: 15px;">E-Booking</h1>
                        </div>
                        <div class="welcomeAdmin">
                            <p style="padding-left: 10px;">Welcome, </p>
                            <p style="padding-left: 10px;">${adminName}</p>
                            <p style="padding-left: 10px; font-size: .75rem;">Athens, GA</p>
                        </div>
                        <div class="adminTabLinksWrapper">
                            <button class="adminTabLink active" onclick="openAdminTab(event, 'Movies')">
                                <i class="fa fa-film"></i>
                                Manage Movies</button>
                            <button class="adminTabLink" onclick="openAdminTab(event, 'Users')">
                                <i class="fa fa-user"></i>
                                Manage Users</button>
                            <button class="adminTabLink" onclick="openAdminTab(event, 'Employees')">
                                <i class="fa fa-user"></i>
                                Manage Employees</button>
                            <button class="adminTabLink" onclick="openAdminTab(event, 'Promotions')">
                                <i class="fa fa-tag"></i>
                                Manage Promotions</button>
                        </div>
                    </div>
                </div>
                <div class="col-md-10 removeLeftPadding removeRightPadding">
                    <div class="container-fluid">
                        <div class="row">
                            <div id="Movies" class="adminTabContent activeTab">
                                <div class="container">
                                    <div class="row">
                                        <div class="adminHeader">
                                            <h3>Administrator Panel</h3>
                                            <form style="float:right" action="logoutController" method="GET">
                                                <button class="logoutBtn">Logout</button>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="tabBody">
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col-md-6 removeLeftPadding">
                                                        <p style="float: left;">
                                                            Add / Edit / Remove Movies
                                                        </p>
                                                    </div>
                                                    <div class="col-md-6 removeRightPadding">
                                                        <p style="float: right;" id="js-getTodaysDate">

                                                        </p>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <h3><i class="fa fa-database"></i> Movies Dashboard</h3>
                                                </div>
                                                <div class="row pAnalytics">
                                                    <div class="col-md-4">
                                                        <p>${moviesInTheatres}</p>
                                                        <p>Movies in Theatres now.</p>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <p>${moviesComingSoon}</p>
                                                        <p>Movies Coming Soon.</p>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <p>${moviesArchived}</p>
                                                        <p>Movies Archived.</p>
                                                    </div>
                                                </div>
                                                <div class="row" style="margin-top: 15px;">
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <div class="movieManagementBody">
                                                            <form method="GET" action="movieController" id="movieManagementForm"
                                                                class="container">
                                                                <div class="row"
                                                                    style="border-bottom: solid 1px rgba(115,159,225,1);">
                                                                    <div class="col-md-1">
                                                                        <input type="checkbox"
                                                                            onclick="toggleAll(this)">
                                                                    </div>
                                                                    <div class="col-md-3">
                                                                        <input style="height: 100%;" type="submit"
                                                                            name="deleteMoviesFromCheckBox"
                                                                            value="Delete">
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <Label>Search: </Label>
                                                                        <input id="AdmSearchMovie"
                                                                            class="searchAdminMovie" type="text"
                                                                            placeholder="search"
                                                                            onkeyup="adminSearchMovie()">
                                                                    </div>
                                                                </div>
                                                                <div class="movieObjects" id="Joker">
                                                                    <div class="row">
                                                                        <div class="container" style="padding-left: 10px !important;">
                                                                            <div class="row">
                                                                                <div class="col-md-1">
                                                                                    <input type="checkbox"
                                                                                        name="movieCheckbox"
                                                                                        value="">
                                                                                </div>
                                                                                <div class="col-md-3">
                                                                                    <div class="moviePic">
                                                                                        <img
                                                                                            src="images/MoviePhoto/JokerWallpaper.jpg">
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col-md-4">
                                                                                    <div class="movieInfo">
                                                                                        <label for="pic">Movie
                                                                                            Picture</label>
                                                                                        <input type="file" name="pic"
                                                                                            accept="image/*">
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                        <label for="video">Movie
                                                                                            Trailer</label>
                                                                                        <input type="file" name="video"
                                                                                            accept="video/*">
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                        <input type="text" name="title"
                                                                                            placeholder="Title"
                                                                                            class="textFieldDes2">
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                        <input type="text"
                                                                                            name="category"
                                                                                            placeholder="Category"
                                                                                            class="textFieldDes2">
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                        <input type="text"
                                                                                            name="director"
                                                                                            placeholder="Director"
                                                                                            class="textFieldDes2">
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                            <input type="text"
                                                                                                name="producer"
                                                                                                placeholder="Producer"
                                                                                                class="textFieldDes2">
                                                                                        </div>
                                                                                </div>
                                                                                <div class="col-md-4">
                                                                                    
                                                                                    <div class="movieInfo">
                                                                                        <label>Synopsis</label>
                                                                                        <textarea name="synopsis"
                                                                                            placeholder="Enter Synopsis here"
                                                                                            class="textFieldDes2"
                                                                                            style="border: 1.5px solid rgb(45,69,121);"></textarea>
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                        <input type="text" name="Rated"
                                                                                            placeholder="Rated"
                                                                                            class="textFieldDes2">
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                        <label for="expirationDate">Expiration Date:</label>
                                                                                        <input type="date" name="expirationDate">
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                        <label for="releaseDate">Release Date:</label>
                                                                                        <input type="date"
                                                                                            name="releaseDate">
                                                                                    </div>

                                                                                </div>
                                                                            </div>
                                                                            <div class="row justify-content-center">
                                                                                <div class="col-md-6">
                                                                                    <button value="update" name="update"
                                                                                        type="submit">Update</button>
                                                                                    <button value="cancel" name="cancel"
                                                                                        type="submit">Cancel</button>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <!--Joker-->
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="Users" class="adminTabContent">
                                <h3>Manage Users</h3>
                            </div>
                            <div id="Employees" class="adminTabContent">
                                <h3>Manage Employees</h3>
                            </div>
                            <div id="Promotions" class="adminTabContent">
                                <h3>Manage Promotions</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer></footer>
</body>

</html>