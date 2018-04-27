package com.yedam.app.consult;


public class ConsultVO {

	private Integer c_no;
	private String cdate;
	private String s_detail;
	private String cl_no;
	private String title;
	private String content;
	private String writer;
	
	private String s_name;
	private String c_name;
	private String c_writer;
	
	private Integer first;
	private Integer last;
	
	
	
	
	public String getC_writer() {
		return c_writer;
	}
	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
	public Integer getC_no() {
		return c_no;
	}
	public void setC_no(Integer c_no) {
		this.c_no = c_no;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getS_detail() {
		return s_detail;
	}
	public void setS_detail(String s_detail) {
		this.s_detail = s_detail;
	}
	public String getCl_no() {
		return cl_no;
	}
	public void setCl_no(String cl_no) {
		this.cl_no = cl_no;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
		return "ConsultVO [c_no=" + c_no + ", cdate=" + cdate + ", s_detail=" + s_detail + ", cl_no=" + cl_no
				+ ", title=" + title + ", content=" + content + ", writer=" + writer + ", s_name=" + s_name
				+ ", c_name=" + c_name + ", c_writer=" + c_writer + ", first=" + first + ", last=" + last + "]";
	}
	
	
	
	
}
