package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class RecipeController {
    // RecipeDAO + ChefDAO = RecipeService
	@Autowired
	private RecipeService service;
	
	@RequestMapping("recipe/list.do")
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
		   List<RecipeVO> list=service.recipeListData(map);
		   // 총페이지 읽기
		   int totalpage=service.recipeTotalPage();
		   
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
		model.addAttribute("main_jsp", "../recipe/list.jsp");
		return "main/main";
	}
	@RequestMapping("recipe/detail.do")
	public String recipe_detail(int no,Model model)
	{
		RecipeDetailVO vo=service.recipeDetailData(no);
		model.addAttribute("vo", vo);
		return "recipe/detail";
	}
	@RequestMapping("recipe/chef_list.do")
	public String recipe_chef_list(String page,Model model)
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
		   // 
		   List<ChefVO> list=service.chefListData(map);
		   // 총페이지 읽기
		   int totalpage=service.chefTotalPage();
		   
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
		model.addAttribute("main_jsp", "../recipe/chef_list.jsp");
		return "main/main";
	}
	//../recipe/chef_make.do?chef=${vo.chef_name }
	@RequestMapping("recipe/chef_make.do")
	public String recipe_chef_make(String page,String chef,Model model)
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
		map.put("chef", chef);
		
		List<RecipeVO> list=service.chefMakeRecipeData(map);
		for(RecipeVO vo:list)
		{
			String s=vo.getTitle();
			if(s.length()>12)
			{
				s=s.substring(0,12)+"...";
				vo.setTitle(s);
			}
		}
		int totalpage=service.chefMakeRecipeTotalPage(chef);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1; //curpage=1~10 => 1 블록 시작위치 
		   // [1][2]...[9]
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		   
		int allPage=totalpage;
		if(endPage>allPage)
			 endPage=allPage;
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("BLOCK", BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("chef", chef);
		model.addAttribute("main_jsp", "../recipe/chef_make.jsp");
		return "main/main";
	}
	
}














