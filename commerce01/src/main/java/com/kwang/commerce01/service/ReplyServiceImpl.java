package com.kwang.commerce01.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.kwang.commerce01.model.dao.ReplyDAO;
import com.kwang.commerce01.model.dto.ReplyVO;


@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	ReplyDAO replyDao;
	
	@Override
	public List<ReplyVO> list(Integer bno,  int start, int end, HttpSession session) {
		// TODO Auto-generated method stub
		List<ReplyVO> items = replyDao.list(bno,start,end);
		
		//���ǿ��� ���� ����� id�� ����
		String userId = (String) session.getAttribute("userId");
		for(ReplyVO vo : items){
			//��� ��� �� ��� ����� ���� ���
			if("y".equals(vo.getSecretReply()) ){
				if(userId==null){
					vo.setReplytext("��� ����Դϴ�.");
				}else{
					String writer = vo.getWriter();
					String replyer = vo.getReplyer();
					// �α����� ����ڰ� �Խñ� �ۼ��ڵ� �ƴϰ� ��� �ۼ��ڵ� �ƴҰ�� ��д�۷� ó��
					if(!(userId.equals(writer) || userId.equals(replyer))){
						vo.setReplytext("��� ����Դϴ�.");
					}
				}
			}
		}
		return items;
	}


	@Override
	public void create(ReplyVO vo) {
		// TODO Auto-generated method stub
		replyDao.create(vo);
	}

	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer rno) {
		// TODO Auto-generated method stub
		replyDao.delete(rno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return replyDao.count(bno);
	}
}
