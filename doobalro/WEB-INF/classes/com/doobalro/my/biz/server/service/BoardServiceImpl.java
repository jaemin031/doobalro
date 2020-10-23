package com.doobalro.my.biz.server.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.doobalro.my.biz.server.dao.BoardDAO;
import com.doobalro.my.biz.server.vo.BoardVO;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {
	@Resource(name = "boardDAO")
	BoardDAO dao;
	// BoardDaoFrame dao = new BoardDAO();


	@Override
	public void addBoard(BoardVO vo) {
		dao.addBoard(vo);
	}

	@Override
	public void deleteBoard(int boardNum) {
		dao.deleteBoard(boardNum);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		return dao.searchBoard(condition, keyword);
	}

	@Override
	public BoardVO getBoard(int boardNum) {
		return dao.getBoard(boardNum);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return dao.getAllBoard();
	}

	@Override
	public void synchroBoard(BoardVO vo) {
		dao.synchroBoard(vo);
	}

}
