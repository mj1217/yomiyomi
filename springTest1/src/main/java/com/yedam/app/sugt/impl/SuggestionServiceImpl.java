package com.yedam.app.sugt.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yedam.app.sugt.SuggestionService;
import com.yedam.app.sugt.SugtVO;

@Service("sugtService")
public class SuggestionServiceImpl implements SuggestionService{
	
	@Autowired
	SuggestionDAO dao;

	@Autowired
	CommentsDAO cdao;

	public void insertSugt(SugtVO vo) {
		dao.insertSugt(vo);
	}


	public void updateSugt(SugtVO vo) {
		dao.updateSugt(vo);
	}


	public void deleteSugt(SugtVO vo) {
		dao.deleteSugt(vo); 
	}

	public SugtVO getSugt(SugtVO vo) {
		return dao.getSugt(vo);
	}


	public List<SugtVO> getSugtList(SugtVO vo) {
		return dao.getSugtList(vo);
	}


	public int getCount(SugtVO vo) {
		return dao.getCount(vo);
	}


	public void increaseCnt(SugtVO vo) {
		dao.increaseCnt(vo);
		
	}
	
	
	
}
