package com.yedam.app.unit;

import java.util.Arrays;

public class UnitInsertVO { 				


	private Integer class_no;		//과정번호 (foreign)
	private Integer[] unit;			//단위
	private Integer[] unitdays;		//단위일수
	private String[] sdate; 		//단위시작일
	private String[] edate;			//단위마지막일

	
	public Integer getClass_no() {
		return class_no;
	}
	public void setClass_no(Integer class_no) {
		this.class_no = class_no;
	}
	public Integer[] getUnit() {
		return unit;
	}
	public void setUnit(Integer[] unit) {
		this.unit = unit;
	}
	public Integer[] getUnitdays() {
		return unitdays;
	}
	public void setUnitdays(Integer[] unitdays) {
		this.unitdays = unitdays;
	}
	public String[] getSdate() {
		return sdate;
	}
	public void setSdate(String[] sdate) {
		this.sdate = sdate;
	}
	public String[] getEdate() {
		return edate;
	}
	public void setEdate(String[] edate) {
		this.edate = edate;
	}
	
	
	

	@Override
	public String toString() {
		return "UnitInsertVO [class_no=" + class_no + ", unit=" + Arrays.toString(unit) + ", unitdays="
				+ Arrays.toString(unitdays) + ", sdate=" + Arrays.toString(sdate) + ", edate=" + Arrays.toString(edate)
				+ "]";
	}
	
	
	
	
	
	
	

	
}
