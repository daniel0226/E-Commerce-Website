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
<header>${nav}</header>
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
                                                <div class="row">
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-phone icon"></i>
                                                        <input class="textFieldDes" id="phonenumber" type="tel"
                                                            name="phonenumber" value="xxx-xxx-xxxx"
                                                            pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}">
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
                                                    <label for="cardname">Card Name</label>
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-user icon"></i>
                                                        <input id="cardname" class="js-payment textFieldDes" type="text"
                                                            placeholder="Card Holder Name" name="cardholdername"
                                                            value="">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label for="creditcard">Card Number</label>
                                                    <div class="col-md-12 removeRightPadding removeLeftPadding">
                                                        <i class="fa fa-credit-card icon"></i>
                                                        <input id="creditcard" class="js-payment textFieldDes"
                                                            type="text" placeholder="Card Number" name="cardnumber"
                                                            value="" maxlength="16">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label for="Month">Expiration Date</label>
                                                    <div class="col-md-12 removeRightPadding removeLeftPadding">
                                                        <i class="fa fa-calendar icon"></i>
                                                        <select id="Month" name="Month">
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
                                                        <input id="cvv" class="js-payment textFieldDes" type="text"
                                                            maxlength="3" name="cvv" placeholder="cvv" value="">
                                                    </div>
                                                    <div class="col-md-6 removeRightPadding">
                                                        <i style="left: 15px;" class="fa fa-map-pin icon"></i>
                                                        <input id="zipcode" class="js-payment textFieldDes" type="text"
                                                            name="zipcode" placeholder="Zip Code" value="">
                                                    </div>
                                                </div>

                                            </div>
                                            <h2>Billing Address</h2>
                                            <div class="container-fluid">
                                                <div class="row">
                                                    <label for="address">Address Line</label>
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-address-card icon"></i>
                                                        <input id="address" class="js-payment textFieldDes" type="text"
                                                            placeholder="Address Line" name="address" value="">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label for="city">City/Town</label>
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-city icon"></i>
                                                        <input id="city" class="js-payment textFieldDes" type="text"
                                                            placeholder="City/Town" name="city" value="">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label for="state">State/Province</label>
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-building icon"></i>
                                                        <input id="state" class="js-payment textFieldDes" type="text"
                                                            placeholder="State/Province" name="state" value="">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <lable for="billingzipcode">Zip Code</lable>
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-map-pin icon"></i>
                                                        <input id="billingzipcode" class="js-payment textFieldDes" type="text"
                                                            name="billingzipcode" placeholder="Zip Code" value="">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label for="country">Country</label>
                                                    <div class="col-md-12 removeLeftPadding removeRightPadding">
                                                        <i class="fa fa-flag icon"></i>
                                                        <select id="country" name="country" style="width: 100%;">
                                                            <option value="" selected="selected">(please select a country)</option>
                                                            <option value="AF">Afghanistan</option>
                                                            <option value="AL">Albania</option>
                                                            <option value="DZ">Algeria</option>
                                                            <option value="AS">American Samoa</option>
                                                            <option value="AD">Andorra</option>
                                                            <option value="AO">Angola</option>
                                                            <option value="AI">Anguilla</option>
                                                            <option value="AQ">Antarctica</option>
                                                            <option value="AG">Antigua and Barbuda</option>
                                                            <option value="AR">Argentina</option>
                                                            <option value="AM">Armenia</option>
                                                            <option value="AW">Aruba</option>
                                                            <option value="AU">Australia</option>
                                                            <option value="AT">Austria</option>
                                                            <option value="AZ">Azerbaijan</option>
                                                            <option value="BS">Bahamas</option>
                                                            <option value="BH">Bahrain</option>
                                                            <option value="BD">Bangladesh</option>
                                                            <option value="BB">Barbados</option>
                                                            <option value="BY">Belarus</option>
                                                            <option value="BE">Belgium</option>
                                                            <option value="BZ">Belize</option>
                                                            <option value="BJ">Benin</option>
                                                            <option value="BM">Bermuda</option>
                                                            <option value="BT">Bhutan</option>
                                                            <option value="BO">Bolivia</option>
                                                            <option value="BA">Bosnia and Herzegowina</option>
                                                            <option value="BW">Botswana</option>
                                                            <option value="BV">Bouvet Island</option>
                                                            <option value="BR">Brazil</option>
                                                            <option value="IO">British Indian Ocean Territory</option>
                                                            <option value="BN">Brunei Darussalam</option>
                                                            <option value="BG">Bulgaria</option>
                                                            <option value="BF">Burkina Faso</option>
                                                            <option value="BI">Burundi</option>
                                                            <option value="KH">Cambodia</option>
                                                            <option value="CM">Cameroon</option>
                                                            <option value="CA">Canada</option>
                                                            <option value="CV">Cape Verde</option>
                                                            <option value="KY">Cayman Islands</option>
                                                            <option value="CF">Central African Republic</option>
                                                            <option value="TD">Chad</option>
                                                            <option value="CL">Chile</option>
                                                            <option value="CN">China</option>
                                                            <option value="CX">Christmas Island</option>
                                                            <option value="CC">Cocos (Keeling) Islands</option>
                                                            <option value="CO">Colombia</option>
                                                            <option value="KM">Comoros</option>
                                                            <option value="CG">Congo</option>
                                                            <option value="CD">Congo, the Democratic Republic of the</option>
                                                            <option value="CK">Cook Islands</option>
                                                            <option value="CR">Costa Rica</option>
                                                            <option value="CI">Cote d'Ivoire</option>
                                                            <option value="HR">Croatia (Hrvatska)</option>
                                                            <option value="CU">Cuba</option>
                                                            <option value="CY">Cyprus</option>
                                                            <option value="CZ">Czech Republic</option>
                                                            <option value="DK">Denmark</option>
                                                            <option value="DJ">Djibouti</option>
                                                            <option value="DM">Dominica</option>
                                                            <option value="DO">Dominican Republic</option>
                                                            <option value="TP">East Timor</option>
                                                            <option value="EC">Ecuador</option>
                                                            <option value="EG">Egypt</option>
                                                            <option value="SV">El Salvador</option>
                                                            <option value="GQ">Equatorial Guinea</option>
                                                            <option value="ER">Eritrea</option>
                                                            <option value="EE">Estonia</option>
                                                            <option value="ET">Ethiopia</option>
                                                            <option value="FK">Falkland Islands (Malvinas)</option>
                                                            <option value="FO">Faroe Islands</option>
                                                            <option value="FJ">Fiji</option>
                                                            <option value="FI">Finland</option>
                                                            <option value="FR">France</option>
                                                            <option value="FX">France, Metropolitan</option>
                                                            <option value="GF">French Guiana</option>
                                                            <option value="PF">French Polynesia</option>
                                                            <option value="TF">French Southern Territories</option>
                                                            <option value="GA">Gabon</option>
                                                            <option value="GM">Gambia</option>
                                                            <option value="GE">Georgia</option>
                                                            <option value="DE">Germany</option>
                                                            <option value="GH">Ghana</option>
                                                            <option value="GI">Gibraltar</option>
                                                            <option value="GR">Greece</option>
                                                            <option value="GL">Greenland</option>
                                                            <option value="GD">Grenada</option>
                                                            <option value="GP">Guadeloupe</option>
                                                            <option value="GU">Guam</option>
                                                            <option value="GT">Guatemala</option>
                                                            <option value="GN">Guinea</option>
                                                            <option value="GW">Guinea-Bissau</option>
                                                            <option value="GY">Guyana</option>
                                                            <option value="HT">Haiti</option>
                                                            <option value="HM">Heard and Mc Donald Islands</option>
                                                            <option value="VA">Holy See (Vatican City State)</option>
                                                            <option value="HN">Honduras</option>
                                                            <option value="HK">Hong Kong</option>
                                                            <option value="HU">Hungary</option>
                                                            <option value="IS">Iceland</option>
                                                            <option value="IN">India</option>
                                                            <option value="ID">Indonesia</option>
                                                            <option value="IR">Iran (Islamic Republic of)</option>
                                                            <option value="IQ">Iraq</option>
                                                            <option value="IE">Ireland</option>
                                                            <option value="IL">Israel</option>
                                                            <option value="IT">Italy</option>
                                                            <option value="JM">Jamaica</option>
                                                            <option value="JP">Japan</option>
                                                            <option value="JO">Jordan</option>
                                                            <option value="KZ">Kazakhstan</option>
                                                            <option value="KE">Kenya</option>
                                                            <option value="KI">Kiribati</option>
                                                            <option value="KP">Korea, Democratic People's Republic of</option>
                                                            <option value="KR">Korea, Republic of</option>
                                                            <option value="KW">Kuwait</option>
                                                            <option value="KG">Kyrgyzstan</option>
                                                            <option value="LA">Lao People's Democratic Republic</option>
                                                            <option value="LV">Latvia</option>
                                                            <option value="LB">Lebanon</option>
                                                            <option value="LS">Lesotho</option>
                                                            <option value="LR">Liberia</option>
                                                            <option value="LY">Libyan Arab Jamahiriya</option>
                                                            <option value="LI">Liechtenstein</option>
                                                            <option value="LT">Lithuania</option>
                                                            <option value="LU">Luxembourg</option>
                                                            <option value="MO">Macau</option>
                                                            <option value="MK">Macedonia, The Former Yugoslav Republic of</option>
                                                            <option value="MG">Madagascar</option>
                                                            <option value="MW">Malawi</option>
                                                            <option value="MY">Malaysia</option>
                                                            <option value="MV">Maldives</option>
                                                            <option value="ML">Mali</option>
                                                            <option value="MT">Malta</option>
                                                            <option value="MH">Marshall Islands</option>
                                                            <option value="MQ">Martinique</option>
                                                            <option value="MR">Mauritania</option>
                                                            <option value="MU">Mauritius</option>
                                                            <option value="YT">Mayotte</option>
                                                            <option value="MX">Mexico</option>
                                                            <option value="FM">Micronesia, Federated States of</option>
                                                            <option value="MD">Moldova, Republic of</option>
                                                            <option value="MC">Monaco</option>
                                                            <option value="MN">Mongolia</option>
                                                            <option value="MS">Montserrat</option>
                                                            <option value="MA">Morocco</option>
                                                            <option value="MZ">Mozambique</option>
                                                            <option value="MM">Myanmar</option>
                                                            <option value="NA">Namibia</option>
                                                            <option value="NR">Nauru</option>
                                                            <option value="NP">Nepal</option>
                                                            <option value="NL">Netherlands</option>
                                                            <option value="AN">Netherlands Antilles</option>
                                                            <option value="NC">New Caledonia</option>
                                                            <option value="NZ">New Zealand</option>
                                                            <option value="NI">Nicaragua</option>
                                                            <option value="NE">Niger</option>
                                                            <option value="NG">Nigeria</option>
                                                            <option value="NU">Niue</option>
                                                            <option value="NF">Norfolk Island</option>
                                                            <option value="MP">Northern Mariana Islands</option>
                                                            <option value="NO">Norway</option>
                                                            <option value="OM">Oman</option>
                                                            <option value="PK">Pakistan</option>
                                                            <option value="PW">Palau</option>
                                                            <option value="PA">Panama</option>
                                                            <option value="PG">Papua New Guinea</option>
                                                            <option value="PY">Paraguay</option>
                                                            <option value="PE">Peru</option>
                                                            <option value="PH">Philippines</option>
                                                            <option value="PN">Pitcairn</option>
                                                            <option value="PL">Poland</option>
                                                            <option value="PT">Portugal</option>
                                                            <option value="PR">Puerto Rico</option>
                                                            <option value="QA">Qatar</option>
                                                            <option value="RE">Reunion</option>
                                                            <option value="RO">Romania</option>
                                                            <option value="RU">Russian Federation</option>
                                                            <option value="RW">Rwanda</option>
                                                            <option value="KN">Saint Kitts and Nevis</option>
                                                            <option value="LC">Saint LUCIA</option>
                                                            <option value="VC">Saint Vincent and the Grenadines</option>
                                                            <option value="WS">Samoa</option>
                                                            <option value="SM">San Marino</option>
                                                            <option value="ST">Sao Tome and Principe</option>
                                                            <option value="SA">Saudi Arabia</option>
                                                            <option value="SN">Senegal</option>
                                                            <option value="SC">Seychelles</option>
                                                            <option value="SL">Sierra Leone</option>
                                                            <option value="SG">Singapore</option>
                                                            <option value="SK">Slovakia (Slovak Republic)</option>
                                                            <option value="SI">Slovenia</option>
                                                            <option value="SB">Solomon Islands</option>
                                                            <option value="SO">Somalia</option>
                                                            <option value="ZA">South Africa</option>
                                                            <option value="GS">South Georgia and the South Sandwich Islands</option>
                                                            <option value="ES">Spain</option>
                                                            <option value="LK">Sri Lanka</option>
                                                            <option value="SH">St. Helena</option>
                                                            <option value="PM">St. Pierre and Miquelon</option>
                                                            <option value="SD">Sudan</option>
                                                            <option value="SR">Suriname</option>
                                                            <option value="SJ">Svalbard and Jan Mayen Islands</option>
                                                            <option value="SZ">Swaziland</option>
                                                            <option value="SE">Sweden</option>
                                                            <option value="CH">Switzerland</option>
                                                            <option value="SY">Syrian Arab Republic</option>
                                                            <option value="TW">Taiwan, Province of China</option>
                                                            <option value="TJ">Tajikistan</option>
                                                            <option value="TZ">Tanzania, United Republic of</option>
                                                            <option value="TH">Thailand</option>
                                                            <option value="TG">Togo</option>
                                                            <option value="TK">Tokelau</option>
                                                            <option value="TO">Tonga</option>
                                                            <option value="TT">Trinidad and Tobago</option>
                                                            <option value="TN">Tunisia</option>
                                                            <option value="TR">Turkey</option>
                                                            <option value="TM">Turkmenistan</option>
                                                            <option value="TC">Turks and Caicos Islands</option>
                                                            <option value="TV">Tuvalu</option>
                                                            <option value="UG">Uganda</option>
                                                            <option value="UA">Ukraine</option>
                                                            <option value="AE">United Arab Emirates</option>
                                                            <option value="GB">United Kingdom</option>
                                                            <option value="US">United States</option>
                                                            <option value="UM">United States Minor Outlying Islands</option>
                                                            <option value="UY">Uruguay</option>
                                                            <option value="UZ">Uzbekistan</option>
                                                            <option value="VU">Vanuatu</option>
                                                            <option value="VE">Venezuela</option>
                                                            <option value="VN">Viet Nam</option>
                                                            <option value="VG">Virgin Islands (British)</option>
                                                            <option value="VI">Virgin Islands (U.S.)</option>
                                                            <option value="WF">Wallis and Futuna Islands</option>
                                                            <option value="EH">Western Sahara</option>
                                                            <option value="YE">Yemen</option>
                                                            <option value="YU">Yugoslavia</option>
                                                            <option value="ZM">Zambia</option>
                                                            <option value="ZW">Zimbabwe</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="container-fluid">
                                                <div class="row">
                                                    <div class="col-md-1 removeLeftPadding">
                                                        <input type="checkbox" name="promoCheckBox" value="1">
                                                    </div>
                                                    <div class="col-md-11 removeRightPadding">
                                                        Sign Up for Promotions!
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
                                            <a href="sessionController?type=login">Already have an account?</a>

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