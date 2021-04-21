package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller:Model=> 사용자의 요청을 처리 => 결과값을 보내주는 역할
import java.util.*;
import com.sist.dao.*;
@Controller
public class EmpDeptController {
  /* @Autowired
   private EmpDAO eDao;
   
   @Autowired
   private DeptDAO dDao;
  */
   @Autowired
   private EmpDeptService service;
   
   // 기능 (사용자 요청시 처리) => @RequestMapping , @GetMapping , @PostMapping
   @GetMapping("sawon/list.do")
   public String sawon_list(Model model)
   {
	   List<EmpVO> eList=service.empListData();
	   List<DeptVO> dList=service.deptListData();
	   // list.jsp로 데이터 전송 
	   model.addAttribute("eList", eList);
	   model.addAttribute("dList", dList);
	   return "sawon/list"; //forward
   }
}











