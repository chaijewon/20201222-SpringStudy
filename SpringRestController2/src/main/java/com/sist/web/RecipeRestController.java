package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
@RestController
public class RecipeRestController {
	@Autowired
    private RecipeDAO dao;
	
	@GetMapping("recipe/recipe_list.do")//Ajax로 전송 
	public String recipe_list(String page)
	{
		String json="";
		try
		{
			if(page==null)
				page="1";
			int curpage=Integer.parseInt(page);
			Map map=new HashMap();
			int rowSize=12;
			int start=(rowSize*curpage)-(rowSize-1);
			int end=rowSize*curpage;
			// Model =>(list) jsp전송 => HTML에 출력 => 파일자체를 읽어서 출력 
			// JSON => javascript로 출력 
			map.put("start", start);
			map.put("end", end);
			List<RecipeVO> list=dao.recipeListData(map);
			int totalpage=dao.recipeTotalPage();
			int count=dao.recipeCount();
			
			final int BLOCK=10;
			int startPage=((curpage-1)/BLOCK*BLOCK)+1; // 1~10 => startPage=1 , 11~20 => 11
			int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK; // 1~10 => endPage=10, 11~20 => 20
			if(endPage>totalpage)
				endPage=totalpage;
			// list=>JavaScript인식 => JSON
			// [{1,2,3,4,5},{1,2,3},{1,2,3}...]
			JSONArray arr=new JSONArray();
			int i=0;
			for(RecipeVO vo:list)
			{
				JSONObject obj=new JSONObject();
				obj.put("no", vo.getNo());
				obj.put("title", vo.getTitle());
				obj.put("poster", vo.getPoster());
				obj.put("chef", vo.getChef());
			    if(i==0)
			    {
				    obj.put("curpage", curpage);
			        obj.put("totalpage", totalpage);
				
			        obj.put("BLOCK", BLOCK);
					obj.put("startPage", startPage);
					obj.put("endPage", endPage);
					obj.put("count", count);
			    }
				arr.add(obj);
				i++;
			}
			json=arr.toJSONString();
		}catch(Exception ex){}
		return json;
	}
	
	@GetMapping("recipe/detail.do")
	public String recipe_detail(int no)
	{
		String json="";
		try
		{
			//{}
			RecipeDetailVO vo=dao.recipeDetailData(no);
			// vo=>{}(JSONObject) list=>[{},{},{}..](JSONArray)
			JSONObject obj=new JSONObject();
			/*
			 *  POSTER      NOT NULL VARCHAR2(260)  
				CHEF        NOT NULL VARCHAR2(200)  
				CHEF_POSTER NOT NULL VARCHAR2(260)  
				TITLE       NOT NULL VARCHAR2(2000) 
				CONTENT     NOT NULL VARCHAR2(4000) 
				INFO1       NOT NULL VARCHAR2(20)   
				INFO2       NOT NULL VARCHAR2(20)   
				INFO3       NOT NULL VARCHAR2(20)   
				FOOD_MAKE   NOT NULL CLOB           
				CHEF_INFO   NOT NULL VARCHAR2(1000) 
			 */
			obj.put("poster", vo.getPoster());
			obj.put("chef", vo.getChef());
			obj.put("chef_poster", vo.getChef_poster());
			obj.put("title", vo.getTitle());
			obj.put("content", vo.getContent());
			obj.put("info1", vo.getInfo1());
			obj.put("info2", vo.getInfo2());
			obj.put("info3", vo.getInfo3());
			obj.put("food_make",vo.getFood_make());
			obj.put("chef_info", vo.getChef_info());
			
			json=obj.toJSONString();
		}catch(Exception ex){}
		return json;
	}
}














