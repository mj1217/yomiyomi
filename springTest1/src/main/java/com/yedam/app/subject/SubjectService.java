package com.yedam.app.subject;

import java.util.List;
import java.util.Map;

public interface SubjectService {

	public void insertSubject(Map<String, Object> vo);
	public void updateSubject(SubjectVO vo);
	public void deleteSubject(SubjectVO vo);
	public List<SubjectVO> getSubjectList(SubjectVO vo);
	public SubjectVO getSubject(SubjectVO vo);
	public int getCount(SubjectVO vo);
	public List<SubjectVO> getSubjectListAjax( SubjectVO vo);
}
