package com.doobalro.my.biz.server.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doobalro.my.biz.mapper.WeatherMapper;
import com.doobalro.my.biz.server.vo.WeatherVO;

@Component("weatherDAO")
public class WeatherDAO implements WeatherDaoFrame{

	@Autowired
	SqlSession mybatis;
	WeatherMapper mapper;
	
	public WeatherDAO() {
	}
	public WeatherDAO(SqlSession mybatis, WeatherMapper mapper) {
		this.mybatis = mybatis;
		this.mapper = mapper;
	}

	public SqlSession getMybatis() {
		return mybatis;
	}
	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	public WeatherMapper getMapper() {
		return mapper;
	}
	public void setMapper(WeatherMapper mapper) {
		this.mapper = mapper;
	}
	
	@PostConstruct
    public void init() {
    	mapper = mybatis.getMapper(WeatherMapper.class);
    }
	
	@Override
	public List<WeatherVO> getAllData() {
		return mapper.getAllData();
	}
	@Override
	public void AirQuality() {
		RConnection con = null;
	      try {
	        con = new RConnection("127.0.0.1", 4321);
	        con.eval("library(Kormaps)");
	        con.eval("library(dplyr)");
	        con.eval("library(ggmap)");
	        con.eval("library(maptools)");
	        con.eval("library(RColorBrewer)");
	        con.eval("library(scales)");
	        con.eval("library(ggplot2)");
	        con.eval("temp<-read.csv(file='C:\\\\file\\\\Pmatter.csv',header=FALSE,stringsAsFactors=FALSE,fileEncoding = 'UTF-8')");
	        con.eval("temp[,c(2,14)]<-temp[,c(14,2)]");
	        con.eval("temp[,c(3,15)]<-temp[,c(15,3)]");
	        con.eval("temp[,c(4,14)]<-temp[,c(14,4)]");
	        con.eval("temp[,c(5,11)]<-temp[,c(11,5)]");
	        con.eval("temp[,c(6,7)]<-temp[,c(7,6)]");
	        con.eval("temp[,c(7,16)]<-temp[,c(16,7)]");
	        con.eval("temp[,c(8,14)]<-temp[,c(14,8)]");
	        con.eval("temp[,c(9,11)]<-temp[,c(11,9)]");
	        con.eval("temp[,c(10,11)]<-temp[,c(11,10)]");
	        con.eval("temp[,c(14,17)]<-temp[,c(17,14)]");
	        con.eval("temp[,c(15,18)]<-temp[,c(18,15)]");
	        con.eval("temp[,c(16,19)]<-temp[,c(19,16)]");
	        con.eval("temp<-temp[,c(1:16)]");
	        con.eval("t1<-data.frame(data=t(temp))");
	        con.eval("rownames(t1)<-NULL");
	        con.eval("kor.dat <- data.frame(NAME_1=korpopmap1$name_eng, id=korpopmap1$id)");
	        con.eval("kor.dat <- cbind(kor.dat, t1)");
	        con.eval("korea.shp.f <- fortify(korpopmap1, region = 'id')");
	        con.eval("merge.shp.coef<-merge(korea.shp.f, kor.dat, by='id', all.x=TRUE)");
	        con.eval("t2<-merge.shp.coef[order(merge.shp.coef$order), ] ");
	        con.eval("t2$data<-as.factor(t2$data)");
	        con.eval("colnames(t2)[which(names(t2) == 'data')] <- '미세먼지'");
	        con.eval("rm(korea)");
	        con.eval("tryCatch(korea <- qmap('South Korea', zoom=7),error = function(e) {rm(korea);korea <- qmap('South Korea', zoom=7)},finally = NULL)");
	        //con.eval("jpeg('C:\\\\Users\\\\student\\\\Desktop\\\\프로젝트\\\\Doobalro\\\\src\\\\main\\\\webapp\\\\image\\\\AirQuality.jpg',width=1000,height=1000,units='px')");
	        con.eval("pic<-korea + geom_polygon(aes(x=long,y=lat, group=group,  fill=미세먼지),data=t2, color='black')+scale_fill_brewer(palette='Set1')");
	        con.eval("ggsave('C:\\\\Users\\\\student\\\\Desktop\\\\프로젝트\\\\Doobalro\\\\src\\\\main\\\\webapp\\\\image\\\\AirQuality.jpg',pic)");
	      } catch (RserveException e) {
	         e.printStackTrace();
	      } finally{
	         if(con!=null && con.isConnected())
	            con.close();
	      }
	}

}
