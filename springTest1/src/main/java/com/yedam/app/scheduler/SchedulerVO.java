package com.yedam.app.scheduler;

import java.sql.Date;

public class SchedulerVO {
	
	private Integer no =1;
	private String name;
	private Date startday;
	private Date endday;
	private String type;
	private String rotation_yn;

	
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartday() {
		return startday;
	}
	public void setStartday(Date startday) {
		this.startday = startday;
	}
	public Date getEndday() {
		return endday;
	}
	public void setEndday(Date endday) {
		this.endday = endday;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRotation_yn() {
		return rotation_yn;
	}
	public void setRotation_yn(String rotation_yn) {
		this.rotation_yn = rotation_yn;
	}

	
	@Override
	public String toString() {
		return "SchedulerVO [no=" + no + ", name=" + name + ", startday=" + startday + ", endday=" + endday + ", type="
				+ type + ", rotation_yn=" + rotation_yn + ", searchCondition="+"]";
	}
	
	
	
	
}
