package com.doobalro.my.biz.server.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.doobalro.my.biz.server.dao.BikeStatusDAO;
import com.doobalro.my.biz.server.vo.BikeStatusVO;

@Service("BikeStatusService")
public class BikeStatusServiceImpl implements BikeStatusService {

	@Resource(name = "bikeStatusDAO")
	BikeStatusDAO dao;
	
	@Override
	public List<BikeStatusVO> getAllData() {
		return dao.getAllData();
	}

}
