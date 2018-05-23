package com.kwang.commerce01.controller;

import java.io.IOException;
import java.util.Arrays;
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
import com.kwang.commerce01.model.dto.OrderVO;
import com.kwang.commerce01.model.dto.SeatVO;
import com.kwang.commerce01.model.dto.TicketVO;
import com.kwang.commerce01.service.OrderService;
import com.kwang.commerce01.service.SeatService;
import com.kwang.commerce01.service.TicketService;

@Controller
@RequestMapping("/order/*")
public class OrderController {
	
	@Inject
	OrderService orderService;
	
	@Inject
	TicketService ticketService;
	
	@Inject
	SeatService seatService;
	
	@RequestMapping("buyTicket.do")
	public ModelAndView buyTicket(@RequestParam(defaultValue="default") String tno ,
									@RequestParam(defaultValue="default") String userId ,
									@RequestParam(defaultValue="1") String amount , 
									@RequestParam(defaultValue="") String temp ,
									@RequestParam(defaultValue="1") String whatday ,
									HttpSession session) throws Exception{
		System.out.println("OrderController buyTicekt()");
		
		
		// �¼� ����
		String selectSeatStr = temp;
		System.out.println(selectSeatStr);
		String[] seats = selectSeatStr.split(",");
		
		String no = tno.replaceAll("t", "");
	 	SeatVO seatVO = seatService.list(no);
	 	
	 	int day = Integer.parseInt(whatday)+1;
	 	seatVO.setWhatday(day); // ��ȸ�� �¼����� ����
	 	
	 	String seat;
	 	
	 	switch (day) {
		case 1:
			seat = seatVO.getDay1();
			break;
		case 2:
			seat = seatVO.getDay2();
			break;
		case 3:
			seat = seatVO.getDay3();
			break;
		case 4:
			seat = seatVO.getDay4();
			break;
		case 5:
			seat = seatVO.getDay5();
			break;
		case 6:
			seat = seatVO.getDay6();
			break;
		case 7:
			seat = seatVO.getDay7();
			break;
		case 8:
			seat = seatVO.getDay8();
			break;
		case 9:
			seat = seatVO.getDay9();
			break;
		case 10:
			seat = seatVO.getDay10();
			break;
		default:
			seat = seatVO.getDay1();
			break;
		}
	 	
	 	System.out.println("seat = " +seat);
	 	if(seat == null){
	 		seat = "00000000000000000000000000000000000000000000000000";
	 	}
	 	System.out.println("seat = " +seat);
	 	char[] arr = seat.toCharArray();
	 	for (String string : seats) {
	 		if(arr[Integer.parseInt(string)]=='0'){
	 			arr[Integer.parseInt(string)]='1';
	 		}else{
	 			System.out.println("Error : ���¼��� �ƴմϴ�.");
	 			// ���� �ѹ�ó�� �ʿ�
	 			
	 			Map<String, Object> map = new HashMap<String, Object>();
	 			map.put("tno", tno); 
	 			map.put("userId", userId);
	 			
	 			// ModelAndView - �𵨰� ��
	 			ModelAndView mav = new ModelAndView();
	 			mav.addObject("map", map); // �ʿ� ����� �����͸� mav�� ����
	 			
	 			mav.setViewName("ticket/failedBuyTicket"); // �並 list.jsp�� ����
	 			return mav; // list.jsp�� List�� ���޵ȴ�.
	 			
	 		}
		}
	 	seat = String.valueOf(arr);
	 	
	 	System.out.println("change seat = " +seat);
	 	
	 	// ���� ó���� �¼� String ����
	 	seatVO.setTempSeat(seat);
	 	
	 	System.out.println("temp seatVO String => " + seatVO.toString());
	 	seatService.update(seatVO);
	 	// �¼� ����
	 	
	 	String reserveSeat="";
	 	for (String string : seats) {
	 		int idx = Integer.parseInt(string);
	 		if((idx/10)==0){
	 			reserveSeat = reserveSeat+",A"+ (idx%10+1);
	 		}else if((idx/10)==1){
	 			reserveSeat = reserveSeat+",B"+ (idx%10+1);
	 		}else if((idx/10)==2){
	 			reserveSeat = reserveSeat+",C"+ (idx%10+1);
	 		}else if((idx/10)==3){
	 			reserveSeat = reserveSeat+",D"+ (idx%10+1);
	 		}else if((idx/10)==4){
	 			reserveSeat = reserveSeat+",E"+ (idx%10+1);
	 		}
	 		
		}
	 	reserveSeat = reserveSeat.substring(1);
	 	
	 	System.out.println("reserveSeat = " + reserveSeat);
		
		OrderVO vo = new OrderVO();
		
		vo.setTno(tno);
		vo.setUserId(userId);
		vo.setAmount(Integer.parseInt(amount));
		vo.setOrderState("1");
		
		System.out.println("vo = " +vo);
		
		orderService.orderAdd(vo);
		
		// �����͸� �ʿ� ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tno", tno); 
		map.put("userId", userId);
		map.put("amount", Integer.parseInt(amount));
		map.put("reserveSeat",reserveSeat);
		// ModelAndView - �𵨰� ��
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map); // �ʿ� ����� �����͸� mav�� ����
		mav.addObject("dto", ticketService.view(tno));
		
		mav.setViewName("ticket/buyTicket"); // �並 list.jsp�� ����
		return mav; // list.jsp�� List�� ���޵ȴ�.
	}
	
	@RequestMapping("orderManagement.do")
	public ModelAndView orderManagement() throws Exception{
		
		List<OrderVO> orderList = orderService.listAll();
		
		// �����͸� �ʿ� ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderList", orderList); 
				
		// ModelAndView - �𵨰� ��
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map); // �ʿ� ����� �����͸� mav�� ����
		
		mav.setViewName("order/orderManagement"); // �並 list.jsp�� ����
		return mav; // list.jsp�� List�� ���޵ȴ�.
	}
	
	@RequestMapping("orderStateUpdate.do")
	public ModelAndView orderStateUpdate(@RequestParam(defaultValue="default") String orderId ,
										@RequestParam(defaultValue="default") String orderState , 
										HttpSession session) throws Exception{
		
		orderService.orderUpdate(orderId, orderState);
		
		List<OrderVO> orderList = orderService.listAll();
		
		// �����͸� �ʿ� ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderList", orderList); 
				
		// ModelAndView - �𵨰� ��
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map); // �ʿ� ����� �����͸� mav�� ����
		
		mav.setViewName("order/orderManagement"); // �並 list.jsp�� ����
		return mav; // list.jsp�� List�� ���޵ȴ�.
	}
}
