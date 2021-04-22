package com.sist.di;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String path="C:\\Users\\SIST\\springStudy\\SpringContainerProject\\src\\main\\java\\com\\sist\\di\\app.xml";
        ApplicationContext app=
        		new ApplicationContext(path);
        Sawon sa=(Sawon)app.getBean("sa");
        sa.print();
	}

}
