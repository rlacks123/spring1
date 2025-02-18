package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data // 실제는 겟터 셋터임 @Data로 자동만들어주는거
public class EmpVO {
	// employee_id => employeeId
	private Integer employeeId; 	// 사원번호
	private String firstName; 		// 이름
	private String lastName; 		// 성
	private String email; 			// 이메일
	private String phoneNumber; 	// 연락처
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private Date hireDate; 			// 입사일 // 날짜 포맷 형식변경 /에서 > -이걸로
	private String jobId;			// 업무번호
	private double salary;			// 급여
	private double commissionPct;	// 커미션
	private int managerId;			// 상사번호
	private int departmentId;		// 부서번호
	
	//public void setEmployeeId(Integer empId) {
	//	this.empId = empId;
	//} 마이바티스는 겟터 셋터 기반 동작임

}
