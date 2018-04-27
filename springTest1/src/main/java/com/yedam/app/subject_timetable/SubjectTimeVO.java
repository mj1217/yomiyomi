package com.yedam.app.subject_timetable;

import java.util.Date;

public class SubjectTimeVO {

	
	String t_id;
	Date s_date;
	String classtime_cd;
	Integer subject;
	
	
	public SubjectTimeVO(){
		
	}
	
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public String getClasstime_cd() {
		return classtime_cd;
	}
	public void setClasstime_cd(String classtime_cd) {
		this.classtime_cd = classtime_cd;
	}
	public Integer getSubject() {
		return subject;
	}
	public void setSubject(Integer subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "SubjectTimeVO [t_id=" + t_id + ", s_date=" + s_date + ", classtime_cd=" + classtime_cd + ", subject="
				+ subject + "]";
	}
	
	
	
	
	
}
