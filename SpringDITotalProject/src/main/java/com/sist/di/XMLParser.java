package com.sist.di;
import java.lang.reflect.Method;
import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/*
 *   <bean id="sa" class="com.sist.di.Sawon"
	    p:name="심청이"
	    p:sex="여자"
	    p:dept="개발부"
	    init-method="init"
	  />
 */
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
				// 메모리 할당 
				Class clsName=Class.forName(cls);// 클래스의 정보 읽기 (패키지.클래스명)
				Object obj=clsName.getDeclaredConstructor().newInstance();// 메모리 할당 (new 클래스())
				// 리플랙션 : 클래스 정보를 읽어와서 메모리 할당 , 메소드 호출 , 멤버변수 제어 
				// setter DI
				String name=attributes.getValue("p:name");
				String sex=attributes.getValue("p:sex");
				String dept=attributes.getValue("p:dept");
				
				String m1=attributes.getQName(2);// p:name
				String m2=attributes.getQName(3);// p:sex
				String m3=attributes.getQName(4);// p:dept
				String init=attributes.getValue("init-method");
				
				
				Method[] methods=clsName.getDeclaredMethods(); //클래스안에 선언된 모든 메소드 읽기
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
					
					if(init!=null)
					{
						if(m.getName().equals(init))
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










