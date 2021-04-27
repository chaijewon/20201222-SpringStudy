package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;

@Component("mc")
public class MainClass {
	@Autowired
    private MemberDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 클래스 관리 요청 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		//MainClass mc=new MainClass(); // dao=>Null
		MainClass mc=(MainClass)app.getBean("mc"); // mc(X) => mainClass
		mc.dao.memberInsert();
	}

}
