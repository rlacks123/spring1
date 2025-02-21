package com.yedam.app.board.service;

import java.util.List;

public interface BoardService {
	// 현재 게시판의 전체 글 조회
	public List<BoardVO> findAllBoard(); // 메소드 이름은 편한대로
	
	// 선택한 게시글의 상세조회
	public BoardVO findBoardByBno(BoardVO boardVO);
	
	// 작성한 게시글 등록
	public int createBoard(BoardVO boardVO);

}
