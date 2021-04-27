package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
import java.text.*;
@Controller
public class FreeBoardController {
   // DAO 로딩 (이미 생성된 객체 주소를 얻어 온다
   @Autowired
   private FreeBoardDAO fDao;
   
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
	   List<FreeBoardVO> list=fDao.freeboardListData(map);
	   // 총페이지 가지고 오기 
	   int totalpage=fDao.freeboardTotalPage();
	   
	   final int BLOCK=5;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   /*
	    *    curpage=1
	    *       startPage=1 , endPage=5
	    *    curpage=2
	    *       startPage=1 , endPage=5
	    *       --
	    *       --
	    *    curpage=5
	    *       startPage=1 , endPage=5
	    *    startPage = 1,6,11,16...
	    *    endPage = 5,10,15,20...
	    *    
	    *    ==> 13
	    */
	   int allPage=totalpage;
	   if(endPage>allPage)
	   {
		   endPage=allPage;
	   }
	   
	   String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	   // Model => JSP 데이터를 묶어서 전송하는 전달자 
	   model.addAttribute("list", list);
	   model.addAttribute("curpage",curpage);
	   model.addAttribute("allPage", allPage);
	   model.addAttribute("BLOCK", BLOCK);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("today", today);
	   return "board/list";
   }
   
   @GetMapping("board/insert.do")
   public String board_insert()
   {
	   return "board/insert";
   }
   
   @PostMapping("board/insert_ok.do")
   public String board_insert_ok(FreeBoardVO vo)
   {
	   // DAO연결 
	   fDao.freeboardInsert(vo);

	   return "redirect:../board/list.do";
   }
   
   @GetMapping("board/detail.do")
   public String board_detail(int no,int page,Model model)
   {
	   // DAO연결
	   FreeBoardVO vo=fDao.freeboardDetailData(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("page", page);// 목록에서 보고 있던 페이지로 이동 
	   return "board/detail";
   }
   
   @GetMapping("board/update.do")
   public String board_update(int no,int page,Model model)
   {
	   // 이전에 입력된 데이터 전송 => FreeBoardVO => 오라클 => FreeBoardDAO();
	   // FreeBoardDAO => SQL(mapper)
	   FreeBoardVO vo=fDao.freeboardUpdateData(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("page", page);
	   return "board/update";
   }
   
   @PostMapping("board/find.do")
   public String board_find(String type,String ss,Model model)
   {
	   FindVO vo=new FindVO();
	   vo.setType(type);
	   vo.setSs(ss);
	   List<FreeBoardVO> fList=fDao.freeboardFindData(vo);
	   model.addAttribute("fList", fList);
	   return "board/find";
   }
}
















