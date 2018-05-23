package com.kwang.commerce01.model.dto;

import java.util.Date;

public class ReplyVO {
	private Integer rno;        // ��� ��ȣ
    private Integer bno;        // �Խñ� ��ȣ
    private String replytext;    // ��� ����
    private String replyer;        // ��� �ۼ���
    private String userName;    // ��� �ۼ����� �̸�(ȸ���� �̸�)
    private Date regdate;        // ��� �ۼ�����
    private String secretReply;  // +��� ���� ���� �߰�
    private String writer;		// +�Խñ��� �ۼ��� �߰�

	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	public String getSecretReply() {
		return secretReply;
	}
	public void setSecretReply(String secretReply) {
		this.secretReply = secretReply;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", bno=" + bno + ", replytext=" + replytext + ", replyer=" + replyer
				+ ", userName=" + userName + ", regdate=" + regdate + ", secretReply=" + secretReply + ", writer="
				+ writer + "]";
	}
	
	
	
	
}
