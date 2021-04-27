package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Model => DispatcherServlet => 프로그래머 처리할 수 있게 위탁(@Controller)
/*
 *    MVC
 *     = 제어하는 기능 
 *     = 1. 요청받는 기능 , 응답하는 기능 => Front Controller : DispatcherServlet
 *     = 2. 요청을 처리하는 기능  => Model (비지니스 로직)
 */
import java.util.*;
import com.sist.dao.*;
@Controller
public class MovieController {
  //DataBase 
  @Autowired
  private MovieDAO dao;
  
  @RequestMapping("main/main.do")
  public String main_main()
  {
	  return "main";
  }
  @RequestMapping("movie/movie_list.do")
  public String movie_movie_list(String page,String fd,Model model)
  {
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  int rowSize=12;
	  int start=(rowSize*curpage)-(rowSize-1);
	  int end=(rowSize*curpage);
	  map.put("start", start);
	  map.put("end", end);
	  if(fd==null)
	  {
		  List<MovieVO> list=dao.movieAllData(map);
		  int totalpage=dao.movieAllTotalPage();
		  
		  // 전송
		  model.addAttribute("list", list);
		  model.addAttribute("curpage", curpage);
		  model.addAttribute("totalpage", totalpage);
	  }
	  else
	  {
		  map.put("keyword", fd);
		  List<MovieVO> list=dao.movieFindData(map);
		  int totalpage=dao.movieFindTotalPage(fd);
		  
		  model.addAttribute("list", list);
		  model.addAttribute("curpage", curpage);
		  model.addAttribute("totalpage", totalpage);
	  }
	  return "movie/movie_list";
  }
}














