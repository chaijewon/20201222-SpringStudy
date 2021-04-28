package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.MemberDAO;

@Controller
public class MemberController {
	@Autowired
    private MemberDAO dao;
	@GetMapping("member/login.do")
	public String member_login()
	{
		return "member/login";
	}
	@PostMapping("member/login_ok.do")
	public String member_login_ok(String id,String pwd,Model model,HttpSession session)
	{
		// 세션은 DispatcherServlet으로부터 매개변수로 받아서 처리한다 
		String result=dao.isLogin(id, pwd);
		if(!(result.equals("NOID")||result.equals("NOPWD")))
		{
			// 로그인된 상태
			session.setAttribute("id", id);
			session.setAttribute("name", result);
		}
		model.addAttribute("result", result);
		return "member/login_ok";
	}
}












