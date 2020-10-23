package com.doobalro.my.biz.server.dao;

import com.doobalro.my.biz.server.vo.UserVO;

public interface UserDaoFrame {
	public String login(UserVO vo);
	public String addUser(UserVO vo);
	public String deleteUser(UserVO vo);
	public String updateUser(UserVO vo);
	public String pwFind(UserVO vo);
	public UserVO getUser(UserVO vo);
	public String changePw(UserVO vo);
	public boolean checkId(UserVO vo);
}
