package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        EmpDAO dao=(EmpDAO)app.getBean("dao");
        //EmpDAO dao=new EmpDAO();
        List<EmpVO> list=dao.empAllData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEmpno()+" "
        			+vo.getEname()+" "
        			+vo.getJob()+" ");
        }
        System.out.println("=======================");
        EmpVO vo=dao.empDetailData(7788);
        System.out.println(vo.getEmpno()+" "
    			+vo.getEname()+" "
    			+vo.getJob()+" ");
        System.out.println("========================");
        vo=dao.empUpdateData(7788);
        System.out.println(vo.getEmpno()+" "
    			+vo.getEname()+" "
    			+vo.getJob()+" ");
	}

}
