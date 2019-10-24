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


    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        <script src="js/fields.js"></script>
</head>

<body>
    <header id="navH"></header>

    <section class="promoPage">
        <div class="profileBackground">
            <div class="blurB">
                <div class="container">
                    <div class="row justify-content-center" style="padding: 100px 0px;">
                        <div class="col-md-12 removeLeftPadding removeRightPadding">
                            <div class="editProfileWrapper">
                                <form action="sessionController" method="POST">
                                    <div class="tabs">
                                        <div class="tab justify-content-center">
                                            <button type="button" class="tablinks borderL-xs borderR-xs"
                                                onclick="openTab(event, 'about')"><i
                                                    class="fa fa-user-circle"></i>About</button>
                                            <button type="button" class="tablinks borderR-xs"
                                                onclick="openTab(event, 'payment')"><i
                                               
                                                class="fa fa-dollar-sign"></i>Payment</button>
                                        </div>
                                        <div id="about" class="tabcontent">
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col-md-9 tabInput">
                                                        <h2>About You</h2>
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="row">
                                                                    <div class="col-md-4">
                                                                        <label>First Name</label>
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <input id="fNameEdit" class="names" type="text"
                                                                            value="${fName}" name="firstname">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="row">
                                                                    <div class="col-md-4">
                                                                        <label>Last Name</label>
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <input id="lNameEdit" class="names" type="text"
                                                                            value="${lname }" name="lastname">
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="row">
                                                                    <div class="col-md-4">
                                                                        <label>Email</label>
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <input id="EmailEdit" class="names" type="text"
                                                                            value="${email}" name="email">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="row">
                                                                    <div class="col-md-4">
                                                                        <label>Birth Date</label>
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <input id="bdayEdit" type="date" class="names"
                                                                            value="${bDay}" name="bday">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="row">
                                                                    <div class="col-md-4">
                                                                        <label>Password</label>
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <input id="PassEdit" class="names"
                                                                            type="password" value="${password}"
                                                                            name="password">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="row">
                                                                    <div class="col-md-4">
                                                                        <label>Confirm Password</label>
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <input id="cPassEdit" class="names"
                                                                            type="password" value=""
                                                                            name="confirmpassword">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="row">
                                                                    <div class="col-md-4">
                                                                        <label>Phone Number</label>
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <input id="phonenumberEdit" class="names"
                                                                            type="tel" name="phonenumber"
                                                                            value=""
                                                                            pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="tableO tableLinks">
                                                            <div class="tableI">
                                                                <div>
                                                                    <button type="submit" value="Save">Save</button>
                                                                </div>
                                                                <div>
                                                                    <a href="index.jsp">Cancel</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="payment" class="tabcontent">
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col-md-9 tabInput">
                                                        <h2>Payment Information</h2>
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="row">
                                                                    <div class="col-md-4">
                                                                        <label>Card Name</label>
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <input id="cardname" class="names" type="text"
                                                                            placeholder="Card Holder Name"
                                                                            name="cardname">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="row">
                                                                    <div class="col-md-4">
                                                                        <label>CVV</label>
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <input id="cvv" class="names" type="text"
                                                                            placeholder="CVV" name="cvv" maxlength=3>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <div class="row">
                                                                    <div class="col-md-4">
                                                                        <label>Card Number</label>
                                                                    </div>
                                                                    <div class="col-md-8">
                                                                        <input id="cardnumber" class="names" type="text"
                                                                            placeholder="Card Number" name="cardnumber">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="row">
                                                                    <div class="col-md-4">
                                                                        <label>Expiration
                                                                            Date</label>
                                                                    </div>
                                                                    <div class="col-md-4">
                                                                        <label>Month</label>
                                                                        <select id="Month" class="names">
                                                                            <option value="01">January</option>
                                                                            <option value="02">February </option>
                                                                            <option value="03">March</option>
                                                                            <option value="04">April</option>
                                                                            <option value="05">May</option>
                                                                            <option value="06">June</option>
                                                                            <option value="07">July</option>
                                                                            <option value="08">August</option>
                                                                            <option value="09">September</option>
                                                                            <option value="10">October</option>
                                                                            <option value="11">November</option>
                                                                            <option value="12">December</option>
                                                                        </select>
                                                                    </div>
                                                                    <div class="col-md-4">
                                                                        <label>Year</label>
                                                                        <select id="year" class="names">
                                                                            <option value="16"> 2019</option>
                                                                            <option value="17"> 2020</option>
                                                                            <option value="18"> 2021</option>
                                                                            <option value="19"> 2022</option>
                                                                            <option value="20"> 2023</option>
                                                                            <option value="21"> 2024</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <div class="tableO tableLinks">
                                                            <div class="tableI">
                                                                <div>
                                                                    <button type="submit" value="Save">Save</button>
                                                                </div>
                                                                <div>
                                                                    <a href="index.jsp">Cancel</a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                               		</div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <footer>
    </footer>
</body>

</html>