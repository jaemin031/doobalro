package com.doobalro.my.biz.server.service;

import java.util.List;
import com.doobalro.my.biz.server.vo.BoardVO;

public interface BoardService {

	public void addBoard(BoardVO vo); //�Խù� �ۼ�
	
	public void deleteBoard(int boardNum);//�Խù� ����
	
	public void updateBoard(BoardVO vo);//�Խù� ����	

	public List<BoardVO> searchBoard(String condition, String keyword);//�Խù� �˻�

	public BoardVO getBoard(int boardNum); //�Խù� ��ȣ ã��
	
	public List<BoardVO> getAllBoard();	//�Խù� ����Ʈ �̱�
	
	public void synchroBoard(BoardVO vo);
}


