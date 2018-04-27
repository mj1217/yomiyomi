package com.yedam.app.subject;

public class SubjectVO {
	private int su_no;
	private String status_yn;
	private String subject;
	private int totalTime;
	private int first;
	private int last;
	private String class_name;
	private int cl_no;
	private String searchCondition;
	private String searchKeyword;
	
	
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getCl_no() {
		return cl_no;
	}

	public void setCl_no(int cl_no) {
		this.cl_no = cl_no;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getSu_no() {
		return su_no;
	}

	public void setSu_no(int su_no) {
		this.su_no = su_no;
	}

	public String getStatus_yn() {
		return status_yn;
	}

	public void setStatus_yn(String status_yn) {
		this.status_yn = status_yn;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	@Override
	public String toString() {
		return "SubjectVO [su_no=" + su_no + ", status_yn=" + status_yn + ", subject=" + subject + ", totalTime="
				+ totalTime + ", first=" + first + ", last=" + last + ", class_name=" + class_name + ", cl_no=" + cl_no
				+ ", searchCondition=" + searchCondition + ", searchKeyword=" + searchKeyword + "]";
	}

	

}
