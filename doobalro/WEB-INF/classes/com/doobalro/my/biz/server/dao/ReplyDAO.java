package com.doobalro.my.biz.server.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doobalro.my.biz.mapper.ReplyMapper;
import com.doobalro.my.biz.server.vo.ReplyVO;

@Component("ReplyDAO")
public class ReplyDAO implements ReplyDaoFrame{
	@Autowired
	SqlSession mybatis;
	ReplyMapper mapper;
	
	public  ReplyDAO(){}
	public ReplyDAO (SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	
	public SqlSession getMybatis() {
		return mybatis;
	}
	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	public ReplyMapper getMapper() {
		return mapper;
	}
	public void setMapper(ReplyMapper mapper) {
		this.mapper = mapper;
	}
	
	@PostConstruct
    public void init() {
    	mapper = mybatis.getMapper(ReplyMapper.class);
    }
	
	@Override
	public void addReply(ReplyVO vo) {
		this.RcntUpReply(vo);
		mapper.addReply(vo);
	}
	@Override
	public void deleteReply(ReplyVO vo) {
		//�쑀��泥댄겕�뒗 而⑦듃濡ㅻ윭 �뵶�뿉�꽌
		mapper.deleteReply(vo);
	}
	@Override
	public int updateReply(ReplyVO vo) {
		//�쑀��泥댄겕�뒗 而⑦듃濡ㅻ윭 �뵶�뿉�꽌
		return mapper.updateReply(vo);
	}
	@Override
	public ReplyVO getReply(int replyNum) {
		return mapper.getReply(replyNum);
	}
	@Override
	public List<ReplyVO> getAllReply(int boardnum) {
		return mapper.getAllReply(boardnum);
	}
	@Override
	public void RcntUpReply(ReplyVO vo) {
		mapper.RcntUpReply(vo);
	}
	
	@Override
	public void synchroReply(String afterName, String beforeName) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("afterName", afterName);
		map.put("beforeName", beforeName);
		mapper.synchroReply(map);
	}
	
}
