<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" name="userPw" id="userPw" value="${users.userPw}"  ></td>
		</tr>

		<tr>
			<th>휴대폰번호</th>
			<td><input type="text" id="userPhone" name="userPhone" value="${users.userPhone}"></td>
		</tr>
	</table>


	<a href="updateUser.do">수정</a>
	<a href="deleteUser.do">회원탈퇴</a>
	<a href="loginForm.do">취소</a>
</body>
</html>