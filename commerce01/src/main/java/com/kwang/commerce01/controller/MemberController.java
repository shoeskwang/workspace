package com.kwang.commerce01.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kwang.commerce01.model.dto.MemberVO;
import com.kwang.commerce01.service.MemberService;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	// �α��� ���� ����
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    
    @Inject
    MemberService memberService;
    
    @RequestMapping("login.do")
    public String login(){
    	return "member/login";
    }
    
    @RequestMapping("join.do")
    public String join(){
    	return "member/join";
    }
    
    @RequestMapping("insert.do")
    public String insert(@ModelAttribute MemberVO vo){
    	
    	System.out.println("insert.do vo = " + vo);
    	memberService.insert(vo);
    	
    	return "member/login";
    	
    }
    
    @RequestMapping("idCheck.do")
    public void idCheckajax(@RequestParam(defaultValue="") String userId,
    											HttpServletResponse response) throws Exception{
    	
    	String ajaxJson;
		int count = memberService.idCheck(userId);
		
		System.out.println("ID Check count = " + count);
		if(count>0){
			ajaxJson = "{\"result\":\""+"1"+"\"}";
		}else{
			// result 0 �� ����
			ajaxJson= "{\"result\":\""+"0"+"\"}";
		}
		
		try {
	        response.getWriter().print(ajaxJson);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }  
    	
    }
    
    @RequestMapping("loginCheck.do")
    public String loginCheck(@ModelAttribute MemberVO vo, HttpSession session){
    	boolean result = memberService.loginCheck(vo, session);
    	if(result == true){
    		return "redirect:../ticket/list.do";
    	} else{ //�α��� ����
    		return "redirect:loginFail.do";
    	}
    	//return mav;
    }
    
    @RequestMapping("loginFail.do")
    public ModelAndView loginFail(){
    	ModelAndView mav = new ModelAndView();
    	
		mav.setViewName("member/login");
		mav.addObject("msg", "failure");
		
		return mav;
    }
    
    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession session){
    	memberService.logout(session);
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("member/login");
    	mav.addObject("msg", "logout");
    	return mav;
    }
}
