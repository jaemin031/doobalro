<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>두발로</title>


<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Landing Page - Start Bootstrap Theme</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="vendor/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<!-- <link href="css/landing-page.min.css" rel="stylesheet">
 -->
</head>
<body>


	<!-- Navigation -->
	<nav class="navbar navbar-light bg-light static-top">
	<div class="container">
		<a class="navbar-brand" href="./main.do">두 발 로</a> <a
			class="btn btn-primary" href="#">기능1</a> <a class="btn btn-primary"
			href="./login.do">기능2</a> <a class="btn btn-primary" href="#">기능3</a>
		<a class="btn btn-primary" href="#">기능4</a> <a class="btn btn-primary"
			href="#">로그인</a>
	</div>
	</nav>


	<div align="left" style="position: relative; z-index: 1; height: 100px">
		<h2>
			<a class="btn btn-primary" href="#">기능4</a>
		</h2>
		<!-- <h2><a href="login.do">login</a></h2> -->
	</div>
	<div align="left" style="position: relative; z-index: 1; height: 100px">
		<h2>
			<a class="btn btn-primary" href="#">기능3</a>
		</h2>
	</div>
	<div align="left" style="position: relative; z-index: 1; height: 100px">
		<h2>
			<a class="btn btn-primary" href="#">기능2</a>
		</h2>
	</div>
	<div id="map" align="center"
		style="width: 800px; height: 600px; background: yellow"></div>
	<script>
		function myMap() {
			var mapOptions = {
				center : new google.maps.LatLng(36.0765667, 126.4323268),
				zoom : 7,
				mapTypeId : google.maps.MapTypeId.HYBRID
			}
			var map = new google.maps.Map(document.getElementById("map"), mapOptions);
		}
	</script>

	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAg6vnqLiXgQxgp3HhhE9iTopC5l98EIXc&callback=myMap"">
	</script>
	<!-- Masthead -->
	<header class="masthead text-white text-center">

	<div class="overlay" style="position: relative; z-index: 2;"></div>
	<div class="container">
		<div class="row">

			<div class="col-md-10 col-lg-8 col-xl-7 mx-auto"></div>
		</div>
	</div>
	</header>

	<!-- Icons Grid -->
	<section class="features-icons bg-light text-center">
	<div class="container">
		<div class="row">
			<div class="col-lg-4">
				<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
					<div class="features-icons-icon d-flex">
						<i class="icon-screen-desktop m-auto text-primary"></i>
					</div>
					<h3>인력거</h3>
					<p class="lead mb-0">This theme will look great on any device,
						no matter the size!</p>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
					<div class="features-icons-icon d-flex">
						<i class="icon-layers m-auto text-primary"></i>
					</div>
					<h3>Bootstrap 4 Ready</h3>
					<p class="lead mb-0">Featuring the latest build of the new
						Bootstrap 4 framework!</p>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="features-icons-item mx-auto mb-0 mb-lg-3">
					<div class="features-icons-icon d-flex">
						<i class="icon-check m-auto text-primary"></i>
					</div>
					<h3>Easy to Use</h3>
					<p class="lead mb-0">Ready to use with your own content, or
						customize the source files!</p>
				</div>
			</div>
		</div>
	</div>
	</section>

	<!-- Footer -->
	<footer class="footer bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 h-100 text-center text-lg-left my-auto">
				<ul class="list-inline mb-2">
					<li class="list-inline-item"><a href="#">About</a></li>
					<li class="list-inline-item">&sdot;</li>
					<li class="list-inline-item"><a href="#">Contact</a></li>
					<li class="list-inline-item">&sdot;</li>
					<li class="list-inline-item"><a href="#">Terms of Use</a></li>
					<li class="list-inline-item">&sdot;</li>
					<li class="list-inline-item"><a href="#">Privacy Policy</a></li>
				</ul>
				<p class="text-muted small mb-4 mb-lg-0">&copy; Your Website
					2018. All Rights Reserved.</p>
			</div>
			<div class="col-lg-6 h-100 text-center text-lg-right my-auto">
				<ul class="list-inline mb-0">
					<li class="list-inline-item mr-3"><a href="#"> <i
							class="fa fa-facebook fa-2x fa-fw"></i>
					</a></li>
					<li class="list-inline-item mr-3"><a href="#"> <i
							class="fa fa-twitter fa-2x fa-fw"></i>
					</a></li>
					<li class="list-inline-item"><a href="#"> <i
							class="fa fa-instagram fa-2x fa-fw"></i>
					</a></li>
				</ul>
			</div>
		</div>
	</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>