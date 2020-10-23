<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Required meta tags -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>로그인 페이지</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="./css/style.css">
  <script src="http://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/pwfind.js?ver=2"></script>
</head>
<body>

<body>
<form action="changePw.do" name="f">
  <div class="container-scroller" style="background: gray;">
    <div class="container-fluid page-body-wrapper">
      <div class="row">
        <div class="content-wrapper full-page-wrapper d-flex align-items-center auth-pages">
          <div class="card col-lg-4 mx-auto">
            <div class="card-body px-5 py-5">
              <h3 class="card-title text-left mb-3">비밀번호 수정</h3>
            
                <div class="form-group">
                  <label>수정할 비밀번호</label>
                  <input type="password" class="form-control p_input" name="userPw">                
                </div>
                <div class="form-group">
                  <label>비밀번호 확인</label>
                  <input type="password" class="form-control p_input" name="userPw2">
                </div>
                <div class="form-group d-flex align-items-center justify-content-between">
                               
                </div>
            			<input type="hidden"  name="userName" value="${userName}">
		
		 <div class="text-center">
					<input type="submit" value="비밀번호 수정"  class="btn btn-primary btn-block enter-btn" onclick="if(!pwfind(this.form)){return false;}"/>
				   	<input type="button" value="취소" class="btn btn-primary btn-block enter-btn"	 onclick="loginpage()">
					
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

</body>
</html>