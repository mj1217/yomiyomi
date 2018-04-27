package com.yedam.app.classes;

public class ClassVO{
	private int cl_no;
	private String class_name;
	private String address;
	private String timeTable;
	private int totalTime;
	private String class_cd;
	private String class_nm;
	private int first;
	private int last;
	private int totaldays;
	
	public int getTotaldays() {
		return totaldays;
	}

	public void setTotaldays(int totaldays) {
		this.totaldays = totaldays;
	}

	public String getClass_nm() {
		return class_nm;
	}

	public void setClass_nm(String class_nm) {
		this.class_nm = class_nm;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public String getClass_cd() {
		return class_cd;
	}

	public void setClass_cd(String class_cd) {
		this.class_cd = class_cd;
	}

	public String getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(String timeTable) {
		this.timeTable = timeTable;
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

	@Override
	public String toString() {
		return "ClassVO [cl_no=" + cl_no + ", class_name=" + class_name + ", address=" + address + ", timeTable="
				+ timeTable + ", totalTime=" + totalTime + ", class_cd=" + class_cd + ", class_nm=" + class_nm
				+ ", first=" + first + ", last=" + last + ", totaldays=" + totaldays + "]";
	}
}
