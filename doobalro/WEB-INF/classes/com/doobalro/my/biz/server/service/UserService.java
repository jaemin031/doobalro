package com.doobalro.my.biz.server.service;

import com.doobalro.my.biz.server.vo.UserVO;

public interface UserService {
	public String login(UserVO vo);//�뜝�떥源띿삕�뜝�룞�삕

	public String addUser(UserVO vo);//�쉶�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕

	public String deleteUser(UserVO vo);//�쉶�뜝�룞�삕�깉�뜝�룞�삕

	public String updateUser(UserVO vo);//�쉶�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕	

	public String pwFind(UserVO vo);//�뜝�룞�삕艅섇뜝�떕占� 李얍뜝�룞�삕

	public UserVO getUser(UserVO vo);// �뜝�룞�삕�뜝�룞�삕�뜝�떬諭꾩삕 李얍뜝�룞�삕

	public String changePw(UserVO vo);//�쉶�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕
	
	public boolean checkId(UserVO vo); //중복체크
}
