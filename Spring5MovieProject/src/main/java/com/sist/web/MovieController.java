package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
// DispatcherServlet 연결 => 요청처리 => 결과값 => ViewResolver => JSP
@Controller
public class MovieController {
    // 스프링에 저장된 MovieDAO의 객체를 받아온다 
	@Autowired
	private MovieDAO dao;
	
	@GetMapping("movie/list.do")
	public String movie_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<MovieVO> list=dao.movieListData(map);
		int totalpage=dao.movieTotalPage();
		// 데이터를 JSP로 전송 
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		return "movie/list";
	}
	
	@GetMapping("movie/detail.do")
	public String movie_detail(int mno,Model model)
	{
		MovieVO vo=dao.movieDetailData(mno);
		model.addAttribute("vo", vo);
		return "movie/detail";
	}
}












