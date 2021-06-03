package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.net.URLEncoder;
// Python,Moblie <===> 다른 프레임워크 
//               JSON,XML ==> {키:값}
/*
 *   JAVA : UTF-8
 *   Python : utf8
 */
/*
 *   searchMainDailyBoxOffice.do
 searchMainRealTicket.do
 searchMainDailySeatTicket.do
 searchMainOnlineDailyBoxOffice.do
 https://www.kobis.or.kr/kobis/business/main/main.do
 */
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.sist.dao.*;
import com.sist.manager.Item;
import com.sist.manager.Rss;
import com.sist.recommand.*;

@RestController
@CrossOrigin("http://127.0.0.1:8000")
public class MovieRestController {
	@Autowired
	private MovieDAO dao;
	@Autowired
	private RecommandManager mgr;
	
	private String[] strUrl={
			"searchMainDailyBoxOffice.do",
			"searchMainRealTicket.do",
			"searchMainRealTicket.do",
			"searchMainOnlineDailyBoxOffice.do"
	};
    @RequestMapping(value="movie/home.do",produces="text/plain;charset=UTF-8")
    public String movie_home(int no)
    {
    	String json="";
    	String url=strUrl[no-1];
    	try
    	{
    		Document doc=Jsoup.connect("https://www.kobis.or.kr/kobis/business/main/"+url).get();
    		//System.out.println(doc.toString());
    		String temp=doc.toString();
    		temp=temp.substring(temp.indexOf("["),temp.lastIndexOf("]")+1);
    		json=temp;
    	}catch(Exception ex){}
    	return json;
    }
    @RequestMapping(value="movie/detail.do",produces="text/plain;charset=UTF-8")
    public String movie_detail(int no,int rank)
    {
    	String json="";
    	String url=strUrl[no-1];
    	try
    	{
    		Document doc=Jsoup.connect("https://www.kobis.or.kr/kobis/business/main/"+url).get();
    		String temp=doc.toString();
    		temp=temp.substring(temp.indexOf("["),temp.lastIndexOf("]")+1);
    		JSONParser parser=new JSONParser();
    		JSONArray arr=(JSONArray)parser.parse(temp);
    		//System.out.println(arr.toJSONString());
    		JSONObject obj=(JSONObject)arr.get(rank-1);
    		System.out.println(obj.toJSONString());
    		json=obj.toJSONString();
    	}catch(Exception ex){}
    	return json;
    }
    
    @RequestMapping(value="movie/list.do",produces="text/plain;charset=UTF-8")
    public String movie_list(String page,String cno)
    {
    	String json="";
    	try
    	{
    		if(page==null)
    			page="1";
    		if(cno==null)
    			cno="1";
    		
    		int curpage=Integer.parseInt(page);
    		
    		int rowSize=12;
    		int start=(rowSize*curpage)-(rowSize-1);
    		int end=rowSize*curpage;
    		
    		Map map=new HashMap();
    		map.put("start", start);
    		map.put("end", end);
    		map.put("cno", Integer.parseInt(cno));
    		List<MovieVO> list=dao.movieListData(map);
    		int totalpage=dao.movieTotalPage(Integer.parseInt(cno));
    		
    		// {"a":,"b":} {"a": ,"b": , "c":}
    		JSONArray arr=new JSONArray();
    		int i=0;
    		for(MovieVO vo:list)
    		{
    			// {} => [{}...]
    			JSONObject obj=new JSONObject();
    			if(i==0)
    			{
    				obj.put("curpage", curpage);
    				obj.put("totalpage", totalpage);
    				obj.put("mno", vo.getMno());
    				obj.put("title", vo.getTitle());
    				obj.put("poster", vo.getPoster());
    			}
    			else
    			{
    				obj.put("mno", vo.getMno());
    				obj.put("title", vo.getTitle());
    				obj.put("poster", vo.getPoster());
    			}
    			
    			arr.add(obj);
    			i++;
    			
    		}
    		
    		json=arr.toJSONString();
    	}catch(Exception ex){ex.printStackTrace();}
    	return json;
    }
    // @RequestMapping("text/plain;charset=UTF-8","movie/list.do")
    @RequestMapping(value="movie/news.do",produces="text/plain;charset=UTF-8") //@RequestMapping("movie/list.do") => default (value)
    public String movie_news(String fd){
    	String json="";
    	if(fd==null)
    		fd="영화";
    	try
    	{
    		String strUrl="http://newssearch.naver.com/search.naver?where=rss&query="
    				      +URLEncoder.encode(fd,"utf-8");
    		URL url=new URL(strUrl);
    		JAXBContext jb=JAXBContext.newInstance(Rss.class);
    		Unmarshaller un=jb.createUnmarshaller();
    		Rss rss=(Rss)un.unmarshal(url);
    		List<Item> list=rss.getChannel().getItem();
    		//JSON파일 만들기 
    		JSONArray arr=new JSONArray();
    		for(Item i:list)
    		{
    			JSONObject obj=new JSONObject();
    			obj.put("title", i.getTitle());
    			obj.put("desc", i.getDescription());
    			obj.put("author", i.getAuthor());
    			obj.put("link", i.getLink());
    			
    			arr.add(obj);
    		}
    		json=arr.toJSONString();
    	}catch(Exception ex){}
    	return json;
    }
    
    @RequestMapping(value="movie/recommand.do",produces="text/plain;charset=UTF-8")
    public String movieRecommandData(String fd)
    {
    	System.out.println("fd="+fd);
    	String json="";
    	try
    	{
    		mgr.naverFindXML(fd+"에 볼 영화 추천");
    		mgr.xmlParser(); // naver.txt
    		List<String> list=dao.movieGetTitleData();
    		int[] count=new int[list.size()];
    		
    		// 문자열 => 영화 제목 찾기 
    		Pattern[] p=new Pattern[list.size()]; // Map-Reduce
    		Matcher[] m=new Matcher[list.size()];
    		
    		for(int i=0;i<p.length;i++)
    		{
    			p[i]=Pattern.compile(list.get(i)); // 찾는 문자열을 만든다 => 단어 패턴
    		}
    		
    		for(String s:list)
    		{
    			for(int i=0;i<m.length;i++)
    			{
    				m[i]=p[i].matcher(s);
    				while(m[i].find())
    				{
    					//System.out.println(m[i].group());
    					count[i]++;
    				}
    				
    			}
    		}
    		
    		List<MovieVO> mList=new ArrayList<MovieVO>();
    		// 출력 
    		for(int i=0;i<count.length;i++)
    		{
    			if(count[i]>4)
    			{
    				System.out.println(list.get(i)+":"+count[i]);
    				MovieVO vo=dao.movieInfoData(list.get(i));
    				mList.add(vo);
    			}
    		}
    		
    		JSONArray arr=new JSONArray();
    		for(MovieVO vo:mList)
    		{
    			JSONObject obj=new JSONObject();
    			obj.put("title", vo.getTitle());
    			obj.put("poster", vo.getPoster());
    			arr.add(obj);
    		}
    		json=arr.toJSONString();
    		
    	}catch(Exception ex){}
    	return json;
    }
}









