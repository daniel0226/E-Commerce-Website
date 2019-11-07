<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        <script src="js/fields.js"></script>
</head>

<body>
    <header>${nav}</header>
    <section class="forgetPasswordBody">
        <div class="bodyWrapper">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 justify-content-center">
                        <form action="passwordController" method="POST">
                            <h2>Please enter your password</h2>
                            ${errorMsg}
                            <div class="row">
                                <div class="col-md-12 removeLeftPadding removeRightPadding">
                                    <i class="fa fa-lock icon"></i>
                                    <input style="padding-left: 40px" class="textFieldDes" id="password" type="password" placeholder="Password"
                                        name="password" value="" required>
                                </div>
                            </div>
                            <input id="infS" class="pwBtn" name="enterPassword" type="submit" value="Submit">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <footer></footer>
</body>

</html>