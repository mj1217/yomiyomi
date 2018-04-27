package com.yedam.app.unit;

public class UnitVO { 				//단위기간 출석부
	private Integer c_no; 			//출석부 번호(primary 아님)
	private String student_name;	//학생이름
	private Integer class_no;		//과정번호 (foreign)
	private Integer unit;			//단위
	private Integer late;			//지각
	private Integer leave;			//조퇴
	private Integer absence;		//결석
	private Integer goout;			//외출
	
	private Integer unitdays;		//단위일수
	private String sdate; 			//단위시작일
	private String edate;			//단위마지막일
	
	private String OUT_MSG; 		//프로시저 정상/에러메시지 출력
	private String excelFile;		//엑셀파일 업로드
	
	private String day;				//출석 업데이트시 사용하는 츨석일자
	private Integer absenceDays;	//결석가능일수
	private Double score;			//지각, 조퇴, 결석, 외출 점수
	
	
	
	
	
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getAbsenceDays() {
		return absenceDays;
	}
	public void setAbsenceDays(Integer absenceDays) {
		this.absenceDays = absenceDays;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public Integer getC_no() {
		return c_no;
	}
	public void setC_no(Integer c_no) {
		this.c_no = c_no;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Integer getClass_no() {
		return class_no;
	}
	public void setClass_no(Integer class_no) {
		this.class_no = class_no;
	}
	public Integer getUnit() {
		return unit;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
	}
	public Integer getLate() {
		return late;
	}
	public void setLate(Integer late) {
		this.late = late;
	}
	public Integer getLeave() {
		return leave;
	}
	public void setLeave(Integer leave) {
		this.leave = leave;
	}
	public Integer getAbsence() {
		return absence;
	}
	public void setAbsence(Integer absence) {
		this.absence = absence;
	}
	public Integer getGoout() {
		return goout;
	}
	public void setGoout(Integer goout) {
		this.goout = goout;
	}
	
	
	
	public Integer getUnitdays() {
		return unitdays;
	}
	public void setUnitdays(Integer unitdays) {
		this.unitdays = unitdays;
	}
	
	
	public String getOUT_MSG() {
		return OUT_MSG;
	}
	public void setOUT_MSG(String OUT_MSG) {
		this.OUT_MSG = OUT_MSG;
	}
	
	
	
	
	
	
	public String getExcelFile() {
		return excelFile;
	}
	public void setExcelFile(String excelFile) {
		this.excelFile = excelFile;
	}
	@Override
	public String toString() {
		return "UnitVO [c_no=" + c_no + ", student_name=" + student_name + ", class_no=" + class_no + ", unit=" + unit
				+ ", late=" + late + ", leave=" + leave + ", absence=" + absence + ", goout=" + goout + "]";
	}
	
	
	
	

	
}
