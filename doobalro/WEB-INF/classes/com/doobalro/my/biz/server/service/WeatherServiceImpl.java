package com.doobalro.my.biz.server.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.doobalro.my.biz.server.dao.WeatherDAO;
import com.doobalro.my.biz.server.vo.WeatherVO;

@Service("WeatherService")
public class WeatherServiceImpl implements WeatherService {
	
	@Resource(name = "weatherDAO")
	WeatherDAO dao;

	@Override
	public List<WeatherVO> getAllData() {
		return dao.getAllData();
	}

	@Override
	public void AirQuality() {
		dao.AirQuality();
	}
}
