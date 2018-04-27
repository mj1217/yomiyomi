package com.yedam.app.sugt;

import java.util.Date;

public class CommentsVO {

	private Integer co_no; 			//댓글번호
	private String content;		    //댓글내용
	private String member_id; 		//작성자(익명처리)
	private Date co_date;  			//댓글 작성일자
	private String c_date;
	private Integer parent_no;	    //게시글번호(참조키)
	private int    pageUnit;
	
	
	
	
	
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	public Integer getCo_no() {
		return co_no;
	}
	public void setCo_no(Integer co_no) {
		this.co_no = co_no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
	public Date getCo_date() {
		return co_date;
	}
	public void setCo_date(Date co_date) {
		this.co_date = co_date;
	}
	public Integer getParent_no() {
		return parent_no;
	}
	public void setParent_no(Integer parent_no) {
		this.parent_no = parent_no;
	}
	public int getPageUnit() {
		return pageUnit;
	}
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}
	
	@Override
	public String toString() {
		return "CommentsVO [co_no=" + co_no + ", content=" + content + ", member_id=" + member_id + ", co_date="
				+ co_date + ", parent_no=" + parent_no + ", pageUnit=" + pageUnit + "]";
	}	
	
	
	
	
}
