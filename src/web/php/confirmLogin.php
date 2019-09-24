<?php 

//Global variables

$loginType = ""; //Keep track if user is normal web user or administrator

function confirmLogin()
{
    $validLogin = FALSE;
    global $loginType;

    $username = $_GET["username"];
    $password = $_GET["password"];

    //Connect to DB
    //Validate login info
    //update logintype
    $loginType = "admin";
    

    return $validLogin
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