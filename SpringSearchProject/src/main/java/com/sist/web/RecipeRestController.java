package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
@RestController
public class RecipeRestController {
	  @Autowired
      private RecipeDAO dao;
	  @PostMapping("recipe/find_ok.do")
	  public String recip_find_ok(FindVO vo)
	  {
		  // DAO연결
		  Map map=new HashMap();
		  map.put("keyword", vo.getSs());
		  map.put("fdArr", vo.getFdArr());
		  List<RecipeVO> list=dao.recipeFindData(map);
		  JSONArray arr=new JSONArray(); // list => []  ==> [{},{},{},{}...]
		  for(RecipeVO rvo:list)
		  {
			  JSONObject obj=new JSONObject(); // vo => {}
			  obj.put("no", rvo.getNo());
			  obj.put("poster", rvo.getPoster());
			  obj.put("title", rvo.getTitle());
			  obj.put("chef", rvo.getChef());
			  arr.add(obj);
		  }
		  return arr.toJSONString();
	  }
}











