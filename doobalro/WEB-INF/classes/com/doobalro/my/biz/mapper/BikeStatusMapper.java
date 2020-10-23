package com.doobalro.my.biz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.doobalro.my.biz.server.vo.BikeStatusVO;

public interface BikeStatusMapper {
	@Select("select * from BIKE_STATUS")
	public List<BikeStatusVO> getAllData();
}
