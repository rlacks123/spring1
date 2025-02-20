package com.yedam.app.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service // Bean 등록
public class BoardServiceImpl  implements BoardService {
	
	private BoardMapper boardMapper;         // 접속 하는 객체가 필수

	@Autowired // DI						// 생성자 주입방식
	BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}
	
	@Override // 현재 게시판의 전체 글 조회
	public List<BoardVO> findAllBoard() {
		
		return boardMapper.selectAllList(); // selectAllList()가 인터페이스 > xml 로 연결되서 셀렉트문 실행
	}

	@Override
	public BoardVO findBoardByBno(BoardVO boardVO) {

		return boardMapper.selectInfo(boardVO);
	}
	
	

}
