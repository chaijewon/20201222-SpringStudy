package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
// Model => Controller
/*
 *   DispatcherServlet : Front Controller => 요청 제어 
 *   Model : Controller=요청 처리한 결과를 제어 
 */
@Controller
public class MusicController {
   @Autowired
   private MusicDAO dao;
   /*
    *    class Model
    *    {
    *       HttpServletRequest request;
    *       public void addAttribute(String key,Object obj)
    *       {
    *           request.setAttribute(key,obj)
    *       }
    *    }
    */
   @RequestMapping("music/list.do")
   public String music_list(Model model)
   {
	   List<MusicVO> list=dao.musicAllData();
	   model.addAttribute("list", list); // ==> JSP로 넘아갈때 변환 request.setAttribute() 
	   //Model => JSP로 데이터를 전송하는 역할 
	   return "music/list";
   }
}










