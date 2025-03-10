package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	// SELECT => 리턴 타입 List or VO 클래스
	// 전체조회
	public List<DeptVO> selectDeptList();
	// 단건조회
	public DeptVO selectDeptInfo(DeptVO deptVO);
	
	// DML => 리턴타입 무조건 int
	// 등록
	public int insertDeptInfo(DeptVO deptVO);
	// 수정
	public int updateDeptInfo(DeptVO deptVO);
	// 삭제
	public int deleteDeptInfo(int deptId);
}
