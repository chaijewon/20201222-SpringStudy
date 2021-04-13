package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
   //C:\springDev\study\SpringContainerProject\src\main\java => classpath
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        Sawon s=(Sawon)app.getBean("sa");
        System.out.println("s="+s);
        
	}

}
