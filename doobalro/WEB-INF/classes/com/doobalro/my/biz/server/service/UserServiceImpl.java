package com.doobalro.my.biz.server.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.doobalro.my.biz.server.dao.UserDAO;
import com.doobalro.my.biz.server.vo.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDAO")
	UserDAO dao;

	@Override
	public String login(UserVO vo) {
		return dao.login(vo);
	}

	@Override
	public String addUser(UserVO vo) {
		return dao.addUser(vo);
		
	}

	@Override
	public String deleteUser(UserVO vo) {
		return dao.deleteUser(vo);
		
	}

	@Override
	public String updateUser(UserVO vo) {
		return dao.updateUser(vo);
		
	}

	@Override
	public String pwFind(UserVO vo) {
		return dao.pwFind(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

	@Override
	public String changePw(UserVO vo) {
		return dao.changePw(vo);
	}
	@Override
	public boolean checkId(UserVO vo) {
		return dao.checkId(vo);
	}
	

	

}