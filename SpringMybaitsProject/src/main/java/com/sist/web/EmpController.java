package com.sist.web;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import javax.annotation.Resource;

import com.sist.dao.*;
@Controller
public class EmpController {
   // 사용자가 요청한 데이터를 전송 (요청처리)
   @Resource(name="empDAO")
   private EmpDAO dao;
   @GetMapping("emp/list.do")
   public String emp_list(Model model)
   {
	   List<String> nList=dao.empGetEnameData();
	   // 전송 
	   model.addAttribute("nList", nList);
	   return "emp/list";
   }
   @PostMapping("emp/find.do")
   public String emp_find(String[] names,Model model)
   {
	   Map map=new HashMap();
	   map.put("names", names);
	   List<EmpVO> list=dao.empFindData(map);
	   model.addAttribute("list", list);
	   return "emp/find";
   }
}

















