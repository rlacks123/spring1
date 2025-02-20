package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	// 전체조회
	public List<BoardVO> selectAllList();
	
	// 단건조회
	public BoardVO selectInfo(BoardVO boardVO);
	
	// 등록
	public int inserInfo(BoardVO boardVO);
	
	// 수정
	
	
	//삭제
	
	
}
