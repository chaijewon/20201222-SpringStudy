package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
/*
 *    1. 프로젝트 생성 
 *    2. 자바 버젼 변경 (1.8)
 *    3. /WEB-INF/lib/ojdbc14.jar
 *    4. pom.xml에 최근 스프링 버전 설정 
 *    ============================
 *    5. 프로그램 작업 
 *       1) web.xml : Controller,한글변환 
 *       2) 각 클래스 만들기
 *          = ~VO
 *          = ~DAO
 *          = ~Controller
 *       3) VO,SQL문장 저장 => Config.xml (MyBatis)
 *       4) 스프링 연결 : application-context.xml,application-datasource.xml
 *       5) JSP제작 출력 
 *    6. 동작 순서 
 *       1) 사용자 => list.do
 *       2) DispatcherServlet => @RequestMapping을 찾아서 아래있는 메소드에 매개변수 채운다 
 *       3) 찾은 메소드에서 요청처리하고 결과값을 ViewResolver전송
 *       4) ViewResolver에서 Model => request로 변환후에 => JSP에 보낸다
 *       5) JSP에서 실행하고 => 실행결과(HTML) => 해당 브라우저에서 읽을 수 있게 한다   
 */
@Controller
public class RecipeController {
   // 스프링으로 미리 생성된 DAO를 받아 온다
   @Resource(name="recipeDAO")
   private RecipeDAO dao;
   // http://localhost/web/recipe/list.do
   @GetMapping("recipe/list.do")
   public String recipe_list(String page,Model model,HttpServletRequest request)
   {
	   // Model model : 데이터 전달자
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=12;
	   int s=(rowSize*curpage)-(rowSize-1);
	   int e=rowSize*curpage;
	   map.put("start", s);
	   map.put("end", e);
	   List<RecipeVO> list=dao.recipeListData(map);
	   int totalpage=dao.recipeTotalPage();
	   
	   // JSP로 결과값 전송
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   // /recipe/recipe/list.jsp
	   Cookie[] cookies=request.getCookies();
	   List<String> cList=new ArrayList<String>();
	   if(cookies!=null)
	   {
		   for(int i=cookies.length-1;i>=0;i--)
		   {
			   cookies[i].setPath("/");
			   if(cookies[i].getName().startsWith("m"))
			   {
				   
				   RecipeDetailVO vo=dao.recipeDetailData(Integer.parseInt(cookies[i].getValue()));
				   cList.add(vo.getPoster());
			   }
		   }
		   model.addAttribute("cList", cList);
	   }
	   
	   
	   return "list";
   }
   @GetMapping("recipe/detail_before.do")
   public String recipe_detail_before(int no,RedirectAttributes ra,HttpServletResponse response)
   {
	   Cookie cookie=new Cookie("m"+no, String.valueOf(no));
	   cookie.setPath("/");
	   cookie.setMaxAge(60*60*24);
	   // 클라이언트로 전송 
	   response.addCookie(cookie);
	   
	   ra.addAttribute("no",no);
	   return "redirect:detail.do";
	   // "detail.do?no="+no
   }
   @GetMapping("recipe/detail.do")
   public String recipe_detail(int no,Model model)
   {
	   RecipeDetailVO vo=dao.recipeDetailData(no);
	   // 데이터 전송
	   model.addAttribute("vo", vo);
	   return "detail";
   }
}













