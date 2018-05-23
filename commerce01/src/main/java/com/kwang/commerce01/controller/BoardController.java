package com.kwang.commerce01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kwang.commerce01.model.dto.BoardVO;
import com.kwang.commerce01.service.BoardPager;
import com.kwang.commerce01.service.BoardService;
import com.kwang.commerce01.service.ReplyService;


@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Inject
	BoardService boardService;
	
	@Inject // ReplyService ����(ReplyService�� ����� ������ ���ϴ� �޼��� ȣ���ϱ� ����)
    ReplyService replyService;
	
	// 01. �Խñ� ���
    @RequestMapping("list.do")
 // @RequestParam(defaultValue="") ==> �⺻�� �Ҵ�
    public ModelAndView list(@RequestParam(defaultValue="title") String searchOption,
    						@RequestParam(defaultValue="") String keyword,
    						@RequestParam(defaultValue="1") int curPage) throws Exception{
        
        // ���ڵ� ����
        int count = boardService.countArticle(searchOption, keyword);
        
        // ������ ������ ���� ó��
        BoardPager boardPager = new BoardPager(count,curPage);
        int start = boardPager.getPageBegin();
        int end = boardPager.getPageEnd();
        
        List<BoardVO> list = boardService.listAll(start,end,searchOption, keyword);
        
        
        // �����͸� �ʿ� ����
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list); // list
        map.put("count", count); // ���ڵ��� ����
        map.put("searchOption", searchOption); // �˻��ɼ�
        map.put("keyword", keyword); // �˻�Ű����
        map.put("boardPager", boardPager);
        
        // ModelAndView - �𵨰� ��
        ModelAndView mav = new ModelAndView();
        mav.addObject("map", map); // �ʿ� ����� �����͸� mav�� ����

        mav.setViewName("board/list"); // �並 list.jsp�� ����
        return mav; // list.jsp�� List�� ���޵ȴ�.
    }
    
    // 02_01. �Խñ� �ۼ�ȭ��
    // @RequestMapping("board/write.do")
    // value="", method="���۹��"
    @RequestMapping(value="write.do", method=RequestMethod.GET)
    public String write(){
        return "board/write"; // write.jsp�� �̵�
    }

    // 02_02. �Խñ� �ۼ�ó��
    @RequestMapping(value="insert.do", method=RequestMethod.POST)
    public String insert(@ModelAttribute BoardVO vo, HttpSession session) throws Exception{
    	// session�� ����� userId�� writer�� ����
        String writer = (String) session.getAttribute("userId");
        // vo�� writer�� ����
        vo.setWriter(writer);
    	boardService.create(vo);
        return "redirect:list.do";
    }

    
    // 03. �Խñ� �󼼳��� ��ȸ, �Խñ� ��ȸ�� ���� ó��
    // @RequestParam : get/post������� ���޵� ���� 1��
    // HttpSession ���ǰ�ü
    @RequestMapping(value="view.do", method=RequestMethod.GET)
    public ModelAndView view(@RequestParam int bno, HttpSession session,
    			@RequestParam(defaultValue="title") String searchOption,
				@RequestParam(defaultValue="") String keyword,
				@RequestParam(defaultValue="1") int curPage) throws Exception{
        // ��ȸ�� ���� ó��
        boardService.increaseViewcnt(bno, session);
        // ��(������)+��(ȭ��)�� �Բ� �����ϴ� ��ü
        ModelAndView mav = new ModelAndView();
        
        // �����͸� �ʿ� ����
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("searchOption", searchOption); // �˻��ɼ�
        map.put("keyword", keyword); // �˻�Ű����
        map.put("curPage", curPage);
        //map.put("count",replyService.count(bno));
        
        // ���� �̸�
        mav.setViewName("board/view");
        // �信 ������ ������
        mav.addObject("map", map); // �ʿ� ����� �����͸� mav�� ����
        mav.addObject("dto", boardService.read(bno));
        mav.addObject("count", replyService.count(bno));
        return mav;
    }
    
    // 04. �Խñ� ����
    // ������ �Է��� ������� @ModelAttribute BoardVO vo�� ���޵�
    @RequestMapping(value="update.do", method=RequestMethod.POST)
    public String update(@ModelAttribute BoardVO vo) throws Exception{
    	
    	System.out.println("update VO :: " + vo.toString());
    	
        boardService.update(vo);
        return "redirect:list.do";
    }
    

    // 05. �Խñ� ����
    @RequestMapping("delete.do")
    public String delete(@RequestParam int bno) throws Exception{
        boardService.delete(bno);
        return "redirect:list.do";
    }




}
