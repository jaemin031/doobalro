package com.doobalro.my.web.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doobalro.my.biz.server.service.WeatherService;
import com.doobalro.my.biz.server.vo.WeatherVO;

@Controller
public class WeatherController {
	@Resource(name = "WeatherService")
	WeatherService WeatherService;

	@RequestMapping(value = "weatherList.do", method = RequestMethod.GET)
	public String weatherListGo() {
		return "weather";
	}

	@RequestMapping(value = "weatherList.do", method = RequestMethod.POST)
	public ModelAndView weatherList() {
		List<WeatherVO> list = WeatherService.getAllData();
		for (int i = 0; i < list.size(); i++) {
			String info = "<div id='content'><h3 id='firstHeading' class='firstHeading'>" + list.get(i).getName()
					+ "</h3><div id='bodyContent'>" + "<p><b>대기질 : "+list.get(i).getStatus()+"</b><br><b>기온 : </b>" + list.get(i).getTmp() + "<br>"
					+ "<b>풍속 : </b>" + list.get(i).getWind() + "</p></div></div>";
			list.get(i).setInfo(info);
		}
		HashMap<String, Object> map = new HashMap<>();
//		System.out.println(list);
		map.put("list", list);
		return new ModelAndView("jsonView", map);
	}
	
	@RequestMapping("/AirQuality.do") //로그인 페이지로
	public String Accident(HttpServletRequest req){
		Calendar cday = new GregorianCalendar();
		
		String insertDay = "";
		String insertHour = "";
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		
		int nowHourMinute = Integer.parseInt(sdf.format(cday.getTime()));
		
		if(nowHourMinute<500) {
			sdf = new SimpleDateFormat("yyyy년 MM월 dd일 ");
			cday.add(Calendar.DATE, -1);
			insertDay = sdf.format(cday.getTime());
			insertHour = "23시";
		}else if(nowHourMinute<1100) {
			sdf = new SimpleDateFormat("yyyy년 MM월 dd일 ");
			insertDay = sdf.format(cday.getTime());
			insertHour = "05시";
		}else if(nowHourMinute<1700) {
			sdf = new SimpleDateFormat("yyyy년 MM월 dd일 ");
			insertDay = sdf.format(cday.getTime());
			insertHour = "11시";
		}else if(nowHourMinute<2300) {
			sdf = new SimpleDateFormat("yyyy년 MM월 dd일 ");
			insertDay = sdf.format(cday.getTime());
			insertHour = "17시";
		}else {
			sdf = new SimpleDateFormat("yyyy년 MM월 dd일 ");
			insertDay = sdf.format(cday.getTime());
			insertHour = "23시";
		}
			
		req.setAttribute("nowTime",insertDay + insertHour + " 자료입니다");
		WeatherService.AirQuality();
		return "Airquality";
	}
}
