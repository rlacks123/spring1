package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller  // reute : 사용자의 요청 (endpoint)와 그에 대한 처리
             // : URL + METHOD => Strvice => View
public class EmpController {
	// 해당 컨트롤러에서 제공하는 서비스
	private EmpService empService;
	
	@Autowired
	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	
	// GET : 조회, 빈페이지
	// POST : 데이터 조작(등록, 수정, 삭제)
	// 컨트롤러 대략 6 ~ 7 개 필요
	
	// 전체조회 : GET 컨트롤러 1개, 최종프로젝트때 전체조회 생략할경우도있음
	// 1) URL METHOD
	@GetMapping("empList")  // Model = Request + Response
	public String empList(Model model) {		
		// 2) Service
		List<EmpVO> list = empService.findAllEmp();
		// 2-1) Service의 결과를 View에 전달
		model.addAttribute("emps", list);
		// 3) View
		return "emp/list";
	}// 컨트롤러 길어야 5~7줄 넘으면 이유 물어봄
	// prifix , classpath:templates/
	// suffix , .html
	
	// prifix + return + suffix
	// classpath:/templates/emp/list.html = 경로설정
	
	
	// 단건조회 : GET 컨트롤러 1개 + 전달받을 데이터 => QueryString 쿼리스트링 방식밖에 못씀 GET는
	//1) URL METHOD
	@GetMapping("empInfo") // empInfo?employeeId=100 //empVO는 사용자가 우리한태 준값 // model 사용자한태 줄값
	public String empInfo(EmpVO empVO, Model model) {
         // 2) Service
	     EmpVO findVO = empService.findEmpInfo(empVO);	
	     // 2-1) Service의 결과를 View에 전달
	     model.addAttribute("emp", findVO); // addAttribute 애드 어트러뷰트 화면 출력때 사용
	     // 3) View
	     return "emp/info";
	 	// prifix , classpath:templates/
	 	// suffix , .html
	 	
	 	// prifix + return + suffix
	    // classpath:templates/emp/info.html
		
	}
	
	// 등록 - 페이지 : GET 컨트롤러 최소 2개 = 새로운 페이지 등록할때 빈페이지기준 내부페이지 없음
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	
	// 등록 - 처리 : POST => form 태그를 통한 submit // 제이슨 못씀
	//                   => 이미지가 있는 경우 multipart/form-data
	//                   => 이미지가 없는 경우 application/x-www-form-urlencoded
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.createEmpInfo(empVO);
		String url = null;
		if(eid > -1) {
			// 정상적으로 등록된 경우 redirect 이게 샌드리다이렉트라고 생각하면됨
			url = "redirect:empInfo?employeeId="+eid;
		}else {
			// 등록되지 않은 경우 // 앨스 부분 오류나서 월래안돔
			url = "redirect:empList";
		}
		return url;
	}
	
	// 수정 - 페이지 : GET 컨트롤러 최소 2개 <=> 단건조회 // 사실상 단건조회 형태로 동작함
	//1) URL METHOD
	@GetMapping("empUpdate") // 밑에 empVO는 사용자가 우리한태 준값 // model 사용자한태 줄값
	public String empUpdate(EmpVO empVO, Model model) {
         // 2) Service
	     EmpVO findVO = empService.findEmpInfo(empVO);	
	     // 2-1) Service의 결과를 View에 전달
	     model.addAttribute("emp", findVO); // addAttribute 애드 어트러뷰트 화면 출력때 사용
	     // 3) View
	     return "emp/update";
		
	}
	// 수정 - 처리 : POST / AJAX => JSON (@RequestBody)
	@PostMapping("empUpdate")
	@ResponseBody // AJAX // 리스판스 바디가 아작스를 의미하고 리턴하는 응답객체를 작성하겠다
	public Map<String, Object>
	    empUpdateAJAXJSON(@RequestBody EmpVO empVO) { // @RequestBody 리퀘스트바디 붙이면 컨텐트타입 제이슨 때면 커맨더 객체
		return empService.modifyEmpInfo(empVO);
	}
	
	// 단건삭제 - 처리 : GET + 전달받을 데이터 1건 
	//                 => QueryString(@RequestParam)
	@GetMapping("empDelete")
	public String empDelete(Integer employeeId) {
		empService.removeEmpInfo(employeeId);
		return "redirect:empList";
	} // 삭제시 리다이렉트 걸려야함

}
