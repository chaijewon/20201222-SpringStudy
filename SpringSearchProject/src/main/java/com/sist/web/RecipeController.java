package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.*;
import java.util.*;
/*
 *    1. Container 종류 : xml,java => 등록된 클래스를 모아서 관리하는 클래스 
 *                                                ======
 *                                                1. 객체생성 
 *                                                2. 객체소멸
 *                                                3. 필요한 데이터 주입 : setXxx(),생성자매개변수
 *                                                ================================= DI
 *                                                4. 요청한 클래스 찾기
 *                                                   => 구분자 : XML=><bean id="">
 *                                                   => 어노테이션 @Bean(name="")
 *                                                ================================= DL
 *      BeanFactory
 *         |
 *     ApplicationContext
 *         |
 *    -------------------------------
 *    |                             |
 *  WebApplicationContext(XML)    AnnotationConfigApplicationContext(어노테이션 이용)
 *  
 *   2. DI 
 *      = XML형식
 *      = Annotation형식 => Spring5에서 주로 구현 (Spring5의 기본 목적 : 보안)
 *      1) Setter DI (p:변수명="")
 *      2) Constructor DI (c:매개변수명="") 
 *         *** 객체주소 대입 : p:변수명-ref="id명"
 *      3) Method DI => 객체생성시 (init-method), 객체소멸시 (destory-method)
 *                      어노테이션 : @PostConstructor() , @PreDestory()
 *                      => 오라클의 드라이버 등록 , Twitter를 연결해서 실시간으로 데이터 읽기
 *                      => 오라클 연결 해제 , Twitter연결해제 
 *      4) 클래스 메모리 할당 
 *         XML :
 *           = <bean id="" class=""> : 클래스 한개씩 메모리 할당 
 *           = <context:component-scan base-package=""> : 패키지에 있는 모든 클래스를 메모리 할당 
 *         어노테이션 :
 *           @Component  : MainClass , ~Manager 
 *           @Repository : DAO
 *           @Service : DAO+DAO
 *           @Controller : 화면 이동 , JSP 값 전송 
 *           @RestController : Front(Ajax,ReactJS,NodeJS,VueJS)부분에 데이터 전송 
 *           
 *    3. AOP (공통으로 적용되는 기능을 모아서 자동화 처리) : 사용자 정의 => 이미 만들어진 기능을 사용(트랜잭션,로그파일,보안)
 *       1) Aspect : 공통모듈 
 *       2) 적용 위치 : JoinPoint
 *            => before
 *            => after
 *            => after-returning
 *            => after-throwing
 *            => around
 *       3) 어떤 메소드 : PointCut
 *           execution("리턴형 패키지명.클래스명.메소드(매개변수))")
 *       4) 적용위치 + 어떤 메소드   : Advice
 *   4. 여러개의 DML(INSERT,UPDATE,DELETE)이 있는 경우
 *      일괄처리 => 모든 문장이 성공 => COMMIT
 *               한개라도 실패하면 전체를 취소 => ROLLBACK
 *      ============================================ 트랜잭션
 *      @Transactional()
 *      
 *   5. MVC 구조                                                                                         Model                    request
 *      요청(.do) ===> DispatcherServlet =====> @Controller   ============> ViewResolver ======> JSP
 *                                             @GetMapping()
 *                                             @PostMapping()
 *                                             @RequestMapping()
 *   6. 전자정부 프레임워크 (공기업) : tiles
 *   
 *   ============================================================================
 *   1. MyBatis 
 *      XML , 어노테이션 
 *      ===
 *       => resultType(결과값) , parameterType(?에 값을 채운다)
 *       => 동적 SQL 
 *          <if> , <choose> , <trim> , <foreach> , <bind>
 */
@Controller
public class RecipeController {
  @Autowired
  private RecipeDAO dao;
  
  @GetMapping("recipe/recipe_list.do")
  // int => 대신 String으로 받는 경우는 값이 없는 경우(처음 실행) => 페이지 , 기능별 출력 
  public String recipe_list(String page,Model model)
  {
	  if(page==null)
		  page="1";
	  
	  int curpage=Integer.parseInt(page);
	  Map map=new HashMap();
	  int rowSize=12;
	  int start=(rowSize*curpage)-(rowSize-1);
	  int end=rowSize*curpage;
	  map.put("start", start);
	  map.put("end", end);
	  List<RecipeVO> list=dao.recipeListData(map);
	  for(RecipeVO vo:list)
	  {
		  String s=vo.getTitle();
		  if(s.length()>15)
		  {
			  s=s.substring(0,15)+"...";
			  vo.setTitle(s);
		  }
	  }
	  int totalpage=dao.recipeTotalPage();
	  
	  final int BLOCK=10;
	  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	  
	  if(endPage>totalpage)
		  endPage=totalpage;
	  
	  // 10 20 30 40... totalpage=13
	  // 1~10 , 11~13
	  
	  model.addAttribute("list", list);
	  model.addAttribute("curpage", curpage);
	  model.addAttribute("totalpage", totalpage);
	  model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage);
	  return "recipe/recipe_list";
  }
  @GetMapping("recipe/find.do")
  public String recipe_find()
  {
	  return "recipe/find";
  }
  
  /*@PostMapping("recipe/find_ok.do")
  public String recip_find_ok(FindVO vo,Model model)
  {
	  // DAO연결
	  Map map=new HashMap();
	  map.put("keyword", vo.getSs());
	  map.put("fdArr", vo.getFdArr());
	  List<RecipeVO> list=dao.recipeFindData(map);
	  model.addAttribute("list", list);
	  return "recipe/find";
  }*/
}














