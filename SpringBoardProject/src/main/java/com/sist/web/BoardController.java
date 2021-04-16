package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;

// DispatcherServlet와 연결 => DAO에서 결과값을 전송(ViewResolver)
/*
 *   1. 요청 
 *   2. DispatcherServlet 
 *   3. 요청과 관련된 데이터를 받는다 Model
 *   4. 요청 <==> DAO
 *   5. 결과값을 ViewResolver로 전송 
 */
import java.util.*;
@Controller
public class BoardController {
   // 데이터베이스 연결 => DAO의 객체 얻기
   @Autowired // 자동 주입 => 스프링에서 BoardDAO객체주소를 찾아서 자동으로 주입
   private BoardDAO dao;
   /*
    *   GET  ==> GetMapping()
    *   POST ==> PostMapping()
    *   ======================= +
    *      RequestMapping()
    */
   // 기능 출력 
   @GetMapping("board/list.do")
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1"; // default 
	   int curpage=Integer.parseInt(page);
	   // start,end
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   // WHERE num BETWEEN #{start} AND #{end} => Map을 지정하는 경우에는 반드시 키명을 설정
	   List<BoardVO> list=dao.boardListData(map);
	   int totalpage=dao.boardTotalpage();
	   // ViewResolver로 데이터를 전송 
	   model.addAttribute("list", list); // => request.setAttribute("list", list)
	   model.addAttribute("curpage", curpage);// => request.setAttribute("curpage", curpage)
	   model.addAttribute("totalpage", totalpage);// => request.setAttribute("totalpage", totalpage)
	   return "board/list";
   }
   @GetMapping("board/detail.do")
   public String board_detail(int no,Model model)
   {
	   BoardVO vo=dao.boardDetailData(no);
	   model.addAttribute("vo", vo);
	   return "board/detail";
   }
   @GetMapping("board/insert.do")
   public String board_insert()
   {
	   return "board/insert";
   }
   @PostMapping("board/insert_ok.do")
   public String board_insert_ok(BoardVO vo)
   {
	   dao.boardInsert(vo);
	   return "redirect:list.do"; // 목록
   }
   @GetMapping("board/update.do")
   public String board_update(int no,Model model)
   {
	   //DAO연동 
	   BoardVO vo=dao.boardUpdateData(no);
	   model.addAttribute("vo", vo);
	   return "board/update";
   }
   // @Controller => return시 반드시 파일명,.do ==> @RestController를 사용해서 스크립트 전송
   @PostMapping("board/update_ok.do")
   public String board_update_ok(BoardVO vo,Model model)
   {
	   // 결과값 전송 => 비밀번호 체크 
	   boolean bCheck=dao.boardUpdate(vo);
	   model.addAttribute("no", vo.getNo());
	   model.addAttribute("bCheck", bCheck);
	   return "board/update_ok";
   }
}
















