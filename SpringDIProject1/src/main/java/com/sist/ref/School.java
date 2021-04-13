package com.sist.ref;

public class School {
    private Student std=new Student();
    public School()
    {
    	
    }
    public School(Student std)
    {
    	this.std=std;
    }
	public Student getStd() {
		return std;
	}
	
	public void setStd(Student std) {
		this.std = std;
	}
   
	public void print()
	{
		System.out.println("====== 결과 ======");
		System.out.println("학번:"+std.getHakbun());
		System.out.println("이름:"+std.getName());
		System.out.println("국어:"+std.getKor());
		System.out.println("영어:"+std.getEng());
		System.out.println("수학:"+std.getMath());
	}
   
}
