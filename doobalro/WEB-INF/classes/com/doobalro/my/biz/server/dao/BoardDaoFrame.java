package com.doobalro.my.biz.server.dao;

import java.util.HashMap;
import java.util.List;

import com.doobalro.my.biz.server.vo.BoardVO;

public interface BoardDaoFrame {
	public void addBoard(BoardVO vo);
	public void deleteBoard(int boardNum);
	public void updateBoard(BoardVO vo);
	public List<BoardVO> searchBoard(String condition, String keyword);
	public BoardVO getBoard(int boardNum);
	public List<BoardVO> getAllBoard();
	public void cntUpBoard(BoardVO vo);
	public void synchroBoard(BoardVO vo);
}
