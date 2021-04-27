package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.manager.MyManager;

@Component
public class MainClass2 {
	@Autowired
    private MyManager m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        MainClass2 mc=(MainClass2)app.getBean("mainClass2");
        mc.m.display();
	}

}
