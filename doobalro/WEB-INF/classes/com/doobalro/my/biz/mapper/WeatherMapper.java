package com.doobalro.my.biz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.doobalro.my.biz.server.vo.WeatherVO;

public interface WeatherMapper {
	@Select("select * from weather w, location_w loc where w.name = loc.location")
	public List<WeatherVO> getAllData();
}
