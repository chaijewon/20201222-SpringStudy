package com.sist.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	Document doc=Jsoup.connect("https://www.inflearn.com/course/%EB%85%B8%EB%93%9C%EB%B2%84%EB%93%9C-%EB%A6%AC%EC%95%A1%ED%8A%B8-%EB%A6%AC%EB%89%B4%EC%96%BC#").get();
        	Element e1=doc.select("div.cd-fixed-body div.cd-fixed-body__list-content").get(0);
        	//System.out.println(e1.text());
        	/*Elements ee=e1.select(".cd-fixed-body__list");
        	for(int i=0;i<ee.size();i++)
        	{
        		System.out.println(ee.get(i).text());
        	}
        	System.out.println("=========================================================");
        	Element e2=doc.select("div.cd-fixed-body div.cd-fixed-body__list-content").get(1);
        	//System.out.println(e1.text());
        	Elements eee=e2.select(".cd-fixed-body__list");
        	for(int i=0;i<eee.size();i++)
        	{
        		System.out.println(eee.get(i).text());
        	}
        	System.out.println("=========================================================");
        	Element e3=doc.select("div.cd-fixed-body div.cd-fixed-body__list-content").get(2);
        	//System.out.println(e1.text());
        	Elements eeee=e3.select(".cd-fixed-body__list");
        	for(int i=0;i<eeee.size();i++)
        	{
        		System.out.println(eee.get(i).text());
        	}*/
        	Elements list_content=doc.select("div.cd-fixed-body div.cd-fixed-body__list-content");
        	for(int i=0;i<list_content.size();i++)
        	{
        		Element e=list_content.get(i);
        		Elements ee=e.select(".cd-fixed-body__list");
        		for(int j=0;j<ee.size();j++)
        		{
        			System.out.println(ee.get(j).text());
        			
        		}
        		System.out.println("===============================");
        	}
        	
        }catch(Exception ex){ex.printStackTrace();}
	}

}
