package com.doobalro.my.biz.server.dao;

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Component;

@Component("BikeDAO")
public class BikeDAO implements BikeDaoFrame{
	@Override
	public void Accident() {
	      RConnection con = null;
	      try {
	        con = new RConnection("127.0.0.1", 4321);

			con.eval("library('plotrix')");
			con.eval("library(dplyr)");
			con.eval("col_set<-rainbow(12)");
			con.eval("accident<-read.csv(file='C:\\\\file\\\\BikeAccident.csv')");
			con.eval("t1<-accident[,c(5:16)]");
			con.eval("t1<-apply(t1,2,sum,na.rm=TRUE)");
			con.eval("t1<-as.numeric(t1)");
			con.eval("name<-c('00 ~ 02시','02 ~ 04시','04 ~ 06시','06 ~ 08시','08 ~ 10시','10 ~ 12시','12 ~ 14시','14 ~ 16시','16 ~ 18시','18 ~ 20시','20 ~ 22시','22 ~ 24시')");
			con.eval("round_t1<-round(t1/sum(t1)*100,1)");
			con.eval("t_label <-paste(round_t1,'%')");
			con.eval("r1<-c('#FF0000FF', '#FF8000FF', '#FFFF00FF', '#80FF00FF', '#00FF00FF', '#00FF80FF')");
			con.eval("r2<-c( '#00FFFFFF', '#0080FFFF', '#0000FFFF', '#8000FFFF', '#FF00FFFF', '#FF0080FF')");
			con.eval("jpeg('C:\\\\Users\\\\student\\\\Desktop\\\\프로젝트\\\\Doobalro\\\\src\\\\main\\\\webapp\\\\image\\\\time01_accident.jpg',width=700,height=600,units='px')");
			con.eval("pie3D(t1,,col=rainbow(length(t1)),cex=0.5,labels=t_label,explode=0.1)");
			con.eval("legend(-0.9,-0.5,name[c(1:6)],cex=1.1,fill=r1)");
			con.eval("legend(0.4,-0.5,name[c(7:12)],cex=1.1,fill=r2)");
			con.eval("dev.off()");
			con.eval("jpeg('C:\\\\Users\\\\student\\\\Desktop\\\\프로젝트\\\\Doobalro\\\\src\\\\main\\\\webapp\\\\image\\\\time02_accident.jpg',width=1000,height=1000,units='px')");
			con.eval("barplot(t1,main='시간대별 사고',xlab='시간',ylab='사고 발생수',names.arg=name,col=rainbow(length(t1)))");
			con.eval("legend('topleft',name,cex=2,fill=rainbow(length(t1)))");
			con.eval("dev.off()");
			con.eval("t2<-apply(accident[,c(5:16)],1,sum,na.rm=TRUE)");
			con.eval("loc<-accident[,c(3)]");
			con.eval("t2<-data.frame(t2)");
			con.eval("loc<-data.frame(loc)");
			con.eval("t2<-bind_cols(loc,t2)");
			con.eval("t2<-aggregate(t2 ~ loc, data = t2, sum)");
			con.eval("t3<-as.numeric(t2$t2)");
			con.eval("t3_name<-t2$loc");
			con.eval("t3_name<-as.character(t3_name)");
			con.eval("jpeg('C:\\\\Users\\\\student\\\\Desktop\\\\프로젝트\\\\Doobalro\\\\src\\\\main\\\\webapp\\\\image\\\\loc_accident.jpg',width=1000,height=1000,units='px')");
			con.eval("barplot(t3,main='지역별 사고',xlab='지역',ylab='사고 발생수',names.arg=as.character(t2$loc),col=rainbow(length(t3)))");
			con.eval("legend('topright',t3_name,cex=2,fill=rainbow(length(t3_name)))");
			con.eval("dev.off()");
	      } catch (RserveException e) {
	         e.printStackTrace();
	      } finally{
	         if(con!=null && con.isConnected())
	            con.close();
	      }
	}
}
