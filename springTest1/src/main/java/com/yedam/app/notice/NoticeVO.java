package com.yedam.app.notice;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class NoticeVO {
	
	private Integer n_no;      //번호
	private String title;	   //제목
	private String content;    //내용
	private Date ndate;        //작성일시
	private Integer viewcount; //조회수
	private String writer;     //작성자
	private String filename;   //첨부파일
	private Integer priority_yn = 0;  //필독공지
	private int cnt;
	
	private String searchCondition;
	private String searchKeyword;
	private MultipartFile uploadFile;
	private String uploadFileName;
	private String originalFileName;
	
	private Integer first;
	private Integer last;
	
	
	
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getLast() {
		return last;
	}
	public void setLast(Integer last) {
		this.last = last;
	}
	public Integer getN_no() {
		return n_no;
	}
	public void setN_no(Integer n_no) {
		this.n_no = n_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNdate() {
		return ndate;
	}
	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}
	public Integer getViewcount() {
		return viewcount;
	}
	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Integer getPriority_yn() {
		return priority_yn;
	}
	public void setPriority_yn(Integer priority_yn) {
		this.priority_yn = priority_yn;
	}
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
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	@Override
	public String toString() {
		return "NoticeVO [n_no=" + n_no + ", title=" + title + ", content=" + content + ", ndate=" + ndate
				+ ", viewcount=" + viewcount + ", writer=" + writer + ", filename=" + filename + ", priority="
				+ priority_yn + ", first=" + first + ", last=" + last + "]";
	}
	
	
	
	
	
	
	
	
}
