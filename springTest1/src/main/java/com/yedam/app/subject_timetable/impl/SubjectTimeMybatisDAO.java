package com.yedam.app.subject_timetable.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.subject_timetable.SubjectTimeService;
import com.yedam.app.subject_timetable.SubjectTimeVO;

@Repository
public class SubjectTimeMybatisDAO implements SubjectTimeService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/* (non-Javadoc)
	 * @see com.yedam.app.subject_timetable.impl.SubjectTimeService#getSubjectTimeList(com.yedam.app.subject_timetable.SubjectTimeVO)
	 */
	@Override
	public List<SubjectTimeVO> getSubjectTimeList(SubjectTimeVO vo) {
		System.out.println("mybatis list");
		return sqlSession.selectList("subjecttime.getSubjectTimeList",vo);
	}
	
}
