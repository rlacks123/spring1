package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.mybatis.mapper.TestEmpMapper;
import com.yedam.app.mybatis.service.EmpInfo;
import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest // 개발환경에서 불러와 테스트함
class Boot01ApplicationTests {
    @Autowired // 필드 주입 방식 => 단순 테스트용
    EmpMapper empMapper;
    
	@Test // 전체조회 Test만 주석하면 됨
	void selectTest() {
		List<EmpVO> list = empMapper.selectEmpList();
		for(EmpVO emp : list) {
			System.out.println(emp);
		}	
		assertTrue(!list.isEmpty()); // 제유닛 단위테스트 assertTrue(어썰트트루)!<- 있는상황이트루
	}
	
	//@Test // 단건조회
	void infoTest() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		
		assertEquals("King", findVO.getLastName());
		// 첫번째 매개변수 : 기대하는 값
		// 두번째 매개변수 : 실제 값
		// => 두 개가 같으면 테스트 성공, 다르면 실패
	}
	
	//@Test // 등록
	void insertTest() throws ParseException {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Kang");
		empVO.setEmail("Kangg@daum.net");
		empVO.setJobId("SA_REP");
		
//		SimpleDateFormat sdf // 날짜 관련 오늘 말고 다른날 추가할때 사용
//		     = new SimpleDateFormat("yyMMdd"); // 대소문자 구분함
//		Date date = sdf.parse("240501");
//		
//		empVO.setHireDate(date);
		
		int result = empMapper.insertEmpInfo(empVO);
		
		assertEquals(1, result); // 어썰트 매서드로 확인
	}
	
	//@Test // 수정
	void updateTest() {
		// 1) 단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(200);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		// 2) 수정할 데이터
		findVO.setLastName("Han");
		findVO.setJobId(null); // 잡id는 월래 낫널이라 에러인데 if 조건문 걸어서 안뜸
		
		// 3) 수정
		int result = empMapper.updateEmpInfo(findVO);
		
		assertEquals(1, result);
	}
	
	//@Test // 삭제
	void deleteTest() {
		int result= empMapper.deleteEmpInfo(220);
		assertEquals(1, result);
	}
	
	//@Test
	void selectKeyTest() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("Hongg@google.com");
		empVO.setJobId("IT_PROG");
		// employeeId = null
		int result = empMapper.insertEmpInfo(empVO);
		System.out.println("====" + empVO.getEmployeeId());
		assertEquals(1, result);
	}
	
	
//    @Autowired // 필드 주입 방식 => 단순 테스트용 별도의 생성자에 셋터를 거치지않고 empMapper에 강제주입함
//    TestEmpMapper empMapper;
//    
//	@Test
//	void contextLoads() {
//		List<EmpInfo> list = empMapper.empList();
//		for(EmpInfo emp : list) {
//			System.out.println(emp);
//		}	
//	} // 이거먼저 수업한거
}
