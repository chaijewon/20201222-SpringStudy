package com.sist.spring;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

public class XMLParser extends DefaultHandler{
      Map clsMap=new HashMap();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try
		{
			if(qName.equals("bean"))
			{
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				Class clsName=Class.forName(cls);
				Object obj=clsName.getDeclaredConstructor().newInstance();
				clsMap.put(id, obj);
			}
		}catch(Exception ex){}
	}
      
}









