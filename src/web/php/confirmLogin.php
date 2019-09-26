<?php 
session_start();

//Global variables

$loginType = ""; //Keep track if user is normal web user or administrator


/**
 * 
 * Will have to change code and function depending on database
 * If we have separate database for admin or user information
 * Or if we have a table cell labeling a user as admin or user.
 * 
 */

/**
 * Connect to MySQL database
 * Validate Login information
 * Update LoginType (E.G user/admin)
 */
function confirmLogin()
{
    $validLogin = FALSE;
    global $loginType;

    $email = $_POST["email"];
    $password = $_POST["password"];

    $database = connectToDatabase();

    $databaseUsername = mysqli_real_escape_string($database, $email);
    $databasePassword = mysqli_real_escape_string($database, $password);

    $validLogin

    $loginType = "admin";
    

    return $validLogin
}

/**
 * Connect to database
 * test comment
 */
function connectToDatabase()
{
    //Credentials to login to database
    $server = "";
    $username = "";
    $password = "";
    $databaseName = "";
    $database = mysqli_connect($server, $username, $password, $databaseName);
    
    //Possibly handle mysql security stuff
    //like prevent mysql injections
    
    return $database;
}

function validateLogin($validLogin)
{
    if($validLogin == TRUE)
    {
        return;
    }else{
        //break out of PHP page
        //Either add invalid username/password on login page
        //Or redirect to incorrect username/password page
    }
}

function redirectPage()
{
    global $loginType;
    if($loginType == "admin")
    {
        //redirect to admin page
    }else{
        //Redirect to either home page/search movies page/etc.
        header('Location: ../../../html/some page');
        exit;
    }
}

function run()
{
    $validLogin = confirmLogin();
    validateLogin($validLogin);
    redirectPage();
}


run();
?>