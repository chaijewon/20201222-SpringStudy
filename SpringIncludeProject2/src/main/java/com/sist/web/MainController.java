package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.sist.dao.*;
@Controller
public class MainController {
   @Autowired
   private MemberDAO mDao;
   
   @Autowired
   private ShopDAO sDao;
   
   @ModelAttribute
   public MemberVO memberVO()
   {
	   return new MemberVO();
   }
   @GetMapping("main/main.do")
   public String main_main(Model model)
   {
	   model.addAttribute("main_jsp", "../main/home.jsp");
	   return "main/main";
   }
   
   @GetMapping("member/join.do")
   public String member_join(Model model)
   {
	   model.addAttribute("main_jsp", "../member/join.jsp");
	   return "main/main";
   }
   
   @PostMapping("member/join.do")
   public String member_join_ok(@ModelAttribute @Valid MemberVO memberVO,Errors errors,Model model)
   {
	   if(errors.hasErrors())
	   {
		   model.addAttribute("main_jsp", "../member/join.jsp");
		   return "main/main";
	   }
	   return "redirect:../main/main.do";
   }
   
   @PostMapping("member/login_ok.do")
   public String login_ok(String id,String pwd,Model model,HttpSession session)
   {
	   System.out.println("login_ok수행");
	   System.out.println("ID:"+id);
	   System.out.println("PWD:"+pwd);
	   MemberVO vo=mDao.memberLogin(id, pwd);
	   System.out.println("login_ok:email=>"+vo.getEmail());
	   if(vo.getMsg().equals("OK"))
	   {
		   session.setAttribute("id", id);
		   session.setAttribute("name", vo.getName());
		   session.setAttribute("admin", vo.getAdmin());
		   // 구매 => 배송지 
		   session.setAttribute("address", vo.getAddr1()+" "+vo.getAddr2());
		   session.setAttribute("tel", vo.getTel());
		   session.setAttribute("email", vo.getEmail());
	   }
	   // login_ok.jsp로 값 전송 
	   model.addAttribute("vo", vo);
	   return "member/login_ok";
   }
   @PostMapping("member/logout_ok")
   public String logout_ok(HttpSession session)
   {
	   session.invalidate();//session에 저장된 내용 해제
	   return "redirect:../main/main.do";
   }
}











