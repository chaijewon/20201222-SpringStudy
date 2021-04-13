package com.sist.spring;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;
// DL => id로 찾을 수 있게 만든다 (getBean())
public class ApplicationContext {
     private Map clsMap=new HashMap();
     public ApplicationContext(String path)
     {
    	 try
    	 {
    		 SAXParserFactory spf=SAXParserFactory.newInstance();
    		 SAXParser sp=spf.newSAXParser();
    		 XMLParser xp=new XMLParser();
    		 sp.parse(new File(path), xp);
    		 clsMap=xp.clsMap;
    	 }catch(Exception ex){}
     }
     public Object getBean(String id)
     {
    	 return clsMap.get(id);
     }
}









