package com.yedam.app.board.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yedam.app.board.BoardService;
import com.yedam.app.board.BoardVO;
import com.yedam.app.common.Paging;

@Controller
@SessionAttributes("board")
public class BoardController { //pojo
	
	@Autowired
	BoardService boardService;
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "title");
		conditionMap.put("내용", "content");
		return conditionMap;
	}
	
	
	//목록
/*	@RequestMapping("/getBoardList")
	public ModelAndView getBoardList(@RequestParam(value="searchCondition", required=false, defaultValue="title") String condition, 
									@RequestParam(value="searchKeyword", required=false) String keyword) {
		System.out.println("condition : " + condition);
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(condition);
		vo.setSearchKeyword(keyword);
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardList",boardService.getBoardList(vo));
		mv.setViewName("board/getBoardList");
		return mv;
	}*/
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, BoardVO vo, Paging paging, Locale locale) {
		
		System.out.println(locale.getCountry() +":"+ locale.getLanguage());
		
		//전체 레코드 건수
		paging.setTotalRecord(boardService.getCount(vo));
		
		
		//vo의 first, last 셋팅
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());
		
		//결과저장
		model.addAttribute("boardList",boardService.getBoardList(vo));
		model.addAttribute("paging",paging);	
		
		
		return "board/getBoardList";
		
	}
	
	//등록폼
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public String insertBoardForm(Model model, BoardVO vo) {
		return "board/insertBoard";
	}
	
	//등록처리
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		//첨부파일이 있는지 체크
		MultipartFile file = vo.getUploadFile();
		if(file != null && file.getSize()>0) {
			//업로드된 파일이름 읽기
			String filename = file.getOriginalFilename();
			//중복파일이 있으면 rename
			
			//파일을 업로드 위치에 저장
			file.transferTo(new File("d:/upload", filename));
			vo.setUploadFileName(filename);
		}
		
		boardService.insertBoard(vo);
		System.out.println("seq: " +vo.getSeq());
		//model.addAttribute("boardVO",vo); 자동으로 model에 add 되므로 로그인할때 id 다시 받아오기 편하다.
		return "redirect:/getBoardList";
	}
	
	//상세보기
	@RequestMapping("/getBoard/{seq}")
	public ModelAndView getBoard( @PathVariable Integer seq ) {
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", boardService.getBoard(vo)); //sessionAttribute에 자동 저장되도록 설정,
		mv.setViewName("board/getBoard");
		return mv;
	}
	
	//수정폼
	@RequestMapping("/updateBoardForm/{seq}")
	public String updateBoardForm(Model model,@PathVariable Integer seq) {
		BoardVO vo = new BoardVO();
		vo.setSeq(seq);
		model.addAttribute("board", boardService.getBoard(vo));
		return "board/updateBoard";
	}
	
	//수정처리
	@RequestMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, SessionStatus sessionStatus) { //session에서 board있으면 읽어오고 없으면 boardvo 생성
		System.out.println("session vo :" + vo);
		boardService.updateBoard(vo);
		sessionStatus.setComplete(); //session에 저장된 모델 값(board)을 다 지움.
		return "redirect:/getBoardList";
		}
	//삭제처리
	@RequestMapping("/deleteBoard")
	public String deleteBoard( BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:/getBoardList";
		}
	//단건삭제처리
	@RequestMapping("/deleteBoardList")
	public String deleteBoardList(@RequestParam ArrayList<String> seq) {
		boardService.deleteBoardList(seq);
		return "redirect:/getBoardList";
	}
	
	
}