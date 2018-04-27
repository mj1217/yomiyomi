package com.yedam.app.classes;

import java.util.List;

public interface ClassService {

	public void insertClass(ClassVO vo);
	public void updateClass(ClassVO vo);
	public void deleteClass(ClassVO vo);
	public ClassVO getClass(ClassVO vo);
	public List<ClassVO> getClassList(ClassVO vo);
	public int getCount(ClassVO vo);
	public List<ClassVO> getClassListNP(ClassVO vo);
	public List<ClassVO> getClassList2(ClassVO vo);
	public List<ClassVO> getClassAttList(ClassVO vo);
}
