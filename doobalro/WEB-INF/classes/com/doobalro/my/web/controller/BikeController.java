package com.doobalro.my.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doobalro.my.biz.server.service.BikeService;
import com.doobalro.my.biz.server.service.BikeStatusService;
import com.doobalro.my.biz.server.vo.BikeStatusVO;

@Controller
public class BikeController {
	
	@Resource(name="BikeService")
	BikeService BikeService;
	
	@Resource(name = "BikeStatusService")
	BikeStatusService BikeStatusService;
	
	@RequestMapping("/creAccident.do") //로그인 페이지로
	public String Accident(HttpServletRequest req){
		BikeService.Accident();
		return "redirect:AccidentTime.do";
	}
	
	@RequestMapping("/AccidentTime.do")
	public String AccidentTime() {
		return "AccidentTime";
	}
	@RequestMapping("/AccidentLoc.do")
	public String AccidentLoc(){
		return "AccidentLoc";
	}
	
	@RequestMapping(value = "Bike.do", method = RequestMethod.GET)
	public String bikeListGo(HttpServletRequest req) {//유저 체크 필요 없을 시 로그인폼으로~
		if(req.getSession().getAttribute("user") == null) {
			return "login";
		}else {
			return "bikeStatus";
		}
	}

	  @RequestMapping(value = "Bike.do", method = RequestMethod.POST)
	   public ModelAndView bikeList() {
	      List<BikeStatusVO> list = BikeStatusService.getAllData();
	      for (int i = 0; i < list.size(); i++) {
	         String info = "<div id='content'><h3 id='firstHeading' class='firstHeading'>" + list.get(i).getStation_name()
	               + "</h3><div id='bodyContent'>" + "<p><b>거치대수 : "+list.get(i).getTotal_bike()+"</b><br><b>대여가능 자전거 : </b>" + list.get(i).getAvailable_bike() + "<br>"
	               +"</p></div></div>";
	         list.get(i).setInfo(info);
	      }
	      HashMap<String, Object> map = new HashMap<>();
	      map.put("list", list);
	      return new ModelAndView("jsonView", map);
	   }
	
	
	
}
