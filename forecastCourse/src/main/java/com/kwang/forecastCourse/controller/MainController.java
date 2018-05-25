package com.kwang.forecastCourse.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kwang.forecastCourse.service.HttpRequestService;
import com.kwang.forecastCourse.service.MainService;
import com.kwang.forecastCourse.service.TestService;

@Controller
@RequestMapping("/main/*")
public class MainController {
	@Inject
	HttpRequestService httpRequestService;
	@Inject
	TestService testService;
	@Inject
	MainService mainService;
	
	// 로깅을 위한 변수
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// main home index
	@RequestMapping("index.do")
    public ModelAndView mainIndex() throws Exception{
		ModelAndView mav = new ModelAndView();
		// MainService를 통해 날씨정보, 미세먼지 정보 호출하여 해당 jsp화면으로 전달
    	mav.addObject("map", mainService.getForecastInfo());
    	mav.addObject("dustMap", mainService.getDustInfo());
    	mav.setViewName("map/main");
    	return mav;
	}
	
    
}
