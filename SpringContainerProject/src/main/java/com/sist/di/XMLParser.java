package com.sist.di;
import java.lang.reflect.Method;
import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class XMLParser extends DefaultHandler{
    Map map=new HashMap();
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
				String name=attributes.getValue("p:name");
				String sex=attributes.getValue("p:sex");
				String dept=attributes.getValue("p:dept");
				String method=attributes.getValue("init-method");
				
				String m1=attributes.getQName(2);
				String m2=attributes.getQName(3);
				String m3=attributes.getQName(4);
				System.out.println(m1+" "+m2+" "+m3+" "+method);
				
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m:methods)
				{
					if(m.getName().equalsIgnoreCase("set"+m1.substring(m1.indexOf(":")+1)))
					{
						m.invoke(obj, name);
					}
					else if(m.getName().equalsIgnoreCase("set"+m2.substring(m2.indexOf(":")+1)))
					{
						m.invoke(obj, sex);
					}
					else if(m.getName().equalsIgnoreCase("set"+m3.substring(m3.indexOf(":")+1)))
					{
						m.invoke(obj, dept);
					}
					
					if(method!=null)
					{
						if(m.getName().equals(method))
						{
							m.invoke(obj, null);
						}
					}
				}
				map.put(id, obj);
				
			}
		}catch(Exception ex){}
	}
   
}











