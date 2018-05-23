package com.kwang.commerce01.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kwang.commerce01.model.dto.SeatVO;
import com.kwang.commerce01.service.SeatService;

@Controller
@RequestMapping("/seat/*")
public class SeatController {
	
	@Inject
	SeatService seatService;

	
	@RequestMapping("seatList.do")
	public ModelAndView seatList(@RequestParam(defaultValue="") String tno,
								HttpServletResponse response,
									HttpSession session) throws Exception{
		 // ���ڵ� ����
        //int count = CartService.countArticle(searchOption, keyword);
        
        SeatVO list = seatService.list(tno); //����
        
        // �����͸� �ʿ� ����
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list); // list
        //map.put("count", count); // ���ڵ��� ����
        
        // ModelAndView - �𵨰� ��
        ModelAndView mav = new ModelAndView();
        mav.addObject("map", map); // �ʿ� ����� �����͸� mav�� ����

        mav.setViewName("seat/list"); // �並 list.jsp�� ����
        return mav; // list.jsp�� List�� ���޵ȴ�.
	}
	

}
