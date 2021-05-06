package com.sist.web;
import java.util.*;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.*;
@RestController
// 일반 문자열 , 객체 (자바스크립트 객체: 객체표현 => JSON)
public class MovieRestController {
   @Autowired
   private MovieDAO dao;
   
   @GetMapping("movie/detail.do")
   // @RestController : 일반 문자열 전송 , JSON전송 , 자바스크립트 , XML => _ok.jsp
   public String movie_detail(int mno)
   {
	   String json="";
	   try
	   {
		   MovieVO vo=dao.movieDetailData(mno);
		   //{} => vo , [{},{},{}...] => List
		   // {} => JSONObject  , [{},{}...] => JSONArray
		   JSONObject obj=new JSONObject();
		   // {mno:1,title:'',....}
		   obj.put("mno", vo.getMno());
		   obj.put("title", vo.getTitle());
		   obj.put("poster", vo.getPoster());
		   obj.put("genre", vo.getGenre());
		   obj.put("director", vo.getDirector());
		   obj.put("actor", vo.getActor());
		   obj.put("story", vo.getStory());
		   
		   // 문자열로 변환 
		   json=obj.toJSONString();
		   System.out.println(json);
	   }catch(Exception ex){}
	   return json;
   }
}











