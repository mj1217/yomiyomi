package com.yedam.app.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.user.UserService;
import com.yedam.app.user.UserVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:config/*-context.xml")
//설정파일에 등록된 빈을 생성/관리할 컨테이너(ApplicationContext)
public class BoardClient {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	UserService userService;
	
	
	UserVO param;
	
	@Before
	public void init() {
		param = new UserVO();
		param.setId("a");
		System.out.println("before 실행");
	}
	
	@Test
	public void getUserServiceTest() {
		param.setId("test");
		UserVO vo = userService.getUser(param);
		assertEquals("test2", vo.getName());
		System.out.println("service: "+vo);
		
	}
	
	
	
	@Test
	@Ignore
	public void getBoardServiceTest() {
		BoardVO param = new BoardVO();
		param.setSeq(5);
		BoardVO vo = boardService.getBoard(param);
		assertEquals("어드바이스", vo.getWriter());
		System.out.println("service : "+vo);
		
	}
	
	
	@Test
	@Ignore
	public void dataSourceTest() {
		DataSource ds = (DataSource) context.getBean("dataSource");
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getBoardTest() {
		BoardVO param = new BoardVO();
		param.setSeq(5);
		BoardVO boardVO = sqlSession.selectOne("board.getBoard",param);
		System.out.println(boardVO);
	}
		
		
	




}
