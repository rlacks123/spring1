package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    
	//@Test // 전체조회 Test만 주석하면 됨
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
	
	@Test // 등록
	void insertTest() {
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Kang");
		empVO.setEmail("Kang@daum.net");
		empVO.setJobId("SA_REP");
		
		int result = empMapper.insertEmpInfo(empVO);
		
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
