package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        StudentDAO dao=app.getBean("dao",StudentDAO.class);
        List list=dao.studentAllData();
        for(Object obj:list)
        {
        	StudentVO vo=(StudentVO)obj;
        	System.out.println(vo.getName()+" "
        			   +vo.getKor()+" "
        			   +vo.getEng()+" "
        			   +vo.getMath()+" "
        			   +vo.getTotal()+" "
        			   +vo.getAvg());
        }
        
        System.out.println("===================================");
        StudentVO vo=dao.studentDetailData("박문수");
        System.out.println(vo.getName()+" "
 			   +vo.getKor()+" "
 			   +vo.getEng()+" "
 			   +vo.getMath()+" "
 			   +vo.getTotal()+" "
 			   +vo.getAvg());
        /*StudentVO ivo=new StudentVO();
        ivo.setName("이순신");
        ivo.setKor(100);
        ivo.setEng(100);
        ivo.setMath(100);
        dao.studentInsert(ivo);*/
        
        dao.studentDelete("이순신");
        
        StudentVO ivo=new StudentVO();
        ivo.setName("박문수");
        ivo.setKor(90);
        ivo.setEng(80);
        ivo.setMath(70);
        dao.studentInsert(ivo);
	}

}








