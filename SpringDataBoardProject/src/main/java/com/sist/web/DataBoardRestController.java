package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import java.util.*;
import java.io.*;
// 스프링에서 주입하는 모든 객체는 싱글턴을 이용한다 : 여러 클래스에서 사용한다(같은 메모리 주소를 사용)
// Model을 이용하지 않는다 => delete.jsp에 스크립트 보내서 처리 => AJAX,VueJS(axios:JSON)
// 크롬에서만 실행된다 
@RestController
public class DataBoardRestController {
   @Autowired
   private DataBoardDAO dao;
   
   @RequestMapping(value="databoard/delete_ok.do")
   public String databoard_delete_ok(int no,String pwd)
   {
	   String msg="";
	   // 데이터베이스에 저장된 파일정보를 받는다 
       DataBoardVO vo=dao.databoardFileInfoData(no);
       boolean bCheck=dao.databoardDelete(no, pwd);
       if(bCheck==true)
       {
    	   // 파일 지우기 => list.do이동
    	   msg="<script>location.href=\"list.do\";</script>";
    	   try
    	   {
    		   if(vo.getFilecount()!=0)// 파일이 있는 경우에만 삭제
    		   {
    			   StringTokenizer st=new StringTokenizer(vo.getFilename(),",");
    			   while(st.hasMoreTokens())
    			   {
    				   File file=new File("c:\\spring-upload\\"+st.nextToken());
    				   file.delete();
    			   }
    			   
    		   }
    	   }catch(Exception ex){}
       }
       else
       {
    	   // 스트립트 => 비밀번호가 틀립니다..
    	   msg="<script>"
    		  +"alert(\"비밀번호가 틀립니다!!\");"
    		  +"history.back();"
    		  +"</script>";
       }
	   return msg;
   }
}











