package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class FoodController {
    // FoodDAO => 스프링안에 저장
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("food/list.do")
	public String food_list(String no,Model model)
	{
		if(no==null)
			no="1";
		List<CategoryVO> list=dao.categoryListData(Integer.parseInt(no));
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../food/list.jsp");
		return "main/main";
	}
	
	@GetMapping("food/food_detail.do")
	public String food_detail(int no,Model model)
	{
		FoodVO vo=dao.foodDetailData(no);
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../food/food_detail.jsp");
		return "main/main";
	}
}













