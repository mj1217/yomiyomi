package com.yedam.app.board.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.app.board.BoardVO;

@Repository
public class BoardMybatisDAO {

	@Autowired
	private SqlSessionTemplate sqlSession; //mybatis-context bean 등록되있음 //jdbc템플릿 대신
	
	public void insertBoard(BoardVO vo) {
		sqlSession.insert("board.insertBoard",vo); // boardMapper 에 지정한 , (namespace id. 메소드 id)
	}

	public void updateBoard(BoardVO vo){
		sqlSession.update("board.updateBoard",vo);
	}

	public void deleteBoard(BoardVO vo){
		sqlSession.delete("board.deleteBoard",vo);
	}

	public BoardVO getBoard(BoardVO vo){
		System.out.println("mybatis getboard");
		return sqlSession.selectOne("board.getBoard",vo);
	}

	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("mybatis getboardList");
		return sqlSession.selectList("board.getBoardList",vo);
	}
	
	public void deleteBoardList(ArrayList<String> seq){
		sqlSession.delete("board.deleteBoardList",seq);

	}
	
	public int getCount(BoardVO vo) {
		return sqlSession.selectOne("board.getCount", vo);
	}

	public List<Map<String, Object>> getBoardListMap(){
		System.out.println("mybatis getboardListMap");
		return sqlSession.selectList("board.getBoardListMap");
	}
	
}
