package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

// JSP로 요청한 데이터를 보낸다 
import java.util.*;

import javax.annotation.Resource;

import com.sist.dao.*;
@Controller
public class DataBoardController {
   // 요청 처리 => DataBoardDAO의 객체를 스프링으로 얻어 온다 
   @Resource(name="dataBoardDAO")
   private DataBoardDAO dao;
   
   // 목록 요청 처리 : String 리턴형 => "어떤 파일에 보여주는 확인" 
   public String databoard_list(String page,Model model)
   {
	   return "databoard/list";
   }
   // 데이터 추가  : 출력 화면 => String
   public String databoard_insert()
   {
	   return "databoard/insert";
   }
   public String databoard_insert_ok(DataBoardVO vo)
   {
	   return "redirect:list.do";
   }
   // 상세보기 : 출력 화면 => String
   public String databoard_detail(int no,Model model)
   {
	   return "databoard/detail";
   }
   // 다운로드 : void
   public void databoard_download(String fn)
   {
	   
   }
}



















