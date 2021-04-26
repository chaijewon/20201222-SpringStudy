package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
// _ok.jsp실행하는 경우 (update,delete => 비밀번호가 검색후...) => JSON,일반 문자열 , Ajax,VueJS
// 페이지 이동(@Controller)이 아니라 실제 데이터값 전송 (한글 변환을 반드시 체크)
@RestController  
// @ResponseBody => 모바일,Front연결 => JSON => 변경(승격) @RestController
public class FreeBoardRestController {
   // DAO가 필요하다(스프링에서 관리하는 클래스 => 특별한 경우가 아닐때 싱글턴(메모리 할당을 1번 해서 재사용:디자인 패턴)
   /*
    *   디자인 패턴 (23개) => GOF패턴 
    *   스프링에서는 8개 사용 
    *     = 싱글턴 
    *     = 팩토리 (lookup=>getBean()) => DriverManager
    *     = POJO => 필요한 경우에 형변환 ( Adapter 패턴 )
    *     = MVC 패턴 
    *     = 프록시패턴 (대신 호출:대리자) : AOP
    */
   @Autowired
   private FreeBoardDAO fDao;
   
   @PostMapping("board/update_ok.do")
   public String board_update_ok(FreeBoardVO vo,int page)
   {
	   String result="";
	   // 비밀번호가 O(상세보기 이동) , X(자바스크립트 history.back())
	   boolean bCheck=fDao.freeboardUpdate(vo);
	   // 결과값을 가지고 올때 DAO를 연결 
	   if(bCheck==true)
	   {
		   result="<script>location.href=\"../board/detail.do?no="+vo.getNo()+"&page="+page+"\";</script>";
	   }
	   else
	   {
		   result="<script>alert(\"비밀번호가 틀립니다!!\");history.back();</script>";
	   }
	   return result;
   }
}









