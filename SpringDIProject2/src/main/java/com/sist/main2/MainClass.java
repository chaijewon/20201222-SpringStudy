package com.sist.main2;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {
   public static void main(String[] args) {
	   ApplicationContext app=
			   new ClassPathXmlApplicationContext("app1.xml");
	   EmpDAO dao=(EmpDAO)app.getBean("dao");
	   List list=dao.empAllData();
	   for(int i=0;i<list.size();i++)
	   {
		   EmpVO vo=(EmpVO)list.get(i);
		   System.out.println(vo.getEmpno()+" "
       			+vo.getEname()+" "
       			+vo.getJob()+" "
       			+vo.getHiredate().toString()+" "
       			+vo.getSal());
	   }
   }
}
