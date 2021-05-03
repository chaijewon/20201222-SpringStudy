package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;
import java.util.*;
@Controller
public class EmpController {
    // EmpDAO => 스프링으로부터 받아 온다
	@Autowired
	private EmpDAO dao;
	
	// 목록
	@GetMapping("emp/list.do") // Controller => 1. String(경로명과 jsp파일명) , 2. void(다운로드,업로드)
	public String emp_list(Model model)
	{
		List<EmpVO> list=dao.empJoinData();
		model.addAttribute("list", list);
		return "emp/list";
	}
	
	@GetMapping("emp/detail.do")
	public String emp_detail(int empno,Model model)
	{
		EmpVO vo=dao.empFindData(empno);
		model.addAttribute("vo", vo);
		return "emp/detail";
	}
	
	@PostMapping("emp/find.do")
	public String emp_find(String[] names,Model model)
	{
		// DAO연결 
		for(String name:names)
		{
			System.out.println(name);
		}
		Map map=new HashMap();
		map.put("nameArr", names);
		List<EmpVO> list=dao.empSearchData(map);
		model.addAttribute("list",list);
		return "emp/find";
	}
}







