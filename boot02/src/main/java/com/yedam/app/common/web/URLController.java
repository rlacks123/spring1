package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 컨트롤러 Bean(빈) 등록, Web(웹)과 관련분 부분
public class URLController {
	@GetMapping("/urltest") // 겟 매핑 브라우저로 즉각적으로 접근됨 포스트와 경로는 같아도됨
	@ResponseBody
	public String urlGetTest(String keyword) {
		return "Server Response : Get Method\n select - " + keyword;
	}
	@PostMapping("/urltest") // 포스트 매핑 부매랑 포스트 방식으로 접근함
	@ResponseBody
	public String urlPostTest(String keyword) {
		return "Server Response : Post Method\n select - " + keyword;
	}

}
