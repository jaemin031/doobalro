function pwfind(check){
	if(check.userPw.value=="")
		{
		alert("핸드폰 번호를 입력하지 않았습니다.")
		check.userPw.focus()
		return false;
		}
	
	var userPhoneCheck = /^[0-9]+$/;
	if(!userPhoneCheck.test(check.userPw.value)){
		alert("핸드폰번호는 숫자만 입력 가능합니다.")
		check.userPhone.focus()
		return false;
	}
	/*	if(check.userPw2.value=="")
		{
		alert("2차 비밀번호를 입력하지 않았습니다.")
		check.userPw2.focus()
		return false;
		}
	*/
	if(check.userBirth.value=="")
	{
	alert("생일을 입력하지 않았습니다.")
	check.userBirth.focus()
	return false;
	}
	
	document.f.submit()
}

function loginpage() {
	f.action = "loginForm.do";
	f.submit();
}