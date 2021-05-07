package com.sist.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
/*
 *    public String join(@ModelAttribute("vo") MemberVO vo) ==> ?id=aaa&pwd=1234
 *                      ======================= 생략이 가능
 *    public String list(@RequestParam("page") String page) ===> ?page=1
 *          => request.getParameter("page") => 반드시 변수명을 일치 
 */
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class JoinController {
   @ModelAttribute
   public FormData formData()
   {
	   return new FormData();
   }
   
   @GetMapping("join/form.do")
   public String form() // 입력창 (회원가입,로그인,글쓰기,수정하기...) => 유효성 검사 (Validation)
   {
	   return "join/form";
   }
   
   @PostMapping("join/form.do")
   public String submit(@ModelAttribute @Valid FormData formData,Errors errors,Model model)
   {
	   if(errors.hasErrors()) return "join/form";
	   model.addAttribute("vo", formData);
	   return "join/submit";
   }
}











