package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
@RestController
public class ShopRestController {
	   @Autowired
	   private ShopDAO dao;
	   @GetMapping(value="vuejs/shop_list.do",produces="text/plain;charset=UTF-8")
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
		   JSONArray arr=new JSONArray();
		   for(ShopVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("no",vo.getNo());
			   obj.put("title",vo.getTitle());
			   obj.put("poster",vo.getPoster());
			   obj.put("price",vo.getPrice());
			   arr.add(obj);
		   }
		   
		   return arr.toJSONString();
	   }
}







