package com.sist.inputoutput;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 메모리 할당 => Model (요청처리 => @Controller)
@Controller
@RequestMapping("main/")
public class MainController {
   @RequestMapping("input.do") // GetMapping
   public String main_input()
   {
	   return "main/input";
   }
   @RequestMapping("output.do") // PostMapping
   public String main_output(HttpServletRequest request)
   {
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex){}
	   
	   String name=request.getParameter("name");
	   String sex=request.getParameter("sex");
	   String addr=request.getParameter("addr");
	   String tel=request.getParameter("tel");
	   String age=request.getParameter("age");
	   
	   MemberVO vo=new MemberVO();
	   vo.setName(name);
	   vo.setAddr(addr);
	   vo.setSex(sex);
	   vo.setTel(tel);
	   vo.setAge(Integer.parseInt(age));
	   
	   request.setAttribute("vo", vo);
	   // 이름만 전송
	   return "main/output";
   }
   // request를 사용하지 않는 경우 => JSP로 데이터 전송하는 객체 => Model
   @RequestMapping("output2.do")
   public String main_output2(MemberVO vo,Model model)
   {
	   model.addAttribute("vo", vo);
	   return "main/output";
   }
}











