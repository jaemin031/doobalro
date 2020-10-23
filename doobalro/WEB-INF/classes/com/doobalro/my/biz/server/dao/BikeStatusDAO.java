package com.doobalro.my.biz.server.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doobalro.my.biz.mapper.BikeStatusMapper;
import com.doobalro.my.biz.server.vo.BikeStatusVO;

@Component("bikeStatusDAO")
public class BikeStatusDAO implements BikeStatusDaoFrame {

	@Autowired
	SqlSession mybatis;
	BikeStatusMapper mapper;
	
	public BikeStatusDAO() {
	}
	
	public BikeStatusDAO(SqlSession mybatis, BikeStatusMapper mapper) {
		this.mybatis = mybatis;
		this.mapper = mapper;
	}
	
	public SqlSession getMybatis() {
		return mybatis;
	}

	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}

	public BikeStatusMapper getMapper() {
		return mapper;
	}

	public void setMapper(BikeStatusMapper mapper) {
		this.mapper = mapper;
	}

	@PostConstruct
    public void init() {
    	mapper = mybatis.getMapper(BikeStatusMapper.class);
    }
	
	@Override
	public List<BikeStatusVO> getAllData() {
		return mapper.getAllData();
	}

}
