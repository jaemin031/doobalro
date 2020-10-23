<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>로그인 페이지</title>
<link rel="stylesheet" href="./css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/login.js?ver=2"></script>
</head>

<body>
	<form name="f" method="post" action="login.do">
		<input type="hidden" name="city" value="대전" />
		<div style="background: gray;">
			<div class="container-fluid page-body-wrapper">
				<div class="row">
					<div
						class="content-wrapper full-page-wrapper d-flex align-items-center auth-pages">
						<div class="card col-lg-4 mx-auto">
							<div class="card-body px-5 py-5">
								<h3 class="card-title text-left mb-3">Login</h3>
								<div class="form-group">
									<label>phone number</label> <input type="text"
										class="form-control p_input" id="userPhone" name="userPhone">
								</div>
								<div class="form-group">
									<label>Password</label> <input type="password"
										class="form-control p_input" id="userPw" name="userPw">
								</div>
								<div
									class="form-group d-flex align-items-center justify-content-between">
									<a href="adduserForm.do"> 회원가입 </a> <a href="pwFindForm.do" 	class="forgot-pass">비밀번호 찾기</a>
								</div>
								<div class="text-center">
									<input type="submit" value="로그인"
										onclick="if(!memberSubmit(this.form)){return false;}"
										class="btn btn-primary btn-block enter-btn" />
								</div>


							</div>
						</div>
					</div>

				</div>

			</div>

		</div>
	</form>
</body>

</html>