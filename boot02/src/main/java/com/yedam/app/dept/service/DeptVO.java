package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	private Integer departmentId;	// 부서번호
	private String departmentName;	// 부서이름
	private Integer managerId;		// 부서관리자 사원번호
	private Integer locationId;		// 부서 지역번호
}
