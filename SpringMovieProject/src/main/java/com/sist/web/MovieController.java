package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *    1. DAO 
 *    2. Manager
 *    3. Controller
 */
// 클라이언트가 요청할때 요청처리 => 결과값을 보내주는 역할 (Model)
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
// .do => @RequestMapping  ==> model ==> 데이터 JSP로 전송
@Controller
public class MovieController {
    // 스프링에 생성된 MovieDAO 객체를 얻어온다
	@Autowired
	private MovieDAO dao;
	
	// 사용자 요청 처리 
	@RequestMapping("movie/list.do")
	public String movie_list(String page,Model model)
	{
		if(page==null)
			page="1"; // 오류 방지 
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
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
	@RequestMapping("movie/detail.do")
	public String movie_detail(int mno,Model model)
	{
		MovieVO vo=dao.movieDetailData(mno);
		model.addAttribute("vo", vo);
		return "movie/detail";
	}
	@RequestMapping("movie/find.do")
	public String movie_find(String title,Model model)
	{
		if(title!=null)
		{
		  List<MovieVO> list=dao.movieFindData(title);
		  model.addAttribute("list",list);
		}
		return "movie/find";
	}
}

















