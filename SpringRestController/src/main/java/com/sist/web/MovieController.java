package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class MovieController {
   @Autowired
   private MovieDAO dao;
   
   @GetMapping("movie/list.do")
   public String movie_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   List<MovieVO> list=dao.movieListData(map);
	   int totalpage=dao.movieTotalPage();
	   
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1; // 1 , 11 , 21 , 31
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;// 10, 20 ,30 ,40...
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   model.addAttribute("list", list);
	   model.addAttribute("curpage",curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("BLOCK", BLOCK);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   
	   return "movie/list";
   }
}















