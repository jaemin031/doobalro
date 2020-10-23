package com.doobalro.my.biz.server.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doobalro.my.biz.mapper.BoardMapper;
import com.doobalro.my.biz.mapper.ReplyMapper;
import com.doobalro.my.biz.server.vo.BoardVO;

@Component("boardDAO")
public class BoardDAO implements BoardDaoFrame{
	@Autowired
	SqlSession mybatis;
	BoardMapper mapper;
	
	public  BoardDAO(){}
	public BoardDAO (SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	
	public SqlSession getMybatis() {
		return mybatis;
	}
	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	public BoardMapper getMapper() {
		return mapper;
	}
	public void setMapper(BoardMapper mapper) {
		this.mapper = mapper;
	}
	
	@PostConstruct
    public void init() {
    	mapper = mybatis.getMapper(BoardMapper.class);
    }
	@Override
	public void addBoard(BoardVO vo) {
		System.out.println(vo);
		mapper.addBoard(vo);
		
	}
	@Override
	public void deleteBoard(int boardNum) {
		ReplyMapper rmapper = mybatis.getMapper(ReplyMapper.class);
		rmapper.synchroDeleteBoardToReply(boardNum);
		mapper.deleteBoard(boardNum);
	}
	@Override
	public void updateBoard(BoardVO vo) {
		//유저체크는 컨트롤러 딴에서
		mapper.updateBoard(vo);
	}
	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		return mapper.searchBoard(map);
	}
	@Override
	public BoardVO getBoard(int boardNum) {
		BoardVO vo = new BoardVO();
		vo.setBoardNum(boardNum);
		this.cntUpBoard(vo);
		return mapper.getBoard(boardNum);
	}
	@Override
	public List<BoardVO> getAllBoard() {
		return mapper.getAllBoard();
	}
	@Override
	public void cntUpBoard(BoardVO vo) {
		mapper.cntUpBoard(vo);
	}
	
	@Override
	public void synchroBoard(BoardVO vo) {
		mapper.synchroBoard(vo);
	}
	
	
}
