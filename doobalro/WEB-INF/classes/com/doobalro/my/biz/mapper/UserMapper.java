package com.doobalro.my.biz.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.doobalro.my.biz.server.vo.UserVO;

public interface UserMapper {
	@Select("select * from users where userPhone = #{userPhone} and userPw = #{userPw}")
	public UserVO login(UserVO vo);
	
	
	@Insert("insert into users (userNum,userName,userPhone,userPw,userBirth) "
			+ "values((select nvl(max(userNum),0)+1 from users),#{userName},#{userPhone},#{userPw},#{userBirth})")
	public void addUser(UserVO vo);
	
	@Delete("delete from users where userNum = #{userNum}")
	public void deleteUser(UserVO vo);
	
	@Update("update users set userPw = #{userPw}, userName = #{userName},userPhone = #{userPhone},userBirth = #{userBirth} where userNum = #{userNum}")
	public int updateUser(UserVO vo);
		
	@Select("select username from users where userPhone = #{userPhone} and userBirth = #{userBirth}")
	public String pwFind(UserVO vo);
	
	@Select("select * from users where userPhone = #{userPhone} and userPw = #{userPw}")
	public UserVO getUser(UserVO vo);

	@Select("SELECT * FROM users")
	public List<UserVO> getAllUser();
	
	@Update("update users set userPw = #{userPw} where username = #{userName}")
	public int changePw(UserVO vo);
	
	@Select("select userPhone from users where userPhone = #{userPhone}")
	public String idcheck(UserVO vo);
}
