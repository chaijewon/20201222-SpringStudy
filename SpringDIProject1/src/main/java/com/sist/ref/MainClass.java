package com.sist.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app1.xml");
        School s=(School)app.getBean("school");
        s.print();
        
        School s1=(School)app.getBean("school1");
        s1.print();
	}

}
