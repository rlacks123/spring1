package com.yedam.app.mybatis.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
//import org.mybatis.spring.annotation.MapperScan;

import com.yedam.app.mybatis.service.EmpInfo;

//@MapperScan(basePackages = "com.yedam.app.**.mapper")
         // 구현 클래스
@Mapper // 맵퍼라고 알리면 마이바티스 실행 이것보다 편한방법있어서 안씀
public interface TestEmpMapper {
    // EmpDAO => EmpMapper
	// 전체조회
	public List<EmpInfo> empList();
}
