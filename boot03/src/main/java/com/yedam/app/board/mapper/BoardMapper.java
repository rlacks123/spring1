package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	// 전체조회
	public List<BoardVO> selectAllList();
	
	// 단건조회
	public BoardVO selectInfo(BoardVO boardVO);
	
	// 등록 // 리턴하는게 무조건 정수라 int
	public int inserInfo(BoardVO boardVO);
	
	// 수정
	
	
	//삭제
	
	
}
