function memberSubmit(check){
	if(check.userPhone.value=="")
		{
		alert("핸드폰 번호를 입력하지 않았습니다.")
		check.userPhone.focus()
		return false;
		}
	
	var userPhoneCheck = /^[0-9]+$/;
	if(!userPhoneCheck.test(check.userPhone.value)){
		alert("핸드폰번호는 숫자만 입력 가능합니다.")
		check.userPhone.focus()
		return false;
	}
	
	if(check.userPw.value=="")
		{
		alert("비밀번호를 입력하지 않았습니다.")
		check.userPw.focus()
		return false;
		}
	
	document.f.submit()
	
	}
