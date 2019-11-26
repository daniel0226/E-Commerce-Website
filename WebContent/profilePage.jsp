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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/animation.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script src="js/fields.js"></script>
</head>

<body>
	<header>${nav}</header>
	<main style="width: 100%; height: 100%; min-height: 100vh;">
		<section class="profileBackground">
			<div class="profileBackgroundWrapper">
				<div class="profileBody">
					<div class="container-fluid">
						<div class="row">
							<div class="col-sm-6 col-md-6">
								<div class="profileHeader">
									<h2>Welcome, ${name}</h2>
								</div>
							</div>
						</div>
						${errorMsg}
						<div class="row profileInfoBody">
							<div class="col-md-2">
								<div class="button-P">
									<button class="p-tab" type="button" value="about" name="about"
										onclick="openPTab('p-about')">About</button>
								</div>
								<div class="blur"></div>
							</div>
							<div class="col-md-2">
								<button class="p-tab" type="button" value="payment"
									name="payment" onclick="openPTab('p-payment')">Payment</button>
							</div>
							<div class="col-md-2">
								<div class="blur"></div>
								<button class="p-tab" type="button" value="address"
									name="address" onclick="openPTab('p-address')">Address</button>
							</div>
							<div class="col-md-2">
								<div class="blur"></div>
								<button class="p-tab" type="button" value="orderHistory"
									name="orderHistory" onclick="openPTab('p-orderH')">Order
									History</button>
							</div>
							<div class="col-md-2">
								<div class="blur"></div>
								<button
									onclick="window.location.href = 'sessionController?type=edit'"
									class="p-tab" type="button" value="edit" name="edit">Edit
									Profile</button>
							</div>
						</div>
						<div class="row profileInfoBody">
							<div class="col-md-6">
								<div id="p-about" class="profileTab">
									<div class="inputField">
										<label for="fName">First Name: </label> <input id="fName"
											class="p-input" readonly name="fName" value="${fName}"
											type="text">
									</div>
									<div class="inputField">
										<label for="lName">Last Name: </label> <input id="lName"
											class="p-input" readonly name="lName" value="${lName}"
											type="text">
									</div>
									<div class="inputField">
										<label for="email">Email: </label> <input id="email"
											class="p-input" readonly name="email" value="${email}"
											type="text">
									</div>
									<div class="inputField">
										<label for="bday">Birthday: </label> <input id="bday"
											class="p-input" readonly name="bDay" value="${bDay}"
											type="text">
									</div>
									<div class="inputField">
										<label for="phonenumber">Phone Number: </label> <input
											class="p-input" readonly id="phonenumber" type="tel"
											name="phonenumber" value="${phonenumber}"
											pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}">
									</div>
									${checkbox}
								</div>
								<!--About-->
								<div id="p-payment" class="profileTab">
									<div class="inputField">
										<label for="cardname">Name on Card</label> <input
											class="p-input" readonly id="cardname" type="text"
											name="cardname" value="${cardname}">
									</div>
									<div class="inputField">
										<label for="cardEnding">Card Ending</label> <input
											class="p-input" readonly id="cardEnding" type="text"
											name="cardending" value="${cardEnding}">
									</div>
									<div class="inputField">
										<label for="cardExpDate">Card Expiration Date</label> <input
											class="p-input" readonly id="cardExpDate" type="text"
											name="cardExpDate" value="${cardExpDate}">
									</div>
								</div>
								<div id="p-address" class="profileTab">
									<div class="inputField">
										<label for="addressLine">Address Line</label>
										<textarea class="p-input" readonly id="addressLine"
											name="addressLine">${addressLine}</textarea>
									</div>
								</div>
							</div>
						</div>
						<div class="row profileInfoBody" style="margin-top: -65px;">
							<div style="position: relative;" class="col-sm-12 col-md-12">
								<div id="p-orderH" class="profileTab">
									${orderHistory}
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<footer></footer>
</body>

</html>