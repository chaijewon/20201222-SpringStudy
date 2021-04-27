package com.sist.web;
interface I
{
	public void display();
}
class A implements I
{
	public void display()
	{
		System.out.println("A:display Call...");
	}
}
class B implements I
{
	A a;
	public B(A a)
	{
		this.a=a;
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Before Call...");
		a.display();
		System.out.println("After Call...");
	}
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        A a=new A();
        a.display();
        System.out.println("======================");
        I i=new B(a);
        i.display(); // ProXY => 대리자  => AOP (인터셉트)
	}

}
