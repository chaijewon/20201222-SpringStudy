package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;
import java.util.*;
@Controller
public class BoardController {
   @Autowired
   private BoardService service;
   
   
   @GetMapping("board/list.do")
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   List<BoardVO> list=service.boardListData(map);
	   int totalpage=service.boardTotalPage();
	   
	   // JSP 전송 
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   
	   return "board/list";
   }
   // 글쓰기
   @GetMapping("board/insert.do")
   public String board_insert()
   {
	   return "board/insert";
   }
   @PostMapping("board/insert_ok.do")
   public String board_insert_ok(BoardVO vo)
   {
	   //DAO연결 
	   service.boardInsert(vo);
	   return "redirect:list.do";
   }
   @GetMapping("board/detail.do")
   public String board_detail(int no,int page,Model model)
   {
	   // 데이터 읽기 => DAO연결 
	   BoardVO vo=service.boardDetailData(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("page", page);
	   return "board/detail";
   }
   @PostMapping("board/find.do")
   public String board_find(String fs,String ss,Model model)
   {
	   FindVO vo=new FindVO();
	   vo.setFs(fs);
	   vo.setSs(ss);
	   Map map=new HashMap();
	   map.put("fs",fs);
	   map.put("ss", ss);
	   map.put("fsArr", vo.getFsArr());
	   List<BoardVO> list=service.boardFindData(map);
	   int count=service.boardFindDataCount(map);
	   model.addAttribute("list", list);
	   model.addAttribute("count", count);
	   return "board/find";
   }
}














