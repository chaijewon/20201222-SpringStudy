package com.sist.main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
// DI => 스프링에서 처리하는 DI (객체를 관리 => 생명주기 (생성 , Setter , 사용 , 소멸):컨테이너
/*
 *   DI : 생성시에 필요한 데이터값을 주입 
 *   ===========================
 *     1. setter
 *     2. 생성자
 *     3. 필요시에 메소드 호출 
 *        객체 생성될때 => init-method : 데이터베이스 드라이버 등록,파일 읽기(ID자동등록)
 *        객체가 소멸 => destory-method: 데이터베이스 닫기(disConnection(),session해제)
 *   AOP : 공통으로 호출되는 메소드를 자동호출이 가능 (공통모듈) => 트랜잭션,로그파일,보안
 *   MVC : 동작 순서 
 *         사용자 요청 ====> DispatcherServlet ====> @Controller(Model) =====>
 *                                               ====================
 *                                                  요청 처리 
 *                       DispatcherServlet ====> ViewResolver =====> JSP 실행 
 *                                                                  =========
 *                                                                   결과값 받기
 *                       스프링에서 제공하는 클래스는 등록만 하면 종료
 *       => XML 기반 (4버전) => 전자정부프레임워크(스프링기반),애니프레임워크(SDS:스프링) 
 *          유지 보수
 *       => 5버전 (보안) => 기반 (순수 자바)
 *          차세대 개발 
 */
public class MyApp implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware{
    private String name;
    private String sex;
    /*
     *   <bean id="my" class="MyApp">
     *   Class clsName=Class.forName("MyApp");
     *   Object obj=clsName.newInstance();  ====> 메모리 할당 (객체 생성)
     *   ==> HashMap map=new HashMap();
     *       map.put("my",obj) 
     *       ==> app.getBean("my") ==> obj
     */
    public MyApp()
    {
    	System.out.println("1.스프링에서 메모리 할당:MyApp객체 생성..");
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("2.setName를 호출 : name값을 채워주는다(주입):setName("+name+")");
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
		System.out.println("2.setSex를 호출 : sex값을 채워주는다(주입):setSex("+sex+")");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		// setter를 이용해서 데이터 주입 완료
		System.out.println("afterPropertiesSet() Call...");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		// 객체메모리 해제 
		System.out.println("destroy() Call...");
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		// 객체 호출 ID
		System.out.println("setBeanName() Call:"+name);// app.getBean("my")
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		// 객체를 찾아서 넘겨주는 상태
		System.out.println("setBeanFactory() Call...");
	}
	
	// 사용자 정의
	public void init_user()
	{
		System.out.println("init_user() Call...");
	}
	public void destory_user()
	{
		System.out.println("destory_user() Call...");
	}
	public void userCall()
	{
		System.out.println("=== 프로그래머가 활용 ===");
		System.out.println("이름:"+name);
		System.out.println("성별:"+sex);
		System.out.println("====================");
	}

}









