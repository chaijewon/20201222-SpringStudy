package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 *    스프링 : id를 가지고 찾는다 
 *           <bean id="" class="">
 *           @Component("id명") => id를 설정하지 않는 경우 클래스명이 id가된다
 *                                단 첫글자는 소문자 
 *                                BoardDAO => boardDAO
 *           => id는 중복 할 수 없다 (관리 => Map에 저장 => id를 key)
 *           public class A
 *    마이바티스  : SQL문장을 찾기 (id) => 중복을 할 수 없다 
 *    타일즈 : Controller에서 넘겨준 return값 
 *           public String disp()
 *           {
 *              return "board/list";
 *           }
 *           => board/list => 어떤 화면을 보여줄지 설정 
 *           => Tiles에 정의=> 없는 내용이 있다 (단독실행) 
 *           
 *           <definition name="main" template="/WEB-INF/main/main.jsp">
			    <put-attribute name="header" value="/WEB-INF/main/header.jsp"/>
			    <put-attribute name="nav" value="/WEB-INF/main/nav.jsp"/>
			    <put-attribute name="content" value="/WEB-INF/main/content.jsp"/><!-- 변경되는 영역 -->
			    <put-attribute name="footer" value="/WEB-INF/main/footer.jsp"/>
			    <put-attribute name="copy" value="/WEB-INF/main/copy.jsp"/>
			  </definition>
			  <!-- 
			      board/list
			   -->
			  <definition name="board/list" extends="main">
			    <put-attribute name="content" value="/WEB-INF/{1}/{2}.jsp"/>
			  </definition>
			     
			  return "login" return "login_ok";  name="*" ajax => 단독실행 
 *    =============> 패키지 단위로 클래스 등록 
 *    <context:component-scan base-package="com.sist.*">
 *    1. 어노테이션을 이용한 메모리 할당 요청 
 *       @Component
 *       @Service
 *       @Repsitory
 *       @Controller
 *       @RestController
 *    2. 어노테이션을 이용한 주입 
 *       @Autowired
 *       @Resource(name="id명")
 */
@Repository
public class MovieDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	/*
	 *   <select id="movieAllData" resultType="com.sist.dao.MovieVO" parameterType="hashmap">
		  <include refid="inline-sql"/> ORDER BY mno ASC))
		  WHERE num BETWEEN #{start} AND #{end}
		 </select>
		 <select id="movieAllTotalPage" resultType="int">
		   SELECT CEIL(COUNT(*)/12.0) FROM daum_movie
		 </select>
		 <select id="movieFindData" resultType="com.sist.dao.MovieVO" parameterType="hashmap">
		  <include refid="inline-sal"/> WHERE title LIKE '%'||#{keyword}||'%' ORDER BY mno ASC))
		  WHERE num BETWEEN #{start} AND #{end}
		 </select>
		 <select id="movieFindTotalPage" resultType="int" parameterType="string">
		   SELECT CEIL(COUNT(*)/12.0) FROM daum_movie
		   WHERE title LIKE '%'||#{keyword}||'%'
		 </select>
	 */
   public List<MovieVO> movieAllData(Map map)
   {
	   return getSqlSession().selectList("movieAllData",map);
   }
   public int movieAllTotalPage()
   {
	   return getSqlSession().selectOne("movieAllTotalPage");
   }
   public List<MovieVO> movieFindData(Map map)
   {
	   return getSqlSession().selectList("movieFindData", map);
   }
   public int movieFindTotalPage(String keyword)
   {
	   return getSqlSession().selectOne("movieFindTotalPage", keyword);
   }
   
}














