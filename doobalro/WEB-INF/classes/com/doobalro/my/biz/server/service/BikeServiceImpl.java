package com.doobalro.my.biz.server.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.doobalro.my.biz.server.dao.BikeDAO;

@Service("BikeService")
public class BikeServiceImpl implements BikeService {
	@Resource(name = "BikeDAO")
	BikeDAO dao;
	
	@Override
	public void Accident(){
		dao.Accident();
	}
}
