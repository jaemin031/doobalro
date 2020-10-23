package com.doobalro.my.biz.server.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doobalro.my.biz.mapper.BoardMapper;
import com.doobalro.my.biz.mapper.ReplyMapper;
import com.doobalro.my.biz.mapper.UserMapper;
import com.doobalro.my.biz.server.vo.BoardVO;
import com.doobalro.my.biz.server.vo.ReplyVO;
import com.doobalro.my.biz.server.vo.UserVO;

@Component("userDAO")
public class UserDAO implements UserDaoFrame{
	@Autowired
	SqlSession mybatis;
	UserMapper mapper;
	
	public  UserDAO(){}
	public UserDAO (SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	
	public SqlSession getMybatis() {
		return mybatis;
	}
	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	public UserMapper getMapper() {
		return mapper;
	}
	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}
	
	@PostConstruct
    public void init() {
    	mapper = mybatis.getMapper(UserMapper.class);
    }
	
	
	@Override
	public String login(UserVO vo) {
		List<UserVO> li = this.getAllUser();
		Iterator<UserVO> iter = li.iterator();
		boolean flag = false;
		
		while(iter.hasNext()) {
			UserVO uv = iter.next();
			if(uv.getUserPhone().equals(vo.getUserPhone())&&uv.getUserPw().equals(vo.getUserPw())) {
				flag = true;
			}
		}
		
		if(flag) {
			mapper.login(vo);
			return "로그인 성공";
		}
		
		return "로그인 실패";
	}
	
	@Override
	public String addUser(UserVO vo) {
		List<UserVO> li = this.getAllUser();
		Iterator<UserVO> iter = li.iterator();
		boolean flag1 = false;
		boolean flag2 = false;
		UserVO uvo;
		while(iter.hasNext()) {
			uvo = iter.next();
			if(uvo.getUserPhone().equals(vo.getUserPhone())) {
				flag1 = true;
				break;
			}
			if(uvo.getUserName().equals(vo.getUserName())) {
				flag2 = true;
				break;
			}
		}
		if(flag1) {
			return "가입되어 있는 휴대폰 번호입니다";
		}else if(flag2) {
			return "가입되어 있는 닉네임입니다";
		}else {
			mapper.addUser(vo);
			return "가입 성공";
		}
	}
	@Override
	public String deleteUser(UserVO vo) {
		BoardMapper bmapper = mybatis.getMapper(BoardMapper.class);
		ReplyMapper rmapper = mybatis.getMapper(ReplyMapper.class);
		
		List<ReplyVO> li1 = rmapper.synchroGetReply(vo.getUserName());
		Iterator<ReplyVO> iter1 = li1.iterator();
		ReplyVO rvo;
		while(iter1.hasNext()) {
			rvo = iter1.next();
			bmapper.synchroRcnt(rvo.getBoardNum());
		}
		
		rmapper.synchroDeleteUserToReply(vo.getUserName());	//자신이 쓴 댓글 전부 삭제
		List<BoardVO> li2 = bmapper.sychroGetBoards(vo.getUserNum());
		Iterator<BoardVO> iter2 = li2.iterator();
		
		BoardVO bvo;
		while(iter2.hasNext()) { //자신이 쓴 게시판들의 댓글 전부 삭제
			bvo = iter2.next();
			rmapper.synchroDeleteBoardToReply(bvo.getBoardNum());
		}
		
		bmapper.synchroDeleteBoard(vo.getUserNum()); //자신이 쓴 게시판 삭제
		mapper.deleteUser(vo);
		return "�쑀�� �깉�눜 �꽦怨�";
	}
	
	
	@Override
	public String updateUser(UserVO vo) {
		if(mapper.updateUser(vo)==1) {
			return "蹂�寃� �꽦怨�";
		}		
		return "�쑕���룿 踰덊샇 以묐났 �삉�뒗 �씠由� 以묐났�쑝濡� �씤�븳 蹂�寃� �떎�뙣";
		
		
	}
	
	@Override
	public String pwFind(UserVO vo) {
		String result = mapper.pwFind(vo);
		if(result.isEmpty()) {
			return "�빐�떦 �궗�빆 �쑀�� �뾾�쓬";
		}
		return result;
	}
	
	@Override
	public UserVO getUser(UserVO vo) {
		return mapper.getUser(vo);
	}
	
	public List<UserVO> getAllUser(){
		return mapper.getAllUser();
	}
	@Override
	public String changePw(UserVO vo) {
		if(mapper.changePw(vo)==1) {
			return "蹂�寃� �셿猷�";
		}		
		return "�쑕���룿踰덊샇 �삉�뒗 �깮�뀈�썡�씪 遺덉씪移�";
	}
	@Override
	public boolean checkId(UserVO vo) {
		
		String user = mapper.idcheck(vo);
		if(user != null) {
			return false;
	}
		else {
			return true;
		}
	
	}	
}
