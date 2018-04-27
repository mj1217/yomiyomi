package com.yedam.app.sugt;

import java.util.Date;

public class SugtVO {
	
	private Integer s_no; 			//번호
	private Integer s_parent_no; 	//부모글번호
	private String title;			//제목
	private String content;			//내용
	private String s_date;			//작성일자
	private Integer cnt;			//조회수
	private String member_id; 		//작성자 관리자만 작성자에 보임.
	
	
	private Integer first;
	private Integer last;
	
	public Integer getS_no() {
		return s_no;
	}
	public void setS_no(Integer s_no) {
		this.s_no = s_no;
	}
	public Integer getS_parent_no() {
		return s_parent_no;
	}
	public void setS_parent_no(Integer s_parent_no) {
		this.s_parent_no = s_parent_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getLast() {
		return last;
	}
	public void setLast(Integer last) {
		this.last = last;
	}
	
	@Override
	public String toString() {
		return "SugtVO [first=" + first + ", last=" + last + "]";
	}

	
	
	
	
	

}
