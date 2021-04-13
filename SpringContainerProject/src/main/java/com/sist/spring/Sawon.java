package com.sist.spring;
/*
 *   Sawon s=new Sawon();
 */
public class Sawon {
    private String name;
    private String sex;
    private String addr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddr() {
		return addr;
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






