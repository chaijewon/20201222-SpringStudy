package com.sist.web;
// <jsp:include> => 대신하는 라이브러리 Tiles

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {
   @RequestMapping("notice/list.do")
   public String notice_list()
   {
	   return "notice/list";
   }
}
