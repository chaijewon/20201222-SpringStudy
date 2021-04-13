package com.sist.main;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        Sawon s=app.getBean("sa1",Sawon.class);
        System.out.println("s="+s);
        s.print();
        System.out.println("===========================");
        
        s=app.getBean("sa2",Sawon.class);
        System.out.println("s="+s);
        s.print();
        System.out.println("===========================");
        
        s=app.getBean("sa3",Sawon.class);
        System.out.println("s="+s);
        s.print();
        System.out.println("===========================");
        
        s=app.getBean("sa4",Sawon.class);
        System.out.println("s="+s);
        s.print();
        System.out.println("===========================");
        
        s=app.getBean("sa5",Sawon.class);
        System.out.println("s="+s);
        s.print();
        System.out.println("===========================");
	}

}
