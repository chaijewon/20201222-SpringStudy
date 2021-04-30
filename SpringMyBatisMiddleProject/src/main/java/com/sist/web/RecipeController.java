package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class RecipeController {
	@Autowired
    private RecipeDAO rDao;
	
	@GetMapping("recipe/list.do")
	public String recipe_list(String page,Model model)
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
		// 목록
		List<RecipeVO> list=rDao.recipeListData(map);
		for(RecipeVO vo:list)
		{
			String s=vo.getTitle();
			if(s.length()>15)
			{
				s=s.substring(0,15)+"...";
				vo.setTitle(s);
			}
		}
		// 총페이지
		int totalpage=rDao.recipeTotalPage();
		// BLOCK 단위 
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		/*
		 *   1~10page => startPage=1 , endPage=10
		 *   11~20page => startPage=11 , endPage=20
		 *   
		 *   totalpage=19 
		 */
		int allPage=totalpage;
		if(endPage>allPage)
		{
			endPage=allPage;
		}
		
		int count=rDao.recipeCount();
		// JSP에 출력할 데이터를 전송 
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("BLOCK",BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("count", count);
		return "recipe/list";
	}
}














