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

function setUpCarouselCenter()
{
	console.log("Creating carousel");
    $('.carouselInTheatre').slick({
        centerMode: true,
        centerPadding: '60px',
        slidesToShow: 4,
        nextArrow: $('.Innext'),
        prevArrow: $('.Inprev'),
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
    setUpIDs();
}
function setUpCarouselCenter2()
{
	console.log("Creating carousel");
    $('.carouselComingSoon').slick({
        centerMode: true,
        centerPadding: '60px',
        slidesToShow: 4,
        infinite: true,
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
    setUpIDs();
}
function setUpIDs()
{

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
        '                    <div class="col-md-5">' +
        '                        <h1>Stay up to date with Promotions!' +
        '                        </h1>' +
        '                        <hr>' +
        '                        <div>' +
        '                            <p>Join over thousands of users who recieve bi-weekly promotional updates! </p>' +
        '                            <a href="sessionController?type=promo" class="emailSignUp">Sign Up!</a>' +
        '                        </div>' +
        '                    </div>' +
        '                    <div class="col-md-7">' +
        '                        <h2>CONTACT</h2>' +
        '                        <div class="fll Navigate">' +
        '                        	<a href="#">Email: Daniel1996k@icloud.com<i class="right"></i></a>' +
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
    loadAnalyticsNums()
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
    
    var count = 0;

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

function mouseOver(img,div)
{
    var imagePath = "url('images/MoviePhoto/" + img + "')";
    var doc = document.getElementsByClassName(div);
    for(var i = 0; i<doc.length; i++)
    {
    	 doc[i].style.backgroundImage = imagePath;
    	 doc[i].style.backgroundRepeat = "no-repeat";
    	 doc[i].style.backgroundSize = "cover";
    }
}
function mouseOut(div)
{
	var doc = document.getElementsByClassName(div);
	for(var i = 0; i<doc.length; i++)
	{
		doc[i].style.background = "black";
	}
}

function loadSelect(month, year, country)
{
	var mSelect = document.getElementById("Month");
	var ySelect = document.getElementById("Year");
	var cSelect = document.getElementById("country");
	cSelect.value = country;
	ySelect.value = year;
	mSelect.value = month;
}
function selectOption(div, option)
{
	var select = document.getElementById(div);
	select.value = option;
}
var isoCountries = {
	    'AF' : 'Afghanistan',
	    'AX' : 'Aland Islands',
	    'AL' : 'Albania',
	    'DZ' : 'Algeria',
	    'AS' : 'American Samoa',
	    'AD' : 'Andorra',
	    'AO' : 'Angola',
	    'AI' : 'Anguilla',
	    'AQ' : 'Antarctica',
	    'AG' : 'Antigua And Barbuda',
	    'AR' : 'Argentina',
	    'AM' : 'Armenia',
	    'AW' : 'Aruba',
	    'AU' : 'Australia',
	    'AT' : 'Austria',
	    'AZ' : 'Azerbaijan',
	    'BS' : 'Bahamas',
	    'BH' : 'Bahrain',
	    'BD' : 'Bangladesh',
	    'BB' : 'Barbados',
	    'BY' : 'Belarus',
	    'BE' : 'Belgium',
	    'BZ' : 'Belize',
	    'BJ' : 'Benin',
	    'BM' : 'Bermuda',
	    'BT' : 'Bhutan',
	    'BO' : 'Bolivia',
	    'BA' : 'Bosnia And Herzegovina',
	    'BW' : 'Botswana',
	    'BV' : 'Bouvet Island',
	    'BR' : 'Brazil',
	    'IO' : 'British Indian Ocean Territory',
	    'BN' : 'Brunei Darussalam',
	    'BG' : 'Bulgaria',
	    'BF' : 'Burkina Faso',
	    'BI' : 'Burundi',
	    'KH' : 'Cambodia',
	    'CM' : 'Cameroon',
	    'CA' : 'Canada',
	    'CV' : 'Cape Verde',
	    'KY' : 'Cayman Islands',
	    'CF' : 'Central African Republic',
	    'TD' : 'Chad',
	    'CL' : 'Chile',
	    'CN' : 'China',
	    'CX' : 'Christmas Island',
	    'CC' : 'Cocos (Keeling) Islands',
	    'CO' : 'Colombia',
	    'KM' : 'Comoros',
	    'CG' : 'Congo',
	    'CD' : 'Congo, Democratic Republic',
	    'CK' : 'Cook Islands',
	    'CR' : 'Costa Rica',
	    'CI' : 'Cote D\'Ivoire',
	    'HR' : 'Croatia',
	    'CU' : 'Cuba',
	    'CY' : 'Cyprus',
	    'CZ' : 'Czech Republic',
	    'DK' : 'Denmark',
	    'DJ' : 'Djibouti',
	    'DM' : 'Dominica',
	    'DO' : 'Dominican Republic',
	    'EC' : 'Ecuador',
	    'EG' : 'Egypt',
	    'SV' : 'El Salvador',
	    'GQ' : 'Equatorial Guinea',
	    'ER' : 'Eritrea',
	    'EE' : 'Estonia',
	    'ET' : 'Ethiopia',
	    'FK' : 'Falkland Islands (Malvinas)',
	    'FO' : 'Faroe Islands',
	    'FJ' : 'Fiji',
	    'FI' : 'Finland',
	    'FR' : 'France',
	    'GF' : 'French Guiana',
	    'PF' : 'French Polynesia',
	    'TF' : 'French Southern Territories',
	    'GA' : 'Gabon',
	    'GM' : 'Gambia',
	    'GE' : 'Georgia',
	    'DE' : 'Germany',
	    'GH' : 'Ghana',
	    'GI' : 'Gibraltar',
	    'GR' : 'Greece',
	    'GL' : 'Greenland',
	    'GD' : 'Grenada',
	    'GP' : 'Guadeloupe',
	    'GU' : 'Guam',
	    'GT' : 'Guatemala',
	    'GG' : 'Guernsey',
	    'GN' : 'Guinea',
	    'GW' : 'Guinea-Bissau',
	    'GY' : 'Guyana',
	    'HT' : 'Haiti',
	    'HM' : 'Heard Island & Mcdonald Islands',
	    'VA' : 'Holy See (Vatican City State)',
	    'HN' : 'Honduras',
	    'HK' : 'Hong Kong',
	    'HU' : 'Hungary',
	    'IS' : 'Iceland',
	    'IN' : 'India',
	    'ID' : 'Indonesia',
	    'IR' : 'Iran, Islamic Republic Of',
	    'IQ' : 'Iraq',
	    'IE' : 'Ireland',
	    'IM' : 'Isle Of Man',
	    'IL' : 'Israel',
	    'IT' : 'Italy',
	    'JM' : 'Jamaica',
	    'JP' : 'Japan',
	    'JE' : 'Jersey',
	    'JO' : 'Jordan',
	    'KZ' : 'Kazakhstan',
	    'KE' : 'Kenya',
	    'KI' : 'Kiribati',
	    'KR' : 'Korea',
	    'KW' : 'Kuwait',
	    'KG' : 'Kyrgyzstan',
	    'LA' : 'Lao People\'s Democratic Republic',
	    'LV' : 'Latvia',
	    'LB' : 'Lebanon',
	    'LS' : 'Lesotho',
	    'LR' : 'Liberia',
	    'LY' : 'Libyan Arab Jamahiriya',
	    'LI' : 'Liechtenstein',
	    'LT' : 'Lithuania',
	    'LU' : 'Luxembourg',
	    'MO' : 'Macao',
	    'MK' : 'Macedonia',
	    'MG' : 'Madagascar',
	    'MW' : 'Malawi',
	    'MY' : 'Malaysia',
	    'MV' : 'Maldives',
	    'ML' : 'Mali',
	    'MT' : 'Malta',
	    'MH' : 'Marshall Islands',
	    'MQ' : 'Martinique',
	    'MR' : 'Mauritania',
	    'MU' : 'Mauritius',
	    'YT' : 'Mayotte',
	    'MX' : 'Mexico',
	    'FM' : 'Micronesia, Federated States Of',
	    'MD' : 'Moldova',
	    'MC' : 'Monaco',
	    'MN' : 'Mongolia',
	    'ME' : 'Montenegro',
	    'MS' : 'Montserrat',
	    'MA' : 'Morocco',
	    'MZ' : 'Mozambique',
	    'MM' : 'Myanmar',
	    'NA' : 'Namibia',
	    'NR' : 'Nauru',
	    'NP' : 'Nepal',
	    'NL' : 'Netherlands',
	    'AN' : 'Netherlands Antilles',
	    'NC' : 'New Caledonia',
	    'NZ' : 'New Zealand',
	    'NI' : 'Nicaragua',
	    'NE' : 'Niger',
	    'NG' : 'Nigeria',
	    'NU' : 'Niue',
	    'NF' : 'Norfolk Island',
	    'MP' : 'Northern Mariana Islands',
	    'NO' : 'Norway',
	    'OM' : 'Oman',
	    'PK' : 'Pakistan',
	    'PW' : 'Palau',
	    'PS' : 'Palestinian Territory, Occupied',
	    'PA' : 'Panama',
	    'PG' : 'Papua New Guinea',
	    'PY' : 'Paraguay',
	    'PE' : 'Peru',
	    'PH' : 'Philippines',
	    'PN' : 'Pitcairn',
	    'PL' : 'Poland',
	    'PT' : 'Portugal',
	    'PR' : 'Puerto Rico',
	    'QA' : 'Qatar',
	    'RE' : 'Reunion',
	    'RO' : 'Romania',
	    'RU' : 'Russian Federation',
	    'RW' : 'Rwanda',
	    'BL' : 'Saint Barthelemy',
	    'SH' : 'Saint Helena',
	    'KN' : 'Saint Kitts And Nevis',
	    'LC' : 'Saint Lucia',
	    'MF' : 'Saint Martin',
	    'PM' : 'Saint Pierre And Miquelon',
	    'VC' : 'Saint Vincent And Grenadines',
	    'WS' : 'Samoa',
	    'SM' : 'San Marino',
	    'ST' : 'Sao Tome And Principe',
	    'SA' : 'Saudi Arabia',
	    'SN' : 'Senegal',
	    'RS' : 'Serbia',
	    'SC' : 'Seychelles',
	    'SL' : 'Sierra Leone',
	    'SG' : 'Singapore',
	    'SK' : 'Slovakia',
	    'SI' : 'Slovenia',
	    'SB' : 'Solomon Islands',
	    'SO' : 'Somalia',
	    'ZA' : 'South Africa',
	    'GS' : 'South Georgia And Sandwich Isl.',
	    'ES' : 'Spain',
	    'LK' : 'Sri Lanka',
	    'SD' : 'Sudan',
	    'SR' : 'Suriname',
	    'SJ' : 'Svalbard And Jan Mayen',
	    'SZ' : 'Swaziland',
	    'SE' : 'Sweden',
	    'CH' : 'Switzerland',
	    'SY' : 'Syrian Arab Republic',
	    'TW' : 'Taiwan',
	    'TJ' : 'Tajikistan',
	    'TZ' : 'Tanzania',
	    'TH' : 'Thailand',
	    'TL' : 'Timor-Leste',
	    'TG' : 'Togo',
	    'TK' : 'Tokelau',
	    'TO' : 'Tonga',
	    'TT' : 'Trinidad And Tobago',
	    'TN' : 'Tunisia',
	    'TR' : 'Turkey',
	    'TM' : 'Turkmenistan',
	    'TC' : 'Turks And Caicos Islands',
	    'TV' : 'Tuvalu',
	    'UG' : 'Uganda',
	    'UA' : 'Ukraine',
	    'AE' : 'United Arab Emirates',
	    'GB' : 'United Kingdom',
	    'US' : 'United States',
	    'UM' : 'United States Outlying Islands',
	    'UY' : 'Uruguay',
	    'UZ' : 'Uzbekistan',
	    'VU' : 'Vanuatu',
	    'VE' : 'Venezuela',
	    'VN' : 'Viet Nam',
	    'VG' : 'Virgin Islands, British',
	    'VI' : 'Virgin Islands, U.S.',
	    'WF' : 'Wallis And Futuna',
	    'EH' : 'Western Sahara',
	    'YE' : 'Yemen',
	    'ZM' : 'Zambia',
	    'ZW' : 'Zimbabwe'
	};

	function getCountryCode (countryCode) {
	    if (isoCountries.hasOwnProperty(countryCode)) {
	        return isoCountries[countryCode];
	    } else {
	        return countryCode;
	    }
	}
	
function decreaseCount(id)
{
	var input = document.getElementById(id);
	var currentVal = input.value;
	if(currentVal == 0)
	{
		return;
	}else
	{
		input.stepDown(1);
	}
}
function increaseCount(id)
{
	var input = document.getElementById(id);
	var currentVal = input.value;
	if(currentVal >= 25)
	{
		return;
	}else
	{
		input.stepUp(1);
		return;
	}
}
function selectSeat(div, btn)
{
	var i = document.getElementById(div);
	if(i.style.color == "white")
	{
		i.style.color = "#00aeef";
		document.getElementById(btn).setAttribute('value', -1);
	}else
	{
		i.style.color = "white";
		var j = document.getElementById(btn).value = div;
		document.getElementById(btn).setAttribute('value', div);
	}
}