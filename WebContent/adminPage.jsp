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

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/animation.css">
<link rel="stylesheet" href="css/admin.css">
<link href="mdb/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="mdb/css/mdb.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript" src="mdb/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="mdb/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="mdb/js/mdb.min.js"></script>
<script src="js/fields.js"></script>
<script type="text/javascript" src="js/admin.js"></script>

</head>

<body>
	<span style="display: none;" id="adminPage"></span>
	<main class="adminPageWrapper">
		<div class="container-fluid">
			<div class="row">
				<div id="parentNav"
					class="col-md-2 removeLeftPadding removeRightPadding">
					<div class="fixedNav" id="fixedAdminNav" style="width: 100%;">
						<div style="padding: 13px 0px 0px 13px;">
							<a href="index.jsp" style="font-size: 1.5rem;">9C ADMIN</a>
						</div>
						<div class="welcomeAdmin">
							<p style="padding-left: 10px;">Welcome,</p>
							<p style="padding-left: 10px;">${adminName}</p>
							<p style="padding-left: 10px; font-size: .75rem;">${location}</p>
						</div>
						<div class="adminTabLinksWrapper">
							<button id="movieBtn" type="button"
								class="adminTabLink activeAdminTab"
								onclick="openAdminTab('movieBtn', 'Movies')">
								<i class="fa fa-film"></i> Manage Movies
							</button>
							<button id="showtimeBtn" type="button"
								class="adminTabLink"
								onclick="openAdminTab('showtimeBtn','Showtimes')">
								<i class="fa fa-bookmark"></i> Manage Show Times
							</button>
							<button id="userBtn" type="button" class="adminTabLink"
								onclick="openAdminTab('userBtn', 'Users')">
								<i class="fa fa-user"></i> Manage Users
							</button>
							<button id="empBtn" type="button" class="adminTabLink"
								onclick="openAdminTab('empBtn', 'Employees')">
								<i class="fa fa-user"></i> Manage Employees
							</button>
							<button id="proBtn" type="button" class="adminTabLink"
								onclick="openAdminTab('proBtn', 'Promotions')">
								<i class="fa fa-tag"></i> Manage Promotions
							</button>
						</div>
					</div>
				</div>
				<p id="js-addMovie" style="display: none;">${addMovie}</p>
				<div class="col-md-10 removeLeftPadding removeRightPadding">
					<div class="container-fluid">
						<div class="row">
							<div id="Movies" class="adminTabContent activeTab">
								<div class="container">
									<div class="row">
										<div class="adminHeader">
											<h3>Administrator Panel</h3>
											<form style="float: right" action="sessionController"
												method="GET">
												<button name="type" value="logout" class="logoutBtn">Logout</button>
											</form>
										</div>
									</div>
									<div class="row">
										<div class="tabBody">
											<div class="container">
												<div class="row analyticsBody">
													<div class="col-md-12" style="padding: 25px;">
														<div class="row">
															<div class="col-md-6 removeLeftPadding">
																<p style="float: left;">Add / Edit / Remove Movies</p>
															</div>
															<div class="col-md-6 removeRightPadding">
																<p style="float: right;" class="js-getTodaysDate"></p>
															</div>
														</div>
														<div class="row">
															<h3>
																<i class="fa fa-database"></i> Movies Dashboard
															</h3>
														</div>
														<div class="row pAnalytics">
															<div class="col-md-4 col-sm-4">
																<div class="goalBodyWrapper">
																	<h3 class="js-analytic">${moviesInTheatres}</h3>
																	<small>Movies in Theatres</small>
																</div>
															</div>
															<div class="col-md-4 col-sm-4">
																<div class="goalBodyWrapper">
																	<h3 class="js-analytic">${moviesComingSoon}</h3>
																	<small>Movies Coming Soon</small>
																</div>
															</div>
															<div class="col-md-4 col-sm-4">
																<div class="goalBodyWrapper">
																	<h3 class="js-analytic">${moviesArchived}</h3>
																	<small>Movies Deleted</small>
																</div>
															</div>
														</div>
														<div class="row pAnalytics" style="margin-top: 30px;">
															<div class='col-md-9 col-sm-9'
																style="background: rgb(15, 30, 60);">
																<h3 style="text-align: center; margin-bottom: 1px;">Tickets
																	sold per Movie</h3>
																<canvas id="pieChart"></canvas>
																<div id="js-stats" class="movieStats"
																	style="display: none;">${movieStats};</div>
															</div>
															<div class="col-md-3 col-sm-3">
																<div class="goalBodyWrapper">
																	<h3 style="text-align: center;">Most Popular Movie</h3>
																	${mostPopularMovie}
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="row" style="margin-top: 15px;">
													<div class="col-md-12 removeLeftPadding removeRightPadding">
														${addMovieError}
														<button id="addBtnDe" type="button" value="addMovie"
															name="addMovie" onclick="openAddMovie('addMovie')">Add
															Movie</button>
													</div>
													<div class="col-md-12 removeLeftPadding removeRightPadding">
														<div id="addMovie" class="movieManagementBody">
															<form method="get" action="movieController"
																enctype="multipart/form-data">
																<div class="row">
																	<div class="col-md-6">
																		<div class="movieInfo">
																			<label>Movie Picture</label> <input type="file"
																				name="pic" accept="image/*" required>
																		</div>
																		<div class="movieInfo">
																			<label>Movie Trailer URL</label> <input
																				class="textFieldDes2" type="text" name="video"
																				placeholder="video url" required>
																		</div>
																		<div class="movieInfo">
																			<input type="text" name="title" placeholder="Title"
																				class="textFieldDes2" required>
																		</div>
																		<div class="movieInfo">
																			<input type="text" name="category"
																				placeholder="Category" class="textFieldDes2"
																				required>
																		</div>
																		<div class="movieInfo">
																			<input type="text" name="director"
																				placeholder="Director" class="textFieldDes2"
																				required>
																		</div>
																		<div class="movieInfo">
																			<input type="text" name="producer"
																				placeholder="Producer" class="textFieldDes2"
																				required>
																		</div>
																		<div class="movieInfo">
																			<input type="text" name="cast"
																			placeholder="Cast" class="textFieldDes2" required>
																		</div>
																	</div>
																	<div class="col-md-6">
																		<div class="movieInfo">
																			<label>Synopsis</label>
																			<textarea name="synopsis"
																				placeholder="Enter Synopsis here" required
																				class="textFieldDes2"
																				style="border: 1.5px solid rgb(45, 69, 121);"></textarea>
																		</div>
																		<div class="movieInfo">
																			<input type="text" name="Rated" placeholder="Rated"
																				class="textFieldDes2" required>
																		</div>
																		<div class="movieInfo">
																			<label>Expiration Date:</label> <input type="date"
																				required name="expirationDate">
																		</div>
																		<div class="movieInfo">
																			<label>Release Date:</label> <input type="date"
																				required name="releaseDate">
																		</div>
																		<div class="movieInfo" style="margin-top: 25px;">
																			<button class="adminBtn" type="submit" value="addBtn"
																				name="addBtn">Add</button>
																			<button class="adminBtn"
																				onclick="closeAddForm('addMovie');" type="button"
																				value="cancel" name="cancel">Cancel</button>
																		</div>
																	</div>
																</div>
															</form>
															<!-- Add Movie  -->
														</div>
													</div>
												</div>
												<div class="row" style="margin-top: 15px;">
													<div class="col-md-12 removeLeftPadding removeRightPadding">
														<div class="movieManagementBody">
															<form method="get" action="movieController"
																enctype="multipart/form-data" id="movieManagementForm"
																class="container">
																<div class="row managementHeader"
																	style="border-bottom: solid 1px rgba(115, 159, 225, 1);">
																	<div class="col-md-1">
																		<input type="checkbox" onclick="toggleAll(this)">
																	</div>
																	<div
																		class="col-md-3 borderL-xs borderR-xs justify-content-center">
																		<input onclick="return confirmPost()"
																			class="deleteBtn" style="height: 100%; width: 45%;"
																			type="submit" name="deleteMoviesFromCheckBox"
																			value="Delete">
																	</div>
																	<div class="col-md-8">
																		<div class="container">
																			<div class="row justify-content-center">
																				<div class="col-md-8">
																					<label class="admLable" for="AdmSearchMovie">Search</label>
																					<input id="AdmSearchMovie" class="searchAdminMovie"
																						type="text" placeholder="search"
																						onkeyup="adminSearchMovie()" style="width: 100%;">
																				</div>
																			</div>
																		</div>
																	</div>
																</div>

																<!--These will eventually be created by the Java servlet-->
																<span id="addMoviesBody"> ${addMovies} </span>
															</form>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							
							<!-- SHow Times  -->
							<div id="Showtimes" class="adminTabContent">
								<div class="container">
									<div class="row">
										<div class="adminHeader">
											<h3>Administrator Panel</h3>
											<form style="float: right" action="sessionController"
												method="GET">
												<button name="type" value="logout" class="logoutBtn">Logout</button>
											</form>
										</div>
									</div>
									<div class="row">
										<div class="tabBody">
											<div class="container">
												<div class="row analyticsBody">
													<div class="col-md-12" style="padding: 25px;">
														<div class="row">
															<div class="col-md-6 removeLeftPadding">
																<p style="float: left;">Add / Edit / Remove Showtimes</p>
															</div>
															<div class="col-md-6 removeRightPadding">
																<p style="float: right;" class="js-getTodaysDate"></p>
															</div>
														</div>
														<div class="row">
															<h3>
																<i class="fa fa-database"></i>Dashboard
															</h3>
														</div>
														<div class="row pAnalytics">
															<div class="col-sm-4 col-md-4">
																<div class="goalBodyWrapper">
																	<h3 class="js-analytic">${showtimeCount}</h3>
																	<small>Number of Show Times Today</small>
																</div>
																<div class="goalBodyWrapper">
																	<h3 class="js-analytic">${showingsCount}</h3>
																	<small>Number of Movies Playing Today</small>
																</div>
																<div class="goalBodyWrapper">
																	<h3 class="js-analytic">${moviesInTheatres}</h3>
																	<small>Movies In Theatres</small>
																</div>
															</div>
															<div class="col-sm-8 col-md-8">
																<div class="goalBodyWrapper">
																	<h3 style="text-align: center;">Today's Show Times</h3>
																	<p style="text-align: center;" class="js-getTodaysDate"></p>
																	<div class="container-fluid" style="text-align: center; margin-top: 10px;">
																		<div class="row">
																			<div class="col-sm-12 col-md-12">
																				<div class="showtimeSchedule">
																					${showtimes}
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="showTimeFormBody">
												<div class="showTimeWrapper">
													<div class="container-fluid">
														<div class="row">
															<div class="col-md-12">
																${ErrorMsg}
																<form class="search" method="GET" action="searchMovieController">
																	<label for="searchShowTimes">Search</label>
																	<input type="text" required name="showtimesearch" placeholder="Search A Movie To Edit Show Times">
																</form>
															</div>
														</div>
														${Results}
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div id="Users" class="adminTabContent">
								<div class="container">
									<div class="row">
										<div class="adminHeader">
											<h3>Administrator Panel</h3>
											<form style="float: right" action="sessionController"
												method="GET">
												<button name="type" value="logout" class="logoutBtn">Logout</button>
											</form>
										</div>
									</div>
									<div class="row">
										<div class="tabBody">
											<div class="container">
												<div class="row analyticsBody" style="min-height: 100vh;">
													<div class="col-md-12" style="padding: 25px;">
														<div class="row">
															<div class="col-md-6 removeLeftPadding">
																<p style="float: left;">Suspend / UnSuspend / Remove Users</p>
															</div>
															<div class="col-md-6 removeRightPadding">
																<p style="float: right;" class="js-getTodaysDate"></p>
															</div>
														</div>
														<div class="row">
															<h3>
																<i class="fa fa-database"></i>Dashboard
															</h3>
														</div>
														<div class="row pAnalytics">
															<div class="col-sm-3 col-md-3">
																<div class="goalBodyWrapper">
																	<h3 class="js-analytic">${userCount}</h3>
																	<small>Number of Users</small>
																</div>
															</div>
															<form action="userController" method="GET" class="col-sm-9 col-md-9">
																<div class="goalBodyWrapper searchName">
																	<label for="nameInput">Search</label>
																	<i class="fas fa-search"></i>
																	<input id="nameInput" type="text" required name="searchName" placeholder="Search User Name">
																</div>
															</form>
														</div>
														<div class="row">
															<div class="col-sm-12 col-md-12">
																<div class="goalBodyWrapper" style="display: inline-block; position: relative;">
																	${userList}
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div id="Employees" class="adminTabContent analyticsBody">
								<div class="container">
									<div class="row">
										<div class="adminHeader">
											<h3>Administrator Panel</h3>
											<form style="float: right" action="sessionController"
												method="GET">
												<button name="type" value="logout" class="logoutBtn">Logout</button>
											</form>
										</div>
									</div>
									<div class="row">
										<div class="tabBody">
											<div class="container">
												<div class="row analyticsBody">
													<div class="col-md-12" style="padding: 25px;">
														<div class="row">
															<div class="col-md-6 removeLeftPadding">
																<p style="float: left;">Add / View Employees</p>
															</div>
															<div class="col-md-6 removeRightPadding">
																<p style="float: right;" class="js-getTodaysDate"></p>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-4">
											<div class="goalBodyWrapper">
												<form class="addForm" action="employeeController" method="POST">
													${msg}
													<h2>Add Employee</h2>
													<div class="promotions">
														<label>First Name</label>
														<input required type="text" name="fName" placeholder="First Name">
													</div>
													<div class="promotions">
														<label>Last Name</label>
														<input required type="text" name="lName" placeholder="Last Name">
													</div>
													<div class="promotions">
														<label>Email</label>
														<input required type="text" name="email" placeholder="Email">
													</div>
													<div class="promotions">
														<label>Password</label>
														<input required type="password" name="password" placeholder="Password">
													</div>
													<div class="promotions">
														<label>Phone Number</label>
														<input required type="tel" placeholder="xxx-xxx-xxxx" name="phonenumber" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}">
													</div>
													<button type="submit" value="Submit" name="addEmployee">Submit</button>
												</form>
											</div>
										</div>
										<div class="col-md-8">
											<div style="display: block; width: 100%; height: 100%; padding: 10px 15px;" class="goalBodyWrapper">
												<h2 style="text-align: center;">Current Employees</h2>
												${employees}
											</div>
										</div>
									</div>
								</div>
							</div>
							<div id="Promotions" class="adminTabContent">
								<div class="container">
									<div class="row">
										<div class="adminHeader">
											<h3>Administrator Panel</h3>
											<form style="float: right" action="sessionController"
												method="GET">
												<button name="type" value="logout" class="logoutBtn">Logout</button>
											</form>
										</div>
									</div>
									<div class="row">
										<div class="tabBody">
											<div class="container">
												<div class="row analyticsBody">
													<div class="col-md-12" style="padding: 25px;">
														<div class="row">
															<div class="col-md-6 removeLeftPadding">
																<p style="float: left;">Add / Edit / Remove Showtimes</p>
															</div>
															<div class="col-md-6 removeRightPadding">
																<p style="float: right;" class="js-getTodaysDate"></p>
															</div>
														</div>
														<div class="row">
															<h3>
																<i class="fa fa-database"></i>Dashboard
															</h3>
														</div>
														<div class="row pAnalytics">
															<div class="col-sm-4 col-md-4">
																<div class="goalBodyWrapper">
																	<h3 class="js-analytic">${promoCount}</h3>
																	<small>Number of Promotions Available</small>
																</div>
																<div class="goalBodyWrapper">
																	<h3 class="js-analytic">${promoUsage}</h3>
																	<small>Number of Promotion Transactions</small>
																</div>
																<div class="goalBodyWrapper">
																	<h3 class="js-analytic">${promosArchived}</h3>
																	<small>Promotions Archived</small>
																</div>
															</div>
															<div class="col-sm-4 col-md-4">
																<div class="goalBodyWrapper">
																	${addMsg}
																	<form method="GET" action="promotionController" class="promoBody">
																		<h2>Add a Promotion</h2>
																		<div class="promoField">
																			<label for="addDate">Expiration Date</label>
																			<input id="addDate" required type="date" name="date" value="">
																		</div>
																		<div class="promoField">
																			<label for="addDiscount">Discount Amount</label>
																			<input id="addDiscount" step="0.01" min="0.00" placeholder="0.00" required type="number" name="discount" value="">
																		</div>
																		<div class="buttons">
																			<button type="submit" value="add" name="add">ADD</button>
																		</div>
																	</form>
																</div>
															</div>
															<div class="col-sm-4 col-md-4">
																<div class="goalBodyWrapper">
																	${errorMsg}
																	${promoUpdate}
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!--  PROMOTIONS  -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	${js}
	<footer id="footer"></footer>
</body>

</html>