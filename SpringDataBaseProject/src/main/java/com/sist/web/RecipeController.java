package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.dao.*;
// 요청처리 => 조립 => 결과를 보내준다(JSP)
@Controller
public class RecipeController {
   // RecipeDAO가 스프링으로부터 얻어 온다 (DAO작동 SqlSessionFactory => 스프링에 저장된 DAO만 SqlSessionFactory를 가지고 있다)
   @Autowired
   private RecipeDAO dao;
   
   // 사용자 요청 => @RequestMapping("사용자가 요청한 URI주소") , 4.3버전이상 (@GetMapping,@PostMapping)
   @GetMapping("recipe/list.do")
   public String recipe_list(String page,Model model)
   {
	   /*
	    *   p:prefix="/recipe/" => JSP가 들어가 있는 폴더 1개 
            p:suffix=".jsp"
            
                      폴더가 여러개 있는 경우
            p:prefix="/"
            => /recipe/list.jsp
	    */
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   List<RecipeVO> list=dao.recipeListData(map);
	   // 총페이지 읽기
	   int totalpage=dao.recipeTotalPage();
	   
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1; //curpage=1~10 => 1 블록 시작위치 
	   // [1][2]...[9]
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   
	   int allPage=totalpage;
	   if(endPage>allPage)
		   endPage=allPage;
	   
	   // 전송 
	   model.addAttribute("list",list);
	   model.addAttribute("BLOCK", BLOCK);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("allPage", allPage);
	   return "list";
   }
   @GetMapping("recipe/detail.do")
   public String recipe_detail(int no,Model model)
   {
	   // DAO => RecipeDetailVO 
	   RecipeDetailVO vo=dao.recipeDetailData(no);
	   model.addAttribute("vo", vo);
	   return "detail";
   }
   
}












