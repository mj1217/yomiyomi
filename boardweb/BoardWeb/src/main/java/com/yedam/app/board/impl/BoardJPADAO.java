package com.yedam.app.board.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.yedam.app.board.BoardVO;

@Repository
public class BoardJPADAO {
    
	@PersistenceContext
    private EntityManager em;

	
	public void insertBoard(BoardVO vo) {
		System.out.println("jpa insertBoard()");
		em.persist(vo);
	}

	public void updateBoard(BoardVO vo){
		System.out.println("jpa updateBoard()");
		em.merge(vo);
	}

	public void deleteBoard(BoardVO vo){
		System.out.println("jpa removeBoard()");
		em.remove(em.find(BoardVO.class, vo.getSeq()));
	}

	public BoardVO getBoard(BoardVO vo){
		System.out.println("jpa getBoard()");
		return (BoardVO)em.find(BoardVO.class, vo.getSeq());
	}

	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> JPA로 getBoardList() 검색 기능 처리");
		//return em.createQuery("from BoardVO b order by b.seq desc").getResultList();
		
		TypedQuery<BoardVO> query ;
		if ("title".equals(vo.getSearchCondition()))
			query = em.createQuery("from BoardVO b  where b.title = :title order by b.seq desc", BoardVO.class);
		else if  ("content".equals(vo.getSearchCondition()))
			query = em.createQuery("from BoardVO b  where b.content = :title order by b.seq desc", BoardVO.class);
		else 
			query = em.createQuery("from BoardVO b  order by b.seq desc", BoardVO.class);
		if(vo.getSearchCondition() != null && !vo.getSearchCondition().equals(""))
			query.setParameter("title", vo.getSearchKeyword());
		
		query.setFirstResult(vo.getFirst()-1);
		query.setMaxResults(vo.getLast());
		return query.getResultList();
		
	}
	
	public void deleteBoardList(ArrayList<String> seq){
		System.out.println("jpa deleteBoardList()");
		
	}
	
	public int getCount(BoardVO vo) {
		System.out.println("jpa getCount()");
		return 10;
	}

	public List<Map<String, Object>> getBoardListMap(){
		System.out.println("jpa getBoardListMap()");
		return null;
	}
	
}
