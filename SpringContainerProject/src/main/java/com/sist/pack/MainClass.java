package com.sist.pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app1.xml");
        Sawon s=(Sawon)app.getBean("sa");
        System.out.println("s="+s);
	}

}
