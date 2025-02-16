package com.yedam.app.dept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@Service	// @Transcational 트랜잭셔널 사용 가능 // 빈등록 할때사용
public class DeptServiceImpl implements DeptService {
	// DB가 필요한 경우 맵퍼가 필요 Mapper는 여러개가 가능
	private DeptMapper deptMapper;
	
	@Autowired
	DeptServiceImpl(DeptMapper deptMapper) {
		this.deptMapper = deptMapper;
	}
	
	@Override // 전체조회
	public List<DeptVO> findAllDept() {
		return deptMapper.selectDeptList();
	}
	
	@Override // 단건조회
	public DeptVO findDeptInfo(DeptVO deptVO) {
		return deptMapper.selectDeptInfo(deptVO);
	}
	
	@Override // 등록
	public int createDeptInfo(DeptVO deptVO) {
		int result = deptMapper.insertDeptInfo(deptVO);
		return result == 1 ? deptVO.getDepartmentId() : -1;
	}
	
	@Override // 수정
	public Map<String, Object> modifyDeptInfo(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>(); // 밸류를 Object하면 값을 넣을때 문제가안됨
		boolean isSuccessed = false;
		
		int result = deptMapper.updateDeptInfo(deptVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		// 자바 내부 기준말고 아작스 기준으로 만듬 자바스크립트한태 전달형태 지금만든 맵
		
		return map;
	}
	
	@Override // 삭제
	public Map<String, Object> removeDeptInfo(int deptId) {
		Map<String, Object> map = new HashMap<>();
		
		int result = deptMapper.deleteDeptInfo(deptId);
		
		if (result == 1 ) {
			// { "employeeId" : 104 }
			map.put("departmentId", deptId);
		}
		return map;
	}

}


