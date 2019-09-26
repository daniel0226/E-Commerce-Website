<?php 
session_start();

/**
 * The system must allow web users to register for the system. To register, users should provide their
 *password, personal information (name, phone number, email address, and password). They might
 *optionally, provide payment information (card type, number, and expiration date, and billing address)
 *and home address info (street, city, state and zip code). 

 * User’s registration is verified by entering a verification code that is generated by the system and sent to
 *the user’s email address. After confirmation, the customer will be assigned a unique account ID.
 *Registered users (Customers) can login using their account ID or email address and password. Each email
 *address will be linked to one account ID and each account must belong to one customer. 
 */


function createUser()
{
    $Profile = new stdClass();
    $Profile->email = $_POST['email'];
    $Profile->password = $_POST['password'];
    $Profile->confirmPassword = $_POST['confirmpassword'];
    $Profile->firstname = $_POST['firstname'];
    $Profile->lastname = $_POST['lastname'];
    $secondName = "";
    $phoneNumber = "";
    $cardType = "";
    $cardNumber = "";
    $cardExpDate = "";
    $cardStreet = "":
    $cardCity = "";
    $cardState = "";
    $cardZip = "";
    $homeStreet = "";
    $homeCity = "";
    $homeState = "";
    $homeZip = "";

    //If we decide to incorporate an age restriction
    $month = "";
    $day = "";
    $year = "";
    return $Profile;


}

function run()
{
    $user = createUser();
    //Generate verification code and send to email
    

}


run();
?>