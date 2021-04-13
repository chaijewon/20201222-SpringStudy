package com.sist.spring;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="C:\\springDev\\study\\SpringContainerProject\\src\\main\\java\\com\\sist\\spring\\app.xml";
        ApplicationContext app=
        		new ApplicationContext(path);
        Sawon s=(Sawon)app.getBean("sa");
        s.setName("홍길동");
        s.setSex("남자");
        s.setAddr("서울");
        s.print();
        
	}

}
