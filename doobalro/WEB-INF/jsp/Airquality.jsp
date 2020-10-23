<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>대기 환경</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Animation library for notifications   -->
<link href="assets/css/animate.min.css" rel="stylesheet" />

<!-- Bootstrap core CSS     -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!--  Paper Dashboard core CSS    -->
<link href="css/paper-dashboard.css" rel="stylesheet" />

<!--  Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Muli:400,300'
	rel='stylesheet' type='text/css'>
<link href="css/themify-icons.css" rel="stylesheet">
<script type="text/javascript">

</script>
</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-background-color="white"
			data-active-color="danger">
			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="http://www.creative-tim.com" class="simple-text">
						Doobalro </a>
				</div>

				<ul class="nav">
					<li><a href="Bike.do"> <i class="ti-direction "></i>
							<p>전국 거치소 현황</p>
					</a></li>
					<li><a href="weatherList.do"> <i class="ti-shine"></i>
							<p>날씨</p>
					</a></li>
					<li class="active"><a href="AirQuality.do"> <i
							class="ti-cloud"></i>
							<p>대기질</p>
					</a></li>
					<li><a href="creAccident.do"> <i class="ti-bar-chart "></i>
							<p>자전거 사고</p>
					</a></li>
					<li><a href="./listBoard.do"> <i class="ti-comment"></i>
							<p>게시판</p>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel"">
			<!-- 우측 상단 내비게이션 바 -->
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
						<span class="icon-bar bar3"></span>
					</button>
					<a class="navbar-brand" href="#">Air</a>
				</div>
				<jsp:include page="topNav.jsp" />
			</div>
			</nav>
			<div style="padding-top: 2em;">
				<table>
					<tr>
						<td><img src="./image/AirQuality.jpg" width="700px"
							height="700px"></td>
					</tr>
					<tr>
						<td>${nowTime}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>