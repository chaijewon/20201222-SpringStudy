package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class ShopController {
   @Autowired
   private ShopDAO dao;
   
   @GetMapping("shop/list.do")
   public String shop_list(String page,String cno,Model model)
   {
	   if(cno==null)
		   cno="45";
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=18;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   
	   map.put("start", start);
	   map.put("end", end);
	   map.put("cno", Integer.parseInt(cno));
	   List<ShopVO> list=dao.shopGoodsListData(map);
	   for(ShopVO vo:list)
	   {
		   String s=vo.getTitle();
		   if(s.length()>13)
		   {
			   s=s.substring(0,13)+"...";
			   vo.setTitle(s);
		   }
	   }
	   int totalpage=dao.shopGoodsTotalPage(Integer.parseInt(cno));
	   model.addAttribute("main_jsp", "../shop/list.jsp");
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("cno", cno);
	   return "main/main";
   }
}





