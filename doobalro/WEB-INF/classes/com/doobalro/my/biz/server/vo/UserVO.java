package com.doobalro.my.biz.server.vo;

import java.io.Serializable;

public class UserVO implements Serializable{
	private int userNum;
	private String userName;
	private String userPhone;
	private String userPw;
	private String userBirth;
	
	public UserVO() {	}
	public UserVO(String userName, String userPhone, String userPw, String userBirth) {
		this.userName = userName;
		this.userPhone = userPhone;
		this.userPw = userPw;
		this.userBirth = userBirth;
	}
	public UserVO(int userNum, String userName, String userPhone, String userPw, String userBirth) {
		this.userNum = userNum;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userPw = userPw;
		this.userBirth = userBirth;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userBirth == null) ? 0 : userBirth.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + userNum;
		result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
		result = prime * result + ((userPw == null) ? 0 : userPw.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		if (userBirth == null) {
			if (other.userBirth != null)
				return false;
		} else if (!userBirth.equals(other.userBirth))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userNum != other.userNum)
			return false;
		if (userPhone == null) {
			if (other.userPhone != null)
				return false;
		} else if (!userPhone.equals(other.userPhone))
			return false;
		if (userPw == null) {
			if (other.userPw != null)
				return false;
		} else if (!userPw.equals(other.userPw))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserVO [userNum=" + userNum + ", userName=" + userName + ", userPhone=" + userPhone + ", userPw="
				+ userPw + ", userBirth=" + userBirth + "]";
	}
	
	
}
