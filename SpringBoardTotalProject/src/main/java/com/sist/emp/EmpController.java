package com.sist.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
@Controller
public class EmpController {
    @Autowired
	private EmpDAO dao;
    @GetMapping("emp/list.do")
    public String emp_list(Model model)
    {
    	List<String> list=dao.empGetEnameData();
    	List<String> jList=dao.empGetJobData();
    	model.addAttribute("list", list);
    	model.addAttribute("jList", jList);
    	return "emp/list";
    }
    @PostMapping("emp/find.do")
    public String emp_find(String[] names,Model model)
    {
    	Map map=new HashMap();
    	map.put("list", names);
    	List<EmpVO> list=dao.empFindData(map);
    	model.addAttribute("list", list);
    	return "emp/find";
    }
    @PostMapping("emp/find2.do")
    public String emp_find2(String[] jobs,Model model)
    {
    	Map map=new HashMap();
    	map.put("list", jobs);
    	List<EmpVO> list=dao.empFindData(map);
    	model.addAttribute("list", list);
    	return "emp/find";
    }
}
