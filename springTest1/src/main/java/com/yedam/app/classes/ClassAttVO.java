package com.yedam.app.classes;

import com.yedam.app.subject.SubjectAttVO;

public class ClassAttVO extends SubjectAttVO{
	Integer cl_no;
	String class_name;
	String address;
	String timetable;
	Integer totaltime;
	String class_cd;

	public ClassAttVO() {
		super();
	}
	
	
	public Integer getCl_no() {
		return cl_no;
	}
	public void setCl_no(Integer cl_no) {
		this.cl_no = cl_no;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTimetable() {
		return timetable;
	}
	public void setTimetable(String timetable) {
		this.timetable = timetable;
	}
	public Integer getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}
	public String getClass_cd() {
		return class_cd;
	}
	public void setClass_cd(String class_cd) {
		this.class_cd = class_cd;
	}
	@Override
	public String toString() {
		return "ClassVO [cl_no=" + cl_no + ", class_name=" + class_name + ", address=" + address + ", timetable="
				+ timetable + ", totaltime=" + totaltime + ", class_cd=" + class_cd + "]";
	}
	
}
