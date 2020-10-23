package com.doobalro.my.biz.server.dao;

import java.util.List;

import com.doobalro.my.biz.server.vo.WeatherVO;

public interface WeatherDaoFrame {
	public List<WeatherVO> getAllData();
	public void AirQuality();
}
