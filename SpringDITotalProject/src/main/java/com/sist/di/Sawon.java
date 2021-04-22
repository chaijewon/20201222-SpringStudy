package com.sist.di;

public class Sawon {
    private String name;
    private String sex;
    private String dept;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public void init()
	{
		System.out.println("=== 사원 정보 ===");
	}
	
	public void print()
	{
		System.out.println("이름:"+name);
		System.out.println("성별:"+sex);
		System.out.println("부서:"+dept);
	}
  
}









