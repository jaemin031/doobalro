package com.doobalro.my.biz.server.service;

import java.util.List;

import com.doobalro.my.biz.server.vo.WeatherVO;

public interface WeatherService {
	public List<WeatherVO> getAllData();
	public void AirQuality();
}
