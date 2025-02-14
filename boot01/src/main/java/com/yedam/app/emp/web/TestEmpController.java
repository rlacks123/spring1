package com.yedam.app.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class TestEmpController {
	@RequestMapping(path="/", method = RequestMethod.GET)
	@ResponseBody
	public String selectKeyword(EmpVO empVO) {
		String result = "Result : " + empVO.getEmployeeId();
		return result;
	} // 메인에서 스프링 부트 앱으로 실행 대시보드에서 클릭해도 사이트열림 Result : null값나옴
	// http://localhost:8095/test?employeeId=100

}
