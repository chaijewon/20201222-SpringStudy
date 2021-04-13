package com.sist.main;
/*
 *   1) XML ==> DI
 *   2) Annotation ==> DI(X)
 *   3) Java ==> DI
 *   ========================
 *   DI(스프링을 통해서 필요한 데이터를 주입)
 *   = setter(2)
 *   = 생성자 (1)
 *   
 *   public class A
 *   {
 *       private int aa;
 *       public A(int aa)
 *       {
 *           this.aa=aa;
 *       }
 *       public void setAa(int aa)
 *       {
 *           this.aa=aa;
 *       }
 *   }
 *   
 *   A a=new A(10);
 *   a.setAa(20);
 *   
 *   a.aa=> 20
 *   <bean id="sa" class="com.sist.main.Sawon"/>
 *   
 *   Sawon s=new Sawon();
 */
public class Sawon {
   private String name;
   private String sex;
   private String addr;
   public Sawon()
    {
	   
    }
    public Sawon(String name, String sex, String addr) {
		
		this.name = name;
		this.sex = sex;
		this.addr = addr;
    }
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public void print()
	{
		System.out.println("이름:"+name);
		System.out.println("성별:"+sex);
		System.out.println("주소:"+addr);
	}
}














