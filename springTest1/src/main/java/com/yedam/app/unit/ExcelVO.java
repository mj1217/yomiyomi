package com.yedam.app.unit;

public class ExcelVO {


	private Integer no;
	private String day;
	private String card;
	private String name;
	private String classs;
	private String start;
	private String end;
	private String in;
	private String out;
	
	

	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getIn() {
		return in;
	}
	public void setIn(String in) {
		this.in = in;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}
	@Override
	public String toString() {
		return "ExcelVO [day=" + day + ", card=" + card + ", name=" + name + ", classs=" + classs + ", start=" + start
				+ ", end=" + end + ", in=" + in + ", out=" + out + "]";
	}

	
	
	
	
	
	
	
	
}
