package com.sist.web;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.DataVO;
// 네트워크 프로그램 : 주고 받기
// web => HttpServletRequest , spring => 메소드 매개변수 , 요청(주고) , 받기(응답) => model,request
// 요청 => 1)VO,2)일반데이터,3)배열
@Controller
public class DataRecvController {
   @RequestMapping("data/input.do")
   public String data_input()
   {
	   return "data/input";
   }
   @RequestMapping("data/output.do")
   public String data_output(DataVO vo,Model model)
   {
	   model.addAttribute("list", vo.getList());
	   return "data/output";
   }
   @RequestMapping("data/input2.do")
   public String data_input2()
   {
	   return "data/input2";
   }
   @RequestMapping("data/output2.do")
   public String data_output2(String[] hobby,Model model)
   {
	   model.addAttribute("hobby", hobby);
	   return "data/output2";
   }
}









