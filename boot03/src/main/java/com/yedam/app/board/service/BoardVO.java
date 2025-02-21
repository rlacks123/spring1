package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private Integer bno;		// 번호
	private String title;		// 제목
	private String contents;	// 내용
	private String writer;		// 작성자
	// java.util.Date : yyyy/MM//dd
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// - 하이폰 기반 날짜 입력방식으로 변경
	private Date regdate;		// 작성일
	private Date updatedate;	// 수정일
	private String image;		// 첨부이미지

}
