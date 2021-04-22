package com.sist.di;
import java.io.File;
// 컨테이너 : 클래스 관리(생성 , 멤버변수 입력 , 소멸)
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
