package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

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
}











