package com.sist.json;

import org.springframework.stereotype.Component;
/*
 *  일일 박스오피스 searchMainDailyBoxOffice.do
 *  실시간 예매율 searchMainRealTicket.do
 *  좌석점유율순위 searchMainDailySeatTicket.do
 *  온라인상영관 일일  searchMainOnlineDailyBoxOffice.do
 *  
 *  https://www.kobis.or.kr/kobis/business/main/main.do
 */
import java.util.*;
import java.net.*;
import java.io.*;
@Component
public class JSONManager {
   public String jsonRead(int no)
   {
	   String json="";
	   String strUrl="";
	   switch(no)
	   {
	   case 1:
		   strUrl="searchMainDailyBoxOffice.do";
		   break;
	   case 2:
		   strUrl="searchMainRealTicket.do";
		   break;
	   case 3:
		   strUrl="searchMainDailySeatTicket.do";
		   break;
	   case 4:
		   strUrl="searchMainOnlineDailyBoxOffice.do";
		   break;
	   }
	   
	   try
	   {
		   URL url=new URL("https://www.kobis.or.kr/kobis/business/main/"+strUrl);
		   HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		   if(conn!=null) // 사이트와 연결이 되었다면 
		   {
			   BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			   while(true)
			   {
				   String data=br.readLine();
				   if(data==null)break;
				   json+=data;
			   }
			   br.close();
		   }
		   System.out.println(json);
	   }catch(Exception ex){}
	   
	   return json;
   }
   public static void main(String[] args) {
	  JSONManager jm=new JSONManager();
	  jm.jsonRead(1);
   }
}
















