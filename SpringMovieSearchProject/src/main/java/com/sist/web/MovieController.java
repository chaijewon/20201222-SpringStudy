package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class MovieController {
   @Autowired
   private MovieDAO dao;
   
   @GetMapping("movie/find.do")
   public String movie_find()
   {
	   return "movie/find";
   }
   
   @PostMapping("movie/find_ok.do")
   public String movie_find_ok(String[] data,String ss,Model model)
   {
	   /*
	    *   <foreach collection="movieArr" item="a">  for(MovieVO m12:list)
		     <trim prefix="OR">
		      <choose>
		        <when test="type=='T'.toString()">
		          title LIKE '%'||#{keyword}||'%'
		        </when>
	    */
	   Map map=new HashMap();
	   map.put("movieArr", data);
	   map.put("keyword", ss);
	   List<MovieVO> list=dao.movieFindData(map);
	   model.addAttribute("list", list);
	   return "movie/find";
   }
}









