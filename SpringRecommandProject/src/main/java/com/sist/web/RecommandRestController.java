package com.sist.web;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.MovieDAO;
import com.sist.dao.MovieVO;
import com.sist.naver.NaverManager;

/*
 *   상황
	휴식 드라이브 산책 집 출/퇴근길 휴가/여행 운동 하우스파티 시상식 일/공부 카페 거리 클럽 고백 해변 공연 라운지 애도
	감성
	외로움 기분전환 슬픔 힘찬 이별 지침/힘듦 설렘 오후 밤 새벽 저녁 아침 사랑 스트레스/짜증 그리움 추억 우울 행복 불안 분노 기쁨 축하
	스타일
	밝은 신나는 따뜻한 편안한 그루브한 부드러운 로맨틱한 매혹적인 영화음악 잔잔한 댄서블한 달콤한 몽환적인 시원한 애절한 어두운 연주음악 발렌타인데이 화이트데이
	날씨/계절
	봄 여름 가을 겨울 맑은날 추운날 흐린날 비오는날 더운날 안개낀날 눈오는날
 */
@RestController
public class RecommandRestController {
   @Autowired
   private NaverManager mgr;
   
   @Autowired
   private MovieDAO dao;
   
   @PostMapping("movie/category_sub.do")
   public String category_sub(int no)
   {
	   String json="";
	   System.out.println("no="+no);
	   if(no==1)
	   {
		   String[] data={"휴식","드라이브","산책","집", "출근길","퇴근길", "휴가","여행", "카페", "거리","고백","해변"};
		   JSONArray arr=new JSONArray();
		   for(String s:data)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("subject", s);
			   arr.add(obj);
		   }
		   json=arr.toJSONString();
	   }
	   else if(no==2)
	   {
		   String[] data={"외로움","기분전환","슬픔","힘찬", "이별", "지침", "설렘","오후","밤", "새벽",
				           "저녁","아침","사랑", "스트레스","짜증","그리움", "추억", "우울", "행복", "불안",
				           "분노", "기쁨", "축하"};
		   JSONArray arr=new JSONArray();
		   for(String s:data)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("subject", s);
			   arr.add(obj);
		   }
		   json=arr.toJSONString();
	   }
	   else if(no==3)
	   {
		   String[] data={"밝은","신나는","따뜻한","편안한", "부드러운", "로맨틱한",
				                   "매혹적인","잔잔한", "달콤한","시원한", "애절한"};
		   JSONArray arr=new JSONArray();
		   for(String s:data)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("subject", s);
			   arr.add(obj);
		   }
		   json=arr.toJSONString();
	   }
	   else if(no==4)
	   {
		   String[] data={"봄","여름","가을","겨울", "맑은날", "추운날", "흐린날","비오는날", "더운날", "눈오는날"};
		   JSONArray arr=new JSONArray();
		   // 베일리*
		   for(String s:data)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("subject", s);
			   arr.add(obj);
		   }
		   json=arr.toJSONString();
	   }
	   System.out.println(json);
	   
	   return json;
   }
   
   @PostMapping("movie/recommand_data.do")
   public String recommand_data(String fd)
   {
	   System.out.println("접속");
	   String json="";
	   try
	   {
		   List<String> list=mgr.naverBlogData(fd);
		   List<String> tList=dao.movieGetTitleData(); // tList=Aarrys.asList(data)
		   for(String s:tList)
		   {
			   System.out.println(s);
		   }
		   int[] count=new int[tList.size()];
		   Pattern[] p=new Pattern[tList.size()];
		   for(int i=0;i<p.length;i++)
		   {
			   p[i]=Pattern.compile(tList.get(i));
		   }
		   Matcher[] m=new Matcher[tList.size()];
		   for(String desc:list)
		   {
			   for(int i=0;i<m.length;i++)
			   {
				   m[i]=p[i].matcher(desc);
				   while(m[i].find())
				   {
					   count[i]++;
				   }
				   /*String title=tList.get(i);
				   //System.out.println(desc);
				   //System.out.println(title);
				   if(desc.contains(title))
				   {
					   count[i]++;
					   System.out.println(count[i]);
				   }*/
			   }
		   }
		   
		   List<MovieVO> mList=new ArrayList<MovieVO>();
		   for(int i=0;i<count.length;i++)
		   {
			   if(count[i]>0)
			   {
				   MovieVO vo=dao.movieData(tList.get(i));
				   //System.out.println(vo.getTitle());
				   mList.add(vo);
			   }
		   }
		   
		   JSONArray arr=new JSONArray();
		   for(MovieVO vo:mList)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("mno", vo.getMno());
			   obj.put("title", vo.getTitle());
			   obj.put("poster", vo.getPoster());
			   
			   arr.add(obj);
		   }
		   json=arr.toJSONString();
		   //System.out.println(json);
	   }catch(Exception ex){}
	   return json;
   }
}








