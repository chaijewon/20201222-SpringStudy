package com.sist.main;

import org.springframework.context.support.GenericXmlApplicationContext;
/*
 *     객체 관리 : 컨테이너 클래스 
 *         BeanFactory
 *           |
 *      ================
 *           |
 *        ApplicationContext 
 *           |
 *     =====================================
 *     |              |                    |
 *   GenericXmlApplicationContext AnnotationConfigApplicationContext WebApplicationContext 
 *   
 *   ============================================
 *   1) 객체생성 
 *      XML 이용 <bean>: 클래스 한개씩 설정 <context:component-scan>:패키지 단위
 *      Annotation
 *       @Component
 *       @Repository
 *       @Service => DAO관련  ==> JOIN,SUBQUERY
 *       @Controller
 *       @RestController: Front이용 (Jquery,Ajax , VueJs , ReactJS) => 목록(JSON) , 모바일
 *          => jsp파일을 줄일 수 있다 (update_ok.jsp,delete_ok.jsp)
 *          => 오래된 프로그램 (유지보수 : @ResponseBody)
 *       @ControllerAdvice:에러처리 (404,500)
 *       
 *       ==> 라이브러리 클래스는 어노테이션이 없다 : <bean>
 *       ==> 사용자 정의 : Annotation
 *   2) 객체 멤버변수에 값을 주입
 *      p:name , p:dataSource-ref , c:_0
 *      @Autowired , @Resource 
 *   3) init-method 호출 
 *      <bean init-method="메소드명"> => @PostConstructor
 *      <bean destory-method="메소드명"> => @PreDestory
 *   =========================
 *   4) 사용자가 저장된 객체의 주소를 얻어서 활용(메소드 기능 수행)
 *   ============================================== 프로그래머
 *   5) destory-method : 객체를 메모리에 제거
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GenericXmlApplicationContext app=
        		new GenericXmlApplicationContext("app.xml"); // 객체생성,setter,map에 저장
        // WEB => DispatcherServlet에서 => WebApplicationContext포함
        // 객체를 얻어온다
        MyApp my=(MyApp)app.getBean("my");
        my.userCall();
        app.close();// 메모리 해제 (System.gc())
	}

}










