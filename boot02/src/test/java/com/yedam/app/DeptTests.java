package com.yedam.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptVO;

@SpringBootTest
class DeptTests {
    @Autowired // 필드 주입 방식 => 단순 테스트용
    DeptMapper deptMapper;
    
	@Test // 전체조회 Test만 주석하면 됨
	void selectTest() {
		List<DeptVO> list = deptMapper.selectDeptList();
		for(DeptVO dept : list) {
			System.out.println(dept);
		}	
		assertTrue(!list.isEmpty()); // 제유닛 단위테스트 assertTrue(어썰트트루)!<- 있는상황이트루
	}
	
	//@Test // 단건조회
	void infoTest() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(100);
		
		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
		
		assertEquals("King", findVO.getDepartmentName());
		// 첫번째 매개변수 : 기대하는 값
		// 두번째 매개변수 : 실제 값
		// => 두 개가 같으면 테스트 성공, 다르면 실패
	}
	
	//@Test // 등록
	void insertTest() throws ParseException {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(216);
		deptVO.setDepartmentName("King1");
		deptVO.setManagerId(100);
		deptVO.setLocationId(100);
		
//		SimpleDateFormat sdf // 날짜 관련 오늘 말고 다른날 추가할때 사용
//		     = new SimpleDateFormat("yyMMdd"); // 대소문자 구분함
//		Date date = sdf.parse("240501");
//		
//		empVO.setHireDate(date);
		
		int result = deptMapper.insertDeptInfo(deptVO);
		
		assertEquals(1, result); // 어썰트 매서드로 확인
	}
	
	//@Test // 수정
	void updateTest() {
		// 1) 단건조회
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(216);
		
		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
		// 2) 수정할 데이터
		findVO.setDepartmentName("Han");
		
		// 3) 수정
		int result = deptMapper.updateDeptInfo(findVO);
		
		assertEquals(1, result);
	}
	
	//@Test // 삭제
	void deleteTest() {
		int result= deptMapper.deleteDeptInfo(216);
		assertEquals(1, result);
	}
	
	
}