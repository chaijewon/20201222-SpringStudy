package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.annotation.Resource;

import com.sist.dao.*;
import com.sist.vo.*;
@RestController
public class FoodRestController {
   // FoodDAO 스프링으로 부터 받아 온다 
   @Resource(name="foodDAO")
   private FoodDAO dao;
   
   @PostMapping("food/food_list.do")
   public String food_food_list(int no)
   {
	   String json="";
	   try
	   {
		   List<FoodVO> list=dao.categoryFoodListData(no);
		   // 카테고리 (no) , Food(cno)
		   JSONArray arr=new JSONArray();
		   /*
		    *    FoodVO => {} 
		    *    List<FoodVO> => [{},{},{}]
		    *    
		    *    => [] => JSONArray
		    *    => {} => JSONObject
		    *    
		    *    no,poster,address,tel,score
		    *    {"no":vo.getNo(),"poster":vo.getPoster()}
		    */
		   for(FoodVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("no", vo.getNo());
			   String poster=vo.getPoster();
			   poster=poster.substring(0,poster.indexOf("^"));
			   obj.put("poster", poster);
			   String addr=vo.getAddress();
			   addr=addr.substring(0,addr.lastIndexOf("지"));
			   obj.put("address", addr);
			   obj.put("tel",vo.getTel());
			   obj.put("score",vo.getScore());
			   obj.put("title", vo.getTitle());
			   arr.add(obj);
		   }
		   
		   json=arr.toJSONString();
	   }catch(Exception ex){}
	   return json;
   }
   
   
}










