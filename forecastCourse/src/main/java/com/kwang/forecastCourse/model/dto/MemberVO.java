package com.kwang.forecastCourse.model.dto;

import java.util.Date;

/*
 * 	id :  사용자 아이디
 * 	pw :  사용자 패스워드
 *  name : 사용자 이름
 *  email : 사용자 이메일
 *  regdate : 회원가입 일자
 *  phone : 사용자 전화번호
 * */
public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date regdate;
	private String phone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", regdate=" + regdate
				+ ", phone=" + phone + "]";
	}
	
	
}
