package com.sist.di;
import java.io.File;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class ApplicationContext {
   private Map map=new HashMap();
   public ApplicationContext(String path)
   {
	   try
	   {
		   SAXParserFactory spf=SAXParserFactory.newInstance();
		   SAXParser sp=spf.newSAXParser();
		   XMLParser xp=new XMLParser();
		   sp.parse(new File(path), xp);
		   map=xp.map;
	   }catch(Exception ex){}
   }
   public Object getBean(String id)
   {
	   return map.get(id);
   }
}
