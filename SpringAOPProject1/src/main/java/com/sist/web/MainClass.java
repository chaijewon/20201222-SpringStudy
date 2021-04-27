package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.BoardDAO;

@Component
public class MainClass {
	@Autowired
    private BoardDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
		/*GenericApplicationContext app=
				new GenericXmlApplicationContext("app.xml");*/
        MainClass mc=(MainClass)app.getBean("mainClass");
        mc.dao.aopselect();
        System.out.println("===========================");
        mc.dao.aopinsert("심청이");
        System.out.println("===========================");
        mc.dao.aopupdate();
        System.out.println("===========================");
        mc.dao.aopdelete();
        System.out.println("===========================");
        mc.dao.aopfind();
        System.out.println("===========================");
	}

}
