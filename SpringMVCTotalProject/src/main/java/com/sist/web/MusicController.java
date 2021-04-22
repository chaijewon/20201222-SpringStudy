package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

import javax.annotation.Resource;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class MusicController {
   // MusicDAO => 스프링안에서 설정후 메모리 할당 
   @Resource(name="musicDAO")
   private MusicDAO dao;
   
   @GetMapping("music/list.do")
   public String music_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=50;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   List<MusicVO> list=dao.musicListData(map);
	   // 총페이지 받기
	   int totalpage=dao.musicTotalPage();
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "../music/list.jsp");
	   return "main/main";
   }
}










