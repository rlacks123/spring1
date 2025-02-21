package com.yedam.app.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller // Routing 라우팅에 대한걸 가지고있음
public class BoardController {
	
	private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 전체조회 기능
	// 1) URL + Method
	@GetMapping("boardList") // 스프링으로 임포트
	public String boardList(Model model) {
		// 2) Service
		List<BoardVO> list = (boardService.findAllBoard());
		// 2-1) Service의 결과를 View에 전달
		model.addAttribute("boards",list);		
		// 3) View
		return "board/list";
		// ViewResolver : 경로 생성
		// prefix, classpath:/templates/
		// suffix, .html
		// prefix + return + suffix
		// classpath:/templates/board/list.html
	}
	
	// 게시글 상세조회
	// 1) URL + Method
	@GetMapping("boardInfo") // boardInfo?bno=1
	public String boardInfo(BoardVO boardVO, Model model) {
		// 2) Service
		BoardVO findVO = boardService.findBoardByBno(boardVO);
		// 2-1) Service의 결과를 View에 전달
		model.addAttribute("board", findVO);
		// 3) View
		return "board/info";
		// classpath:/templates/board/info.html 경로
		
	}
	
	// 등록 - 페이지
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/insert";
	}
	
	// 등록 - 처리
	// 일반적으로 <form/> 활용 => QueryString
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
		int bno = boardService.createBoard(boardVO);
		return "redirect:boardInfo?bno=" + bno;
	}
	
	
	
	
	

}
