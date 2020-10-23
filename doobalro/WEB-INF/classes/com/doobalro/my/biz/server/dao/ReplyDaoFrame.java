package com.doobalro.my.biz.server.dao;

import java.util.HashMap;
import java.util.List;

import com.doobalro.my.biz.server.vo.ReplyVO;

public interface ReplyDaoFrame {
	public void addReply(ReplyVO vo);
	public void deleteReply(ReplyVO vo);
	public int updateReply(ReplyVO vo);
	public ReplyVO getReply(int replyNum);
	public List<ReplyVO> getAllReply(int boardnum);
	public void RcntUpReply(ReplyVO vo);
	public void synchroReply(String afterName, String beforeName);
}
