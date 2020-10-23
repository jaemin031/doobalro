<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정</title>
<link rel="stylesheet" href="./css/style.css">
<script type="text/javascript">
function bikepage() {
	f.action = "Bike.do";
	f.submit();
}
</script>
</head>
<body>
	<form action="userUpdateForm.do" name="f">
		<div class="container-scroller" style="background: gray;">
			<div class="container-fluid page-body-wrapper">
				<div class="row">
					<div
						class="content-wrapper full-page-wrapper d-flex align-items-center auth-pages">
						<div class="card col-lg-4 mx-auto">
							<div class="card-body px-5 py-5">
								<h3 class="card-title text-left mb-3">회원정보</h3>
									<div class="form-group">
									<label>이름:</label>									
									<input type="text" class="form-control p_input" readonly="readonly" value=" ${user.userName}">
								</div>
								<div class="form-group">
								<label>핸드폰번호:</label>									
									<input type="text" class="form-control p_input" readonly="readonly" value=" ${user.userPhone}">
								</div>
								<div class="form-group">
							<label>생일:</label>									
									<input type="text" class="form-control p_input" readonly="readonly" value=" ${user.userBirth}">
								</div>
								 


								<div
									class="form-group d-flex align-items-center justify-content-between">
									<div class="text-center">
										<input type="submit" value="회원정보 수정"
											class="btn btn-primary btn-block enter-btn" /> <input
											type="button" value="취소" onclick="bikepage()"
											class="btn btn-primary btn-block enter-btn" />

									</div>

								</div>

							</div>
						</div>
					</div>
					<!-- content-wrapper ends -->
				</div>
				<!-- row ends -->
			</div>
			<!-- page-body-wrapper ends -->
		</div>
	</form>



</body>
</html>