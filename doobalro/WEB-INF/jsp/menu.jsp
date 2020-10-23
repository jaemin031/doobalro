<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Menu</title>
</head>
<body>
	<div class="sidebar" data-background-color="white"
		data-active-color="danger">

		<!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->
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
				<li><a href="AirQuality.do"> <i class="ti-cloud"></i>
						<p>대기질</p>
				</a></li>
				<li><a href="creAccident.do"> <i class="ti-bar-chart "></i>
						<p>자전거 사고</p>
				</a></li>
				<li class="active"><a href="./listBoard.do"> <i
						class="ti-comment"></i>
						<p>게시판</p>
				</a></li>
			</ul>
		</div>
	</div>
</body>
</html>