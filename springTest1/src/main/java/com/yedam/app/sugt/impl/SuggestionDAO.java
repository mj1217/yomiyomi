package com.yedam.app.sugt.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.sugt.SugtVO;

@Repository
public class SuggestionDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//글 등록
	public void insertSugt(SugtVO vo) {
		sqlSession.insert("sugt.insertSugt",vo);
	}
	
	public void updateSugt(SugtVO vo){
		sqlSession.update("sugt.updateSugt",vo);
	}

	public void deleteSugt(SugtVO vo){
		sqlSession.delete("sugt.deleteSugt",vo);
		sqlSession.delete("sugt.deleteCommentsWSugt",vo);
	}

	public SugtVO getSugt(SugtVO vo){
		return sqlSession.selectOne("sugt.getSugt",vo); 
	}
	
	public List<SugtVO> getSugtList(SugtVO vo){
		return sqlSession.selectList("sugt.getSugtList", vo);
	}

	public int getCount(SugtVO vo) {
		return sqlSession.selectOne("sugt.getCount", vo);

	}
	
	public void increaseCnt(SugtVO vo) {
		sqlSession.update("sugt.increaseCnt",vo);
	}
	
}
