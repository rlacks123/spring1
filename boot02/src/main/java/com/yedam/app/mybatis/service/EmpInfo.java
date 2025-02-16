package com.yedam.app.mybatis.service;

import java.util.Date;

import lombok.Data;

// 값을 담을 객체 : VO 클래스
@Data
public class EmpInfo {
//	private int employee_id; // employeeId
//	private String last_name;
//	private Date hire_date;
//	private double salary;
	
	private int employeeId;
	private String lastName;
	private Date hireDate;
	private double salary;
}
