package com.kwang.commerce01.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.kwang.commerce01.model.dto.ReplyVO;


public interface ReplyService {
	// ��� ���
    public List<ReplyVO> list(Integer bno,  int start, int end, HttpSession session);
    // ��� �Է�
    public void create(ReplyVO vo);
    // ��� ����
    public void update(ReplyVO vo);
    // ��� ����
    public void delete(Integer rno);
    
    // ��� ����
    public int count(int bno);

}
