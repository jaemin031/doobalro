package com.doobalro.my.biz.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.doobalro.my.biz.server.vo.ReplyVO;

public interface ReplyMapper {
	@Insert("insert into replys (replyNum,boardNum,replyContent,replyWriter,replyDate) "
			+ "values((select nvl(max(replyNum),0)+1 from replys),#{boardNum},#{replyContent},#{replyWriter},#{replyDate})")
	public void addReply(ReplyVO vo);
	
	@Delete("delete from replys where replyNum = #{replyNum}")
	public void deleteReply(ReplyVO vo);
	
	@Update("update replys set replyContent= #{replyContent}, replyDate = #{replyDate} where replyNum = #{replyNum}")
	public int updateReply(ReplyVO vo);
	
	@Select("select * from replys where replyNum = #{replyNum}")
	public ReplyVO getReply(int replyNum);
	
	@Select("select * from replys where boardNum = #{boardNum}")
	public List<ReplyVO> getAllReply(int boardnum);
	
	@Update("update boards set boardRCnt= boardRCnt+1 where boardNum = #{boardNum}")
	public void RcntUpReply(ReplyVO vo);
	
	@Update("update replys set replyWriter = #{afterName} where replyWriter = #{befoName}")
	public void synchroReply(HashMap<String, String> map);
	
	@Delete("delete from replys where boardNum = #{boardNum}")
	public void synchroDeleteBoardToReply(int boardnum);
	
	@Delete("delete from replys where replyWriter = #{replyWriter}")
	public void synchroDeleteUserToReply(String replyWriter);
	
	@Select("select *from replys where replyWriter = #{replyWriter}")
	public List<ReplyVO> synchroGetReply(String replyWriter);
	
}
	