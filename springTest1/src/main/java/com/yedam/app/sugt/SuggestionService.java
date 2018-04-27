package com.yedam.app.sugt;

import java.util.List;



public interface SuggestionService {
	
	public void insertSugt(SugtVO vo);
	public void updateSugt(SugtVO vo);
	public void deleteSugt(SugtVO vo);
	public SugtVO getSugt(SugtVO vo);
	public List<SugtVO> getSugtList(SugtVO vo);
	public int getCount(SugtVO vo);
	public void increaseCnt(SugtVO vo);
}
