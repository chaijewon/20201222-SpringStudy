package com.sist.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(SawonConfig.class);
        Sawon s=(Sawon)app.getBean("sa");
        System.out.println("s="+s);
	}

}
