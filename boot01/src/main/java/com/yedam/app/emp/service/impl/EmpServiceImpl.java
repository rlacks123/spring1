package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Service // @Transcational 트랜잭셔널 사용 가능 // 빈등록 할때사용
public class EmpServiceImpl implements EmpService {
	// DB가 필요한 경우 맵퍼가 필요 Mapper는 여러개가 가능
	private EmpMapper empMapper;
	
	@Autowired
	EmpServiceImpl(EmpMapper empMapper){
		this.empMapper = empMapper;
	}
	
	@Override // 전체조회
	public List<EmpVO> findAllEmp() {
		return empMapper.selectEmpList();
	}

	@Override // 단건조회
	public EmpVO findEmpInfo(EmpVO empVO) {
		return empMapper.selectEmpInfo(empVO);
	}

	@Override // 등록
	public int createEmpInfo(EmpVO empVO) {
		int result = empMapper.insertEmpInfo(empVO);
		return result == 1 ? empVO.getEmployeeId() : -1;
	}

	@Override // 수정
	public Map<String, Object> modifyEmpInfo(EmpVO empVO) {
		Map<String, Object> map = new HashMap<>(); // 밸류를 Object하면 값을 넣을때 문제가안됨
		boolean isSuccessed = false;
		
		int result = empMapper.updateEmpInfo(empVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", empVO);
		// 자바 내부 기준말고 아작스 기준으로 만듬 자바스크립트한태 전달형태 지금만든 맵
		
		return map;
	}

	@Override // 삭제
	public Map<String, Object> removeEmpInfo(int employeeId) {
		Map<String, Object> map = new HashMap<>();
		
		int result = empMapper.deleteEmpInfo(employeeId);
		
		if (result == 1 ) {
			// { "employeeId" : 104 }
			map.put("employeeId", employeeId);
		}
		return map;
	}

}
