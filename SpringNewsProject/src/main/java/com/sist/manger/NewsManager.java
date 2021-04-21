package com.sist.manger;

import org.springframework.stereotype.Component;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.net.*;
@Component
public class NewsManager {
   public List<Item> naverNeswData(String fd)
   {
	   List<Item> list=new ArrayList<Item>();
	   try
	   {
		   String strUrl="http://newssearch.naver.com/search.naver?where=rss&query="
				         +URLEncoder.encode(fd, "UTF-8");
		   URL url=new URL(strUrl);
		   // 파싱 
		   JAXBContext jb=JAXBContext.newInstance(Rss.class);
		   // XML => Java변경 
		   Unmarshaller un=jb.createUnmarshaller();
		   Rss rss=(Rss)un.unmarshal(url);
		   list=rss.getChannel().getItem();
		   // Java => XML변경 
	   }catch(Exception ex){}
	   return list;
   }
}











