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
                                                <button type="button" class="tablinks borderR-xs"
                                                    onclick="openTab(event, 'address')">
                                                    <i class="fa fa-map-pin"></i>Address</button>
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
                                                                            <input
                                                                                style="background-color: rgba(0, 0, 0, 0.2);"
                                                                                id="EmailEdit" class="names" readonly
                                                                                type="text" value="${email}" name="email">
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
                                                                                type="tel" name="phonenumber" value=""
                                                                                pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}">
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <div class="row">
                                                                        <div class="col-md-2">
                                                                            <input style="box-shadow: none;" type="checkbox" name="promoCheckBox"
                                                                                value="1">
                                                                        </div>
                                                                        <div class="col-md-10">
                                                                            <p>Sign Up for Promotions!</p>
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
                                            <div id="address" class="tabcontent">
                                                <div class="container">
                                                    <div class="row">
                                                        <div class="col-md-9 tabInput">
                                                            <div class="row justify-content-center">
                                                                <div class="col-md-10">
                                                                    <h2>Address Information</h2>
                                                                    <div class="row">
                                                                        <div class="col-md-3">
                                                                            <label for="addressLine">Address Line</label>
                                                                        </div>
                                                                        <div class="col-md-9">
                                                                            <input id="addressLine" class="names"
                                                                                type="text" placeholder="Address Line"
                                                                                name="address" value="${address}">
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-3">
                                                                            <label for="city">City / Town</label>
                                                                        </div>
                                                                        <div class="col-md-9">
                                                                            <input id="city" class="names" type="text"
                                                                                placeholder="City / Town" name="city"
                                                                                value="${city}">
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-3">
                                                                            <label for="state">State / Province</label>
                                                                        </div>
                                                                        <div class="col-md-9">
                                                                            <input id="state" class="names" type="text"
                                                                                placeholder="State / Province" name="state"
                                                                                value="${state}">
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-3">
                                                                            <label for="billingZip">Zip Code</label>
                                                                        </div>
                                                                        <div class="col-md-9">
                                                                            <input id="billingZip" class="names" type="text"
                                                                                placeholder="Zip Code" name="billingZipCode"
                                                                                value="${billingZip}">
                                                                        </div>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-3">
                                                                            <label for="country">Country</label>
                                                                        </div>
                                                                        <div class="col-md-9">
                                                                            <select id="country" name="country"
                                                                                class="names" style="width: 100%;">
                                                                                <option value="" selected="selected">(please
                                                                                    select a country)</option>
                                                                                <option value="AF">Afghanistan</option>
                                                                                <option value="AL">Albania</option>
                                                                                <option value="DZ">Algeria</option>
                                                                                <option value="AS">American Samoa</option>
                                                                                <option value="AD">Andorra</option>
                                                                                <option value="AO">Angola</option>
                                                                                <option value="AI">Anguilla</option>
                                                                                <option value="AQ">Antarctica</option>
                                                                                <option value="AG">Antigua and Barbuda
                                                                                </option>
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
                                                                                <option value="BA">Bosnia and Herzegowina
                                                                                </option>
                                                                                <option value="BW">Botswana</option>
                                                                                <option value="BV">Bouvet Island</option>
                                                                                <option value="BR">Brazil</option>
                                                                                <option value="IO">British Indian Ocean
                                                                                    Territory</option>
                                                                                <option value="BN">Brunei Darussalam
                                                                                </option>
                                                                                <option value="BG">Bulgaria</option>
                                                                                <option value="BF">Burkina Faso</option>
                                                                                <option value="BI">Burundi</option>
                                                                                <option value="KH">Cambodia</option>
                                                                                <option value="CM">Cameroon</option>
                                                                                <option value="CA">Canada</option>
                                                                                <option value="CV">Cape Verde</option>
                                                                                <option value="KY">Cayman Islands</option>
                                                                                <option value="CF">Central African Republic
                                                                                </option>
                                                                                <option value="TD">Chad</option>
                                                                                <option value="CL">Chile</option>
                                                                                <option value="CN">China</option>
                                                                                <option value="CX">Christmas Island</option>
                                                                                <option value="CC">Cocos (Keeling) Islands
                                                                                </option>
                                                                                <option value="CO">Colombia</option>
                                                                                <option value="KM">Comoros</option>
                                                                                <option value="CG">Congo</option>
                                                                                <option value="CD">Congo, the Democratic
                                                                                    Republic of the</option>
                                                                                <option value="CK">Cook Islands</option>
                                                                                <option value="CR">Costa Rica</option>
                                                                                <option value="CI">Cote d'Ivoire</option>
                                                                                <option value="HR">Croatia (Hrvatska)
                                                                                </option>
                                                                                <option value="CU">Cuba</option>
                                                                                <option value="CY">Cyprus</option>
                                                                                <option value="CZ">Czech Republic</option>
                                                                                <option value="DK">Denmark</option>
                                                                                <option value="DJ">Djibouti</option>
                                                                                <option value="DM">Dominica</option>
                                                                                <option value="DO">Dominican Republic
                                                                                </option>
                                                                                <option value="TP">East Timor</option>
                                                                                <option value="EC">Ecuador</option>
                                                                                <option value="EG">Egypt</option>
                                                                                <option value="SV">El Salvador</option>
                                                                                <option value="GQ">Equatorial Guinea
                                                                                </option>
                                                                                <option value="ER">Eritrea</option>
                                                                                <option value="EE">Estonia</option>
                                                                                <option value="ET">Ethiopia</option>
                                                                                <option value="FK">Falkland Islands
                                                                                    (Malvinas)</option>
                                                                                <option value="FO">Faroe Islands</option>
                                                                                <option value="FJ">Fiji</option>
                                                                                <option value="FI">Finland</option>
                                                                                <option value="FR">France</option>
                                                                                <option value="FX">France, Metropolitan
                                                                                </option>
                                                                                <option value="GF">French Guiana</option>
                                                                                <option value="PF">French Polynesia</option>
                                                                                <option value="TF">French Southern
                                                                                    Territories</option>
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
                                                                                <option value="HM">Heard and Mc Donald
                                                                                    Islands</option>
                                                                                <option value="VA">Holy See (Vatican City
                                                                                    State)</option>
                                                                                <option value="HN">Honduras</option>
                                                                                <option value="HK">Hong Kong</option>
                                                                                <option value="HU">Hungary</option>
                                                                                <option value="IS">Iceland</option>
                                                                                <option value="IN">India</option>
                                                                                <option value="ID">Indonesia</option>
                                                                                <option value="IR">Iran (Islamic Republic
                                                                                    of)</option>
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
                                                                                <option value="KP">Korea, Democratic
                                                                                    People's Republic of</option>
                                                                                <option value="KR">Korea, Republic of
                                                                                </option>
                                                                                <option value="KW">Kuwait</option>
                                                                                <option value="KG">Kyrgyzstan</option>
                                                                                <option value="LA">Lao People's Democratic
                                                                                    Republic</option>
                                                                                <option value="LV">Latvia</option>
                                                                                <option value="LB">Lebanon</option>
                                                                                <option value="LS">Lesotho</option>
                                                                                <option value="LR">Liberia</option>
                                                                                <option value="LY">Libyan Arab Jamahiriya
                                                                                </option>
                                                                                <option value="LI">Liechtenstein</option>
                                                                                <option value="LT">Lithuania</option>
                                                                                <option value="LU">Luxembourg</option>
                                                                                <option value="MO">Macau</option>
                                                                                <option value="MK">Macedonia, The Former
                                                                                    Yugoslav Republic of</option>
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
                                                                                <option value="FM">Micronesia, Federated
                                                                                    States of</option>
                                                                                <option value="MD">Moldova, Republic of
                                                                                </option>
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
                                                                                <option value="AN">Netherlands Antilles
                                                                                </option>
                                                                                <option value="NC">New Caledonia</option>
                                                                                <option value="NZ">New Zealand</option>
                                                                                <option value="NI">Nicaragua</option>
                                                                                <option value="NE">Niger</option>
                                                                                <option value="NG">Nigeria</option>
                                                                                <option value="NU">Niue</option>
                                                                                <option value="NF">Norfolk Island</option>
                                                                                <option value="MP">Northern Mariana Islands
                                                                                </option>
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
                                                                                <option value="RU">Russian Federation
                                                                                </option>
                                                                                <option value="RW">Rwanda</option>
                                                                                <option value="KN">Saint Kitts and Nevis
                                                                                </option>
                                                                                <option value="LC">Saint LUCIA</option>
                                                                                <option value="VC">Saint Vincent and the
                                                                                    Grenadines</option>
                                                                                <option value="WS">Samoa</option>
                                                                                <option value="SM">San Marino</option>
                                                                                <option value="ST">Sao Tome and Principe
                                                                                </option>
                                                                                <option value="SA">Saudi Arabia</option>
                                                                                <option value="SN">Senegal</option>
                                                                                <option value="SC">Seychelles</option>
                                                                                <option value="SL">Sierra Leone</option>
                                                                                <option value="SG">Singapore</option>
                                                                                <option value="SK">Slovakia (Slovak
                                                                                    Republic)</option>
                                                                                <option value="SI">Slovenia</option>
                                                                                <option value="SB">Solomon Islands</option>
                                                                                <option value="SO">Somalia</option>
                                                                                <option value="ZA">South Africa</option>
                                                                                <option value="GS">South Georgia and the
                                                                                    South Sandwich Islands</option>
                                                                                <option value="ES">Spain</option>
                                                                                <option value="LK">Sri Lanka</option>
                                                                                <option value="SH">St. Helena</option>
                                                                                <option value="PM">St. Pierre and Miquelon
                                                                                </option>
                                                                                <option value="SD">Sudan</option>
                                                                                <option value="SR">Suriname</option>
                                                                                <option value="SJ">Svalbard and Jan Mayen
                                                                                    Islands</option>
                                                                                <option value="SZ">Swaziland</option>
                                                                                <option value="SE">Sweden</option>
                                                                                <option value="CH">Switzerland</option>
                                                                                <option value="SY">Syrian Arab Republic
                                                                                </option>
                                                                                <option value="TW">Taiwan, Province of China
                                                                                </option>
                                                                                <option value="TJ">Tajikistan</option>
                                                                                <option value="TZ">Tanzania, United Republic
                                                                                    of</option>
                                                                                <option value="TH">Thailand</option>
                                                                                <option value="TG">Togo</option>
                                                                                <option value="TK">Tokelau</option>
                                                                                <option value="TO">Tonga</option>
                                                                                <option value="TT">Trinidad and Tobago
                                                                                </option>
                                                                                <option value="TN">Tunisia</option>
                                                                                <option value="TR">Turkey</option>
                                                                                <option value="TM">Turkmenistan</option>
                                                                                <option value="TC">Turks and Caicos Islands
                                                                                </option>
                                                                                <option value="TV">Tuvalu</option>
                                                                                <option value="UG">Uganda</option>
                                                                                <option value="UA">Ukraine</option>
                                                                                <option value="AE">United Arab Emirates
                                                                                </option>
                                                                                <option value="GB">United Kingdom</option>
                                                                                <option value="US">United States</option>
                                                                                <option value="UM">United States Minor
                                                                                    Outlying Islands</option>
                                                                                <option value="UY">Uruguay</option>
                                                                                <option value="UZ">Uzbekistan</option>
                                                                                <option value="VU">Vanuatu</option>
                                                                                <option value="VE">Venezuela</option>
                                                                                <option value="VN">Viet Nam</option>
                                                                                <option value="VG">Virgin Islands (British)
                                                                                </option>
                                                                                <option value="VI">Virgin Islands (U.S.)
                                                                                </option>
                                                                                <option value="WF">Wallis and Futuna Islands
                                                                                </option>
                                                                                <option value="EH">Western Sahara</option>
                                                                                <option value="YE">Yemen</option>
                                                                                <option value="YU">Yugoslavia</option>
                                                                                <option value="ZM">Zambia</option>
                                                                                <option value="ZW">Zimbabwe</option>
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