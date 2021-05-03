package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		
		return "emp/list";
	}
}
