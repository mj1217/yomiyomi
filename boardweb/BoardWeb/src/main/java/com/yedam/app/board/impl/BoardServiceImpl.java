package com.yedam.app.board.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.BoardService;
import com.yedam.app.board.BoardVO;
import com.yedam.app.common.Log4jAdvice;
import com.yedam.app.common.LogAdvice;


@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardJPADAO dao;
	//BoardMybatisDAO dao;
	//BoardSpringJDBC dao;
	//BoardDAO dao;
	
	
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
		
	}

	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
		
	}

	public void deleteBoard(BoardVO vo) {
		dao.deleteBoard(vo);
		
	}


	public BoardVO getBoard(BoardVO vo) {
		return dao.getBoard(vo);
	}

	
	public List<BoardVO> getBoardList(BoardVO vo) {
		return dao.getBoardList(vo);
	}

	@Override
	public void deleteBoardList(ArrayList<String> seq) {
		dao.deleteBoardList(seq);
		
	}

	@Override
	public int getCount(BoardVO vo) {
		return dao.getCount(vo);
	}

	@Override
	public List<Map<String, Object>> getBoardListMap() {
		return dao.getBoardListMap();
	}
	
	
}
