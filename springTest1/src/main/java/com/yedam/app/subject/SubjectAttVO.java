package com.yedam.app.subject;

public class SubjectAttVO {

	
	

	Integer su_no;
	String status_yn;
	String subject;
	Integer totaltime;
	Integer cl_no;
	
	
	
	public SubjectAttVO() {
		
	}
	
	
	public Integer getSu_no() {
		return su_no;
	}
	public void setSu_no(Integer su_no) {
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
	public Integer getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}
	public Integer getCl_no() {
		return cl_no;
	}
	public void setCl_no(Integer cl_no) {
		this.cl_no = cl_no;
	}
	@Override
	public String toString() {
		return "SubjectVo [su_no=" + su_no + ", status_yn=" + status_yn + ", subject=" + subject + ", totaltime="
				+ totaltime + ", cl_no=" + cl_no + "]";
	}
	
	
}
