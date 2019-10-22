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

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/animation.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">


    
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript" src="js/fields.js"></script>
</head>

<body>
    <header id="navH"></header>
    
    <section class="registerPage">
        <div class="signUpWrapper" style="padding: 100px 0px 100px 0px;">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-5 removeRightPadding">
                        <div class="signUpInfo">
                            <div class="e-Body e-Padding">
                                <h1>Cinema E-Booking</h1>
                                <h2>Never Wait in Line Again</h2>
                                <hr>
                                <p>
                                    We are a revolutionary digital experience that defies the theatre
                                    experience. Join now and enjoy the benefits of being a member! "Our Website Name"
                                    allows
                                    you
                                    to checkout and book movie tickets and seatings quickly and easily! Get great deals
                                    through our promotions!
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-7 removeLeftPadding">
                        <form class="registrationForm" action="RegisterController" method="POST">
                            <div class="createAccountHeader">
                                <h2>Create Account</h2>
                            </div>
                            <div class="container-fluid field">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="fieldWrapper">
                                            <h2>We Will Need</h2>
                                            <div class="container-fluid">
                                                <div class="row">
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-user icon"></i>
                                                        <input class="textFieldDes" id="First_Name" type="text"
                                                            placeholder="First Name" name="firstname" value="" required>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-user icon"></i>
                                                        <input class="textFieldDes" id="Last_Name" type="text"
                                                            placeholder="Last Name" name="lastname" value="" required>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-lock icon"></i>
                                                        <input class="textFieldDes" id="password" type="password"
                                                            placeholder="Password" name="password" value="" required>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <p id="confStatus" class="errorMessage"></p>
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-lock icon"></i>
                                                        <input class="textFieldDes" id="confirmPassword" type="password"
                                                            placeholder="Confirm Password" name="confirmPassword"
                                                            value="" required>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    ${errorOutput}
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-envelope icon"></i>
                                                        <input class="textFieldDes" id="email" type="email"
                                                            placeholder="Email" name="email" value="" required>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-birthday-cake icon"></i>
                                                        <input class="textFieldDes" id="birthday" type="date"
                                                            name="bday" value="" required>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--SignUp container-->
                                        </div>
                                    </div>
                                    <div class="col-md-6 borderL">
                                        <div class="fieldWrapper">
                                            <h2>Optional Payment Method</h2>
                                            ${paymentErrorOutput}
                                            <div class="container-fluid">
                                                <div class="row">
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-user icon"></i>
                                                        <input id="cardname" class="js-payment textFieldDes" type="text"
                                                            placeholder="Card Holder Name" name="cardholdername"
                                                            value="">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12 removeRightPadding removeLeftPadding">
                                                        <i class="fa fa-credit-card icon"></i>
                                                        <input id="creditcard" class="js-payment textFieldDes" type="text"
                                                            placeholder="Card Number" name="cardnumber" value=""
                                                            maxlength="16">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12 removeRightPadding removeLeftPadding">
                                                        <i class="fa fa-calendar icon"></i>
                                                        <select id="Month" name = "Month">
                                                            <option value="January">January</option>
                                                            <option value="February">February </option>
                                                            <option value="March">March</option>
                                                            <option value="April">April</option>
                                                            <option value="May">May</option>
                                                            <option value="June">June</option>
                                                            <option value="July">July</option>
                                                            <option value="August">August</option>
                                                            <option value="September">September</option>
                                                            <option value="October">October</option>
                                                            <option value="November">November</option>
                                                            <option value="December">December</option>
                                                        </select>
                                                        <select id="Year" name="Year">
                                                            <option value="2019"> 2019</option>
                                                            <option value="2020"> 2020</option>
                                                            <option value="2021"> 2021</option>
                                                            <option value="2022"> 2022</option>
                                                            <option value="2023"> 2023</option>
                                                            <option value="2024"> 2024</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-6 removeLeftPadding">
                                                        <i class="fa fa-credit-card icon"></i>
                                                        <input id="cvv" class="js-payment textFieldDes" type="text" maxlength="3"
                                                            name="cvv" placeholder="cvv" value="">
                                                    </div>
                                                    <div class="col-md-6 removeRightPadding">
                                                        <i style="left: 15px;" class="fa fa-map-pin icon"></i>
                                                        <input id="zipcode" class="js-payment textFieldDes" type="text"
                                                            name="zipcode" placeholder="Zip Code" value="">
                                                    </div>
                                                </div>
                                            </div>
                                            <!--Payment stuff-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="container">
                                <div class="row justify-content-center">
                                    <div class="col-md-6">
                                        <div class="submitField">
                                                <input id="infS" name="infS" type="submit" value="Register">
                                                <a href="login.jsp">Already have an account?</a>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <footer>
    </footer>
</body>

</html>