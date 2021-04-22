package com.sist.di;
/*
 *    XML 파싱 
 *    1) <bean>에 등록된 모든 클래스를 메모리 할당
 *    2) 멤버변수에 값을 채운다 : DI
 *    3) 등록된 메소드를 호출 (init-method)
 *    ===================================
 *    사용자가 해당 메소드 호출 , 멤버변수값을 변경 
 *    ===================================
 *    4) 소멸 (객체 메모리 해제)
 *    
 *    ==> 컨테이너 (클래스 관리) => XML에 등록 , 어노테이션으로 등록시에 
 *        = 멤버변수 주입
 *          1. setXxx() => setter DI => p:변수명=""
 *          2. 생성자  => 생성자 DI => c:매개변수명=""
 *          3. 메소드 호출 
 *             생성시 한번 : init-method
 *             소멸시 한번 : destory-method
 *        = 어노테이션 ==> 주입(@Autowired , @Resource)
 *          클래스위에 
 *            @Component
 *            @Service
 *            @Repository
 *            @Controller
 *            @RestController
 *    ==> 프로젝트안에서 모든 클래스 연결 
 *        ~DAO , ~Mananger , Model(@Controller)  ==> 스프링에서 관리
 *        프로그래머가 관리 : ~VO , MainClass
 *        
 *    ==> DI : 좁은 의미 : 값주입 , 메소드 호출 
 *             넓은 의미 : 클래스와 클래스의 의존관계 설정 (클래스끼리 연결)
 *             
 *    스프링 : DI , MVC , AOP 
 *          ================
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String path="C:\\springDev\\study\\SpringDITotalProject\\src\\main\\java\\com\\sist\\di\\app.xml";
	    ApplicationContext app=
	    		new ApplicationContext(path);
	    Sawon sa=(Sawon)app.getBean("sa");
	    sa.print();
	    
	}

}
