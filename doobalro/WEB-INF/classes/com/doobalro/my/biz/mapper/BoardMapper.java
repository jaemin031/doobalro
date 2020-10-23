package com.doobalro.my.biz.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.doobalro.my.biz.server.vo.BoardVO;


public interface BoardMapper {
	@Insert("insert into Boards (boardNum,userNum,boardWriter,boardTitle,boardContent,boardDate) "
			+ "values((select nvl(max(boardNum),0)+1 from Boards),#{userNum},#{boardWriter},#{boardTitle},#{boardContent},#{boardDate})")
	public void addBoard(BoardVO vo);
	
	@Delete("delete from Boards where boardNum = #{boardNum}")
	public void deleteBoard(int boardNum);
	
	@Update("update boards set boardTitle= #{boardTitle}, boardContent = #{boardContent}, boardDate = #{boardDate}, boardRCnt = #{boardRCnt} where boardNum = #{boardNum}")
	public void updateBoard(BoardVO vo);
	
	@Select("select * from boards where ${condition} like '%'|| #{keyword} ||'%'")
	public List<BoardVO> searchBoard(HashMap<String, String> map);

	@Select("select * from boards where boardNum = #{boardNum}")
	public BoardVO getBoard(int boardNum);
	
	@Select("select * from boards order by boardNum desc")
	public List<BoardVO> getAllBoard();
	
	@Update("update boards set boardCnt= boardCnt+1 where boardNum = #{boardNum}")
	public void cntUpBoard(BoardVO vo);
	
	@Update("update boards set boardRCnt = boardRCnt-1 where boardNum = #{boardNum}")
	public void synchroRcnt(int boardNum);
	
	@Update("update boards set boardWriter = #{boardWriter} where userNum = #{userNum}")
	public void synchroBoard(BoardVO vo);
	
	@Select("select * from boards where userNum = #{userNum}")
	public List<BoardVO> sychroGetBoards(int userNum);
	
	@Delete("delete from boards where userNum = #{userNum}")
	public void synchroDeleteBoard(int userNum);
}
