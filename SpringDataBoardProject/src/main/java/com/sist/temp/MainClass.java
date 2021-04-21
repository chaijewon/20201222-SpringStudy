package com.sist.temp;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GenericXmlApplicationContext app=
        		new GenericXmlApplicationContext("app.xml");
        MyApp my=(MyApp)app.getBean("my");
        my.userCall();
        app.close();
	}

}
