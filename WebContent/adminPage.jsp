<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>CSCI4050</title>
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
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script src="js/fields.js"></script>

</head>

<body>
    <main class="adminPageWrapper">
        <div class="container-fluid">
            <div class="row">
                <div id="parentNav" class="col-md-2 removeLeftPadding removeRightPadding">
                    <div class="fixedNav" id="fixedAdminNav" style="width: 100%;">
                        <div>
                            <h1 style="font-size: 1.5rem; padding: 15px 0px 0px 15px;">E-Booking</h1>
                        </div>
                        <div class="welcomeAdmin">
                            <p style="padding-left: 10px;">Welcome, </p>
                            <p style="padding-left: 10px;">${adminName}</p>
                            <p style="padding-left: 10px; font-size: .75rem;">Athens, GA</p>
                        </div>
                        <div class="adminTabLinksWrapper">
                            <button id="movieBtn" type="button" class="adminTabLink activeAdminTab"
                                onclick="openAdminTab('movieBtn', 'Movies')">
                                <i class="fa fa-film"></i>
                                Manage Movies</button>
                            <button id="userBtn" type="button" class="adminTabLink"
                                onclick="openAdminTab('userBtn', 'Users')">
                                <i class="fa fa-user"></i>
                                Manage Users</button>
                            <button id="empBtn" type="button" class="adminTabLink"
                                onclick="openAdminTab('empBtn', 'Employees')">
                                <i class="fa fa-user"></i>
                                Manage Employees</button>
                            <button id="proBtn" type="button" class="adminTabLink"
                                onclick="openAdminTab('proBtn', 'Promotions')">
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
                                                    <button id="addBtnDe" type="button" value="addMovie" name="addMovie"
                                                        onclick="openAddMovie('addMovie')">Add Movie</button>
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <div id="addMovie" class="movieManagementBody">
                                                            <form method="GET" action="movieController">
                                                                <div class="row">
                                                                    <div class="col-md-6">
                                                                        <div class="movieInfo">
                                                                            <label>Movie
                                                                                Picture</label>
                                                                            <input type="file" name="pic"
                                                                                accept="image/*">
                                                                        </div>
                                                                        <div class="movieInfo">
                                                                            <label>Movie
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
                                                                            <input type="text" name="category"
                                                                                placeholder="Category"
                                                                                class="textFieldDes2">
                                                                        </div>
                                                                        <div class="movieInfo">
                                                                            <input type="text" name="director"
                                                                                placeholder="Director"
                                                                                class="textFieldDes2">
                                                                        </div>
                                                                        <div class="movieInfo">
                                                                            <input type="text" name="producer"
                                                                                placeholder="Producer"
                                                                                class="textFieldDes2">
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-6">
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
                                                                            <label>Expiration
                                                                                Date:</label>
                                                                            <input type="date" name="expirationDate">
                                                                        </div>
                                                                        <div class="movieInfo">
                                                                            <label>Release  
                                                                                Date:</label>
                                                                            <input type="date" name="releaseDate">
                                                                        </div>
                                                                        <div class="movieInfo" style="margin-top: 25px;">
                                                                            <button class="adminBtn" type="submit"
                                                                                value="addBtn"
                                                                                name="addBtn">Add</button>
                                                                            <button class="adminBtn"
                                                                                onclick="closeAddForm('addMovie');"
                                                                                type="button" value="cancel"
                                                                                name="cancel">Cancel</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row" style="margin-top: 15px;">
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <div class="movieManagementBody">
                                                            <form method="GET" action="movieController"
                                                                id="movieManagementForm" class="container">
                                                                <div class="row managementHeader"
                                                                    style="border-bottom: solid 1px rgba(115,159,225,1);">
                                                                    <div class="col-md-1">
                                                                        <input type="checkbox"
                                                                            onclick="toggleAll(this)">
                                                                    </div>
                                                                    <div
                                                                        class="col-md-3 borderL-xs borderR-xs justify-content-center">
                                                                        <input
                                                                            onclick="confirm('Are you sure you want to delete checked movies?');"
                                                                            class="deleteBtn"
                                                                            style="height: 100%; width:45%;"
                                                                            type="submit"
                                                                            name="deleteMoviesFromCheckBox"
                                                                            value="Delete">
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <div class="container">
                                                                            <div class="row">
                                                                                <div class="col-md-4">
                                                                                    <Label style="float: right;"
                                                                                        for="AdmSearchMovie">Search:
                                                                                    </Label>
                                                                                </div>
                                                                                <div class="col-md-8">
                                                                                    <input id="AdmSearchMovie"
                                                                                        class="searchAdminMovie"
                                                                                        type="text" placeholder="search"
                                                                                        onkeyup="adminSearchMovie()"
                                                                                        style="width: 100%;">
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <!--These will eventually be created by the Java servlet-->

                                                                <div class="row movieObjects" id="Joker">
                                                                    <div class="col-md-1">
                                                                        <input type="checkbox" name="movieCheckbox"
                                                                            value="joker" name="joker">
                                                                    </div>
                                                                    <div
                                                                        class="col-md-3 borderL-xs borderR-xs moviePicBody">
                                                                        <div class="moviePic">
                                                                            <img src="images/MoviePhoto/JokerWallpaper.jpg"
                                                                                alt="Joker">
                                                                            <button class="editBtn adminBtn"
                                                                                id="jokerBtn"
                                                                                onclick="showEditTab('jokerInfo', 'jokerBtn')"
                                                                                type="button" style="display: block;"
                                                                                value="Edit">Edit</button>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-8 movieInfoDisplay"
                                                                        id="jokerInfo">
                                                                        <div class="container">
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <div class="movieInfo">
                                                                                        <label>Movie
                                                                                            Picture</label>
                                                                                        <input type="file" name="pic"
                                                                                            accept="image/*">
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                        <label>Movie
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
                                                                                <div class="col-md-6">
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
                                                                                        <label>Expiration
                                                                                            Date:</label>
                                                                                        <input type="date"
                                                                                            name="expirationDate">
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                        <label>Release
                                                                                            Date:</label>
                                                                                        <input type="date"
                                                                                            name="releaseDate">
                                                                                    </div>
                                                                                    <div class="movieInfo"
                                                                                        style="margin-top: 20px;">
                                                                                        <button class="adminBtn"
                                                                                            type="submit" value="Update"
                                                                                            name="update">Update</button>
                                                                                        <button class="adminBtn"
                                                                                            onclick="if(!closeForm('jokerInfo', 'jokerBtn'))return false;"
                                                                                            type="button" value="cancel"
                                                                                            name="cancel">Cancel</button>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <!--Joker-->

                                                                <!--Lion King-->
                                                                <div class="row movieObjects" id="LionKing">
                                                                    <div class="col-md-1">
                                                                        <input type="checkbox" name="movieCheckbox"
                                                                            value="lionking" name="lionking">
                                                                    </div>
                                                                    <div class="col-md-3 borderL-xs borderR-xs">
                                                                        <div class="moviePic">
                                                                            <img src="images/MoviePhoto/LionKing.jpg"
                                                                                alt="lionKing">
                                                                            <button class="editBtn adminBtn"
                                                                                id="LionKingBtn" style="display: block;"
                                                                                onclick="showEditTab('LionKingInfo', 'LionKingBtn')"
                                                                                type="button" value="Edit">Edit</button>
                                                                        </div>
                                                                    </div>
                                                                    <div class="col-md-8 movieInfoDisplay"
                                                                        id="LionKingInfo">
                                                                        <div class="container">
                                                                            <div class="row">
                                                                                <div class="col-md-6">
                                                                                    <div class="movieInfo">
                                                                                        <label for="moviepicture">Movie
                                                                                            Picture</label>
                                                                                        <input id="moviepicture"
                                                                                            type="file" name="pic"
                                                                                            accept="image/*">
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                        <label for="trailer">Movie
                                                                                            Trailer</label>
                                                                                        <input id="trailer" type="file"
                                                                                            name="video"
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
                                                                                <div class="col-md-6">

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
                                                                                        <label
                                                                                            for="expirationDate">Expiration
                                                                                            Date:</label>
                                                                                        <input type="date"
                                                                                            name="expirationDate">
                                                                                    </div>
                                                                                    <div class="movieInfo">
                                                                                        <label for="releasedate">Release
                                                                                            Date:</label>
                                                                                        <input id="releasedate"
                                                                                            type="date"
                                                                                            name="releaseDate">
                                                                                    </div>
                                                                                    <div class="movieInfo"
                                                                                        style="margin-top: 20px;">
                                                                                        <button class="adminBtn"
                                                                                            type="submit" value="Update"
                                                                                            name="update">Update</button>
                                                                                        <button class="adminBtn"
                                                                                            onclick="closeForm('LionKingInfo', 'LionKingBtn')"
                                                                                            type="button" value="cancel"
                                                                                            name="cancel">Cancel</button>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <!--LionKIng-->
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
    <footer id="footer"></footer>
</body>

</html>