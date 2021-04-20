package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 메모리 할당 
/*
 *   메모리 할당 (어노테이션)
 *   @Component
 *   @Repository
 *   @Controller : sendRedirect(파일명),forward() => 화면변경 
 *   @Service : BI(여러개의 DAO를 한개로 통합해서 서비스)
 *   @RestController : VueJS,Ajax => JSON => 데이터만 전송 => cross domain => 비동기,동기
 *        => 스마트폰 , 다른 언어 연결 
 *   @ControllerAdvice (Exception 처리)
 *   
 *   객체주소 주입 
 *   @Autowired :스프링에서 찾아서 주입
 *   @Resource : 특정 객체를 설정
 */
import java.util.*;
@Repository
// 마이바티스 연결 => SqlSessionFactory (XML를 파싱한 정보를 가지고 있다)
public class MovieDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *   <select id="movieListData" resultType="MovieVO" parameterType="hashmap">
		    SELECT mno,title,poster,num 
		    FROM (SELECT mno,title,poster,rownum as num
		    FROM (SELECT mno,title,poster 
		    FROM daum_movie ORDER BY mno ASC))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
	 */
	public List<MovieVO> movieListData(Map map)
	{
		return getSqlSession().selectList("movieListData", map);
	}
	/*
	 *   <select id="movieTotalPage" resultType="int">
		    SELECT CEIL(COUNT(*)/12.0) FROM daum_movie
		  </select>
	 */
	public int movieTotalPage()
	{
		return getSqlSession().selectOne("movieTotalPage");
	}
	/*
	 *   <select id="movieDetailData" resultType="MovieVO" parameterType="int">
		    SELECT * FROM daum_movie
		    WHERE mno=#{mno}
		  </select>
	 */
	public MovieVO movieDetailData(int mno)
	{
		return getSqlSession().selectOne("movieDetailData",mno);
	}
   
}












