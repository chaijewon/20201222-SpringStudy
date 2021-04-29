package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.*;
import java.util.*;

import javax.servlet.http.HttpSession;
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
	   List<ReplyVO> rList=service.replyListData(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("page", page);
	   model.addAttribute("rList", rList);
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
   /*
    *   사용자 
    *    1)          2)                   3)
    *   .do  ==> BoardController <==> BoardDAO <==> 오라클
    *                | Model  4)
    *              ViewResolver
    *                | request 5)
    *               JSP
    */
   // Error 405(get/post)
   @GetMapping("board/update.do")
   public String board_update(int no,int page,Model model)
   {
	   // 결과값 
	   BoardVO vo=service.boardUpdateData(no);
	   // 데이터연동 (DAO)
	   // 데이터를 JSP로 전송
	   model.addAttribute("vo", vo);
	   model.addAttribute("page", page);
	   return "board/update";
   }
   @PostMapping("board/update_ok.do")
   public String board_update_ok(BoardVO vo,int page,Model model)
   {
	   //데이터베이스 연동 
	   boolean bCheck=service.boardUpdate(vo);
	   // update_ok.jsp => 결과값을 보내서 사용자가 볼 수 있게 만든다 
	   model.addAttribute("bCheck",bCheck);
	   model.addAttribute("no", vo.getNo());
	   model.addAttribute("page", page);
	   return "board/update_ok";
   }
   
   @GetMapping("board/delete.do")
   public String board_delete(int no,int page,Model model)
   {
	   model.addAttribute("no", no);
	   model.addAttribute("page", page);
	   return "board/delete";
   }
   
   @PostMapping("board/delete_ok.do")
   public String board_delete_ok(int no,int page,String pwd,Model model)
   {
	   // 결과값 읽기 
	   System.out.println("pwd="+pwd+",no="+no);
	   boolean bCheck=service.boardDelete(no, pwd);
	   System.out.println("bCheck="+bCheck);
	   // delete_ok.jsp로 결과값을 전송 => 사용자가 볼 수 있게 처리 
	   model.addAttribute("bCheck", bCheck);
	   model.addAttribute("page", page); // list.jsp => no(X) , page(O)
	   return "board/delete_ok";
   }
   
   @PostMapping("board/reply_insert.do")
   public String board_reply_insert(int bno,String msg,int page,RedirectAttributes ra,HttpSession session)
   {
	   ReplyVO vo=new ReplyVO();
	   vo.setBno(bno);
	   vo.setMsg(msg);
	   String name=(String)session.getAttribute("name");
	   String id=(String)session.getAttribute("id");
	   vo.setName(name);
	   vo.setId(id);
	   
	   // ReplyDAO로 전송 
	   service.replyInsert(vo);
	   ra.addAttribute("no", bno);
	   ra.addAttribute("page", page);
	   return "redirect:detail.do"; // detail.do?no=1&page=1
   }
   
   @PostMapping("board/reply_update.do")
   public String board_reply_update(int no,int bno,int page,String msg,RedirectAttributes ra)
   {
	   // 수정 => DAO
	   ReplyVO vo=new ReplyVO();
	   vo.setNo(no);
	   vo.setMsg(msg);
	   service.replyUpdate(vo);
	   // 수정 후에 데이터를 보내준다 
	   ra.addAttribute("no",bno);
	   ra.addAttribute("page",page);
	   return "redirect:detail.do";
   }
   
   @PostMapping("board/reply_to_reply_insert.do")
   public String board_reply_to_reply(int pno,ReplyVO vo,int page,RedirectAttributes ra,HttpSession session)
   {
	   // 댓글 추가 작업 ==> DAO
	   String name=(String)session.getAttribute("name");
	   String id=(String)session.getAttribute("id");
	   vo.setName(name);
	   vo.setId(id);
	   service.replyToReplyInsert(pno, vo);
	   ra.addAttribute("no", vo.getBno());
	   ra.addAttribute("page", page);
	   return "redirect:detail.do";
   }
   
   @GetMapping("board/reply_delete.do")
   public String board_reply_delete(int no,int bno,int page,RedirectAttributes ra)
   {
	   // 삭제 처리 ==> DAO(service)
	   service.replyDelete(no);
	   ra.addAttribute("no", bno);
	   ra.addAttribute("page", page);
	   return "redirect:detail.do";
   }
   
   
}














