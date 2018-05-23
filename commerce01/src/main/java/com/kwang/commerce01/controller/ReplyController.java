package com.kwang.commerce01.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kwang.commerce01.model.dto.ReplyVO;
import com.kwang.commerce01.service.ReplyPager;
import com.kwang.commerce01.service.ReplyService;


@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	@Inject
	ReplyService replyService;
	
	@RequestMapping("insert.do")
	@ResponseBody
	public HashMap<String, String> insert(@ModelAttribute ReplyVO vo, HttpSession session){
		String userId = (String) session.getAttribute("userId");
		vo.setReplyer(userId);
		replyService.create(vo);
		
		System.out.println("reply insert Success!!");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("code", "1");
		map.put("msg", "����Ͽ����ϴ�.");
		
		return map;
	}
	
	@RequestMapping("delete.do")
	@ResponseBody
	public HashMap<String, String> delete(@ModelAttribute ReplyVO vo, HttpSession session){
		//String userId = (String) session.getAttribute("userId");
		System.out.println("ReplyController delete() rno = " + vo.getRno());
		//vo.setReplyer(userId);
		replyService.delete(vo.getRno());
		
		System.out.println("reply delete Success!!");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("code", "1");
		map.put("msg", "�����Ͽ����ϴ�.");
		
		return map;
	}
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam int bno,
							@RequestParam(defaultValue="1") int curPage,
							ModelAndView mav,
							HttpSession session){
		
		//System.out.println("              ReplyController list() bno : " + bno);
		
		// ** ����¡ó��
		int count = replyService.count(bno);
		
		if(count<1){
			return mav;
		}
		
		ReplyPager replyPager = new ReplyPager(count,curPage);
		int start = replyPager.getPageBegin();
		int end = replyPager.getPageEnd();
		List<ReplyVO> list = replyService.list(bno, start, end, session);
		
		
		
		mav.setViewName("board/replyList");
		mav.addObject("list", list);
		mav.addObject("replyPager", replyPager);
		
		return mav;
	}
	
	// ��� ���(@RestController Json������� ó�� : �����͸� ����)
    /*
     * @RequestMapping("listJson.do")
    @ResponseBody // ���ϵ����͸� json���� ��ȯ(��������)
    public List<ReplyVO> listJson(@RequestParam int bno){
        List<ReplyVO> list = replyService.list(bno);
        return list;
    }
    */

}
