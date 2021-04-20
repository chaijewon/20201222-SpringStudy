package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
/*
 *    메모리할당 
 *    @Component : JSOUP (HTML Parser) => 실시간 날씨 검색 , Open API
 *    @Repository : DAO 
 *    @Controller : 파일 변경 , forward , sendRedirect
 *    @RestController : 문자데이터 전송 (JSON(객체단위),스트립트 전송)
 *    ===========================================================
 *    @Service : DAO여러개 통합 (BI) 
 *    @ControllerAdvice : Exception (에러처리 : 404,500)
 *    
 */
// 메모리 할당 => 스프링에서  객체주소 주입 
@Repository
public class DataBoardDAO extends SqlSessionDaoSupport{
	// SqlSessionFactory => 오라클 연결을 할 수 있다
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
   
    // 목록 출력 
	public List<DataBoardVO> databoardListData(Map map)
	{
		return getSqlSession().selectList("databoardListData", map);
	}
	// 총페이지 구하기
	public int databoardTotalPage()
	{
		return getSqlSession().selectOne("databoardTotalPage");
	}
	// 데이터 추가
	public void databoardInsert(DataBoardVO vo)
	{
		getSqlSession().insert("databoardInsert", vo);
	}
	// 상세보기
	// databoardHitIncrement
	public DataBoardVO databoardDetailData(int no)
	{
		// 조회수 증가 
		getSqlSession().update("databoardHitIncrement",no);
		// 실제데이터 읽기
		return getSqlSession().selectOne("databoardDetailData", no);
	}
	// 수정
	// 삭제 
	/*
	 *    <!-- 비밀번호 확인 -->
		  <select id="databoardGetPassword" resultType="string" parameterType="int">
		    <!-- String , string -->
		    SELECT pwd FROM spring_databoard
		    WHERE no=#{no}
		  </select>
		  <!-- 파일정보 읽기 -->
		  <select id="databoardFileInfoData" resultType="com.sist.dao.DataBoardVO" parameterType="int">
		    SELECT filename,filecount FROM spring_databoard
		    WHERE no=#{no}
		  </select>
		  <!-- 삭제 -->
		  <delete id="databoardDelete" parameterType="int">
		    DELETE FROM spring_databoard
		    WHERE no=#{no}
		  </delete>
	 */
	public DataBoardVO databoardFileInfoData(int no)
	{
		return getSqlSession().selectOne("databoardFileInfoData", no);
	}
	public boolean databoardDelete(int no,String pwd)
	{
		boolean bCheck=false;
		String db_pwd=getSqlSession().selectOne("databoardGetPassword", no);
		if(db_pwd.equals(pwd))
		{
			bCheck=true;
			getSqlSession().delete("databoardDelete",no);
		}
		return bCheck;
	}
}














