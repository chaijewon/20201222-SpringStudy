package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*
 *   # Spring MVC 
 *     = 주고(요청) 받기(응답)
 *     = 동작 순서 
 *     = 요청받는 메소드(매개변수)
 *     = Model에 값을 담아서 어떻게 전송  
 *   .do?no=10 
 *           일반데이터를 받는 경우에는 변수명,키명을 반드시 동일하게 한다 
 *           => public String list(int no) , (String no) => 첫페이지 출력
 *           => HttpSession 
 *              public String login(HttpSession session),(HttpServletRequest request)
 *           => Cookie 
 *              public String cookie(Cookie[] cookie),(HttpServletRequest request)
 *           => HttpServletResponse 
 *              public String upload(HttpServletResponse response)
 *           => 데이터를 여러개 받는 경우 : ~VO (글쓰기,회원가입)
 *              public String insert(BoardVO vo)
 *           => request에 값을 추가해서 전송 => 데이터를 묶어서 전송 (데이터 전달자 : Model)
 *              
 *   
 *           request             요청데이터만 넘겨준다 (매개변수)
 *   .do(요청) => DispatcherServlet <==> @Controller <=> DAO 
 *                     |        Model에 담아서 전송         결과값 얻기
 *                  ViewResolver 
 *                     |  Model => request변경
 *                    JSP (해당 JSP)
 *                     |
 *                  실행을 한 다음에 버퍼에 HTML만 저장 
 *                     |
 *                   버퍼에 있는 내용을 브라우저가 읽어서 한줄씩 번역 (인터프리터)
 *    
 *   Controller : 파일명 (화면 이동) 
 *        메소드 제작시에 리턴형 
 *        ================
 *        1) String : 화면이동 
 *           = forward : return "경로명/파일이름(jsp)"; => request에 값을 추기해서 전송
 *           = sendRedirect : return "redirect:~.do"; => request초기화
 *        2) void : 화면이동 없이 처리(다운로드...)
 *   RestController : 화면이동(X)=>데이터 변경 (JSON,XML)
 */
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.MovieDAO;
import com.sist.vo.*;
import java.util.*;
@Controller
public class MainController {
   // MovieDAO => 설정된 MovieDAO를 스프링이 가지고 있다 
   // 스프링에서 생성된 MovieDAO 객체 주소를 주입요청 (자동 주입)
   // 자동주입 @Autowired, 지정된 객체주소 주입 @Resource(name="id")
   // 어노테이션으로 id를 지정할 경우
   /*
    *    @Repository
    *    public class MovieDAO
    *    {
    *    }
    *    => 자동ID를 부여 => movieDAO
    *       @Resource(name="movieDAO")
    *    @Repository("mdao")
    *    public class MovieDAO
    *    {
    *    }
    *    => ID=>mdao
    *       @Resource(name="mdao")
    *    
    */
   // @Resource(name="movieDAO")
   @Autowired
   private MovieDAO dao;
   
   @GetMapping("main/main.do")
   public String main_main(String page,String cno,Model model)
   {
	   if(page==null)
		   page="1";
	   if(cno==null)
		   cno="1";// 현재 상영 영화 
	   
	   int curpage=Integer.parseInt(page);
	   int cateno=Integer.parseInt(cno);
	   
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   
	   map.put("start", start);
	   map.put("end", end);
	   map.put("cno", cateno);
	   
	   List<MovieVO> list=dao.movieListData(map);
	   int totalpage=dao.movieTotalPage(cateno);
	   
	   // 전송(JSP)
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list",list);
	   model.addAttribute("cno",cateno);
	   // include파일 
	   model.addAttribute("main_jsp", "../movie/list.jsp");
	   
	   return "main/main";
   }
   @GetMapping("movie/detail.do")
   public String movie_detail(int mno,Model model)
   {
	   MovieVO vo=dao.movieDetailData(mno);
	   String story=vo.getStory();
	   if(story.length()>200)
	   {
		   story=story.substring(0,200)+"...";
		   vo.setStory(story);
	   }
	   model.addAttribute("vo",vo);
	   model.addAttribute("main_jsp","../movie/detail.jsp");
	   return "main/main";
   }
}







