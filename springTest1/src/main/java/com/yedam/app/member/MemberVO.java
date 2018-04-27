package com.yedam.app.member;

import java.util.Date;

public class MemberVO {

	private String member_id;
	private String pwd="";
	private String pwd2="";
	private String member_cd;
	private String name="";
	private String eng_name="";
	private String social_number="";
	private String school_spec_cd="";
	private String major="";
	private String email="";
	private String address="";
	private String phone="";
	private String h_phone="";
	private String status_cd="";
	private String open_route_cd="";
	private String open_route_etc="";
	private String unemployee_pay_yn="";
	private String previous_job="";
	private Date job_change_date;
	private String bohun_yn="";
	private String class_name="";
	private String class_cd="";
	private String course_type_cd="";
	private String cl_no="";
	
	public String getPwd2() {
		return pwd2;
	}

	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMember_cd() {
		return member_cd;
	}

	public void setMember_cd(String member_cd) {
		this.member_cd = member_cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEng_name() {
		return eng_name;
	}

	public void setEng_name(String eng_name) {
		this.eng_name = eng_name;
	}

	public String getSocial_number() {
		return social_number;
	}

	public void setSocial_number(String social_number) {
		this.social_number = social_number;
	}

	public String getSchool_spec_cd() {
		return school_spec_cd;
	}

	public void setSchool_spec_cd(String school_spec_cd) {
		this.school_spec_cd = school_spec_cd;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getH_phone() {
		return h_phone;
	}

	public void setH_phone(String h_phone) {
		this.h_phone = h_phone;
	}

	public String getStatus_cd() {
		return status_cd;
	}

	public void setStatus_cd(String status_cd) {
		this.status_cd = status_cd;
	}

	public String getOpen_route_cd() {
		return open_route_cd;
	}

	public void setOpen_route_cd(String open_route_cd) {
		this.open_route_cd = open_route_cd;
	}

	public String getOpen_route_etc() {
		return open_route_etc;
	}

	public void setOpen_route_etc(String open_route_etc) {
		this.open_route_etc = open_route_etc;
	}

	public String getUnemployee_pay_yn() {
		return unemployee_pay_yn;
	}

	public void setUnemployee_pay_yn(String unemployee_pay_yn) {
		this.unemployee_pay_yn = unemployee_pay_yn;
	}

	public String getPrevious_job() {
		return previous_job;
	}

	public void setPrevious_job(String previous_job) {
		this.previous_job = previous_job;
	}

	public Date getJob_change_date() {
		return job_change_date;
	}

	public void setJob_change_date(Date job_change_date) {
		this.job_change_date = job_change_date;
	}

	public String getBohun_yn() {
		return bohun_yn;
	}

	public void setBohun_yn(String bohun_yn) {
		this.bohun_yn = bohun_yn;
	}
	

	public String getClass_cd() {
		return class_cd;
	}

	public void setClass_cd(String class_cd) {
		this.class_cd = class_cd;
	}
	

	public String getCourse_type_cd() {
		return course_type_cd;
	}

	public void setCourse_type_cd(String course_type_cd) {
		this.course_type_cd = course_type_cd;
	}
	

	public String getCl_no() {
		return cl_no;
	}

	public void setCl_no(String cl_no) {
		this.cl_no = cl_no;
	}

	@Override
	public String toString() {
		return "MemberVO [member_id=" + member_id + ", pwd=" + pwd + ", pwd2=" + pwd2 + ", member_cd=" + member_cd
				+ ", name=" + name + ", eng_name=" + eng_name + ", social_number=" + social_number + ", school_spec_cd="
				+ school_spec_cd + ", major=" + major + ", email=" + email + ", address=" + address + ", phone=" + phone
				+ ", h_phone=" + h_phone + ", status_cd=" + status_cd + ", open_route_cd=" + open_route_cd
				+ ", open_route_etc=" + open_route_etc + ", unemployee_pay_yn=" + unemployee_pay_yn + ", previous_job="
				+ previous_job + ", job_change_date=" + job_change_date + ", bohun_yn=" + bohun_yn + ", class_name="
				+ class_name + ", class_cd=" + class_cd + ", course_type_cd=" + course_type_cd + ", cl_no=" + cl_no
				+ "]";
	}

	
}
