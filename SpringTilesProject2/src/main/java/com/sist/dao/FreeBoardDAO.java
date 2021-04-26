package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sist.vo.FreeBoardVO;

import java.util.*;

import javax.annotation.Resource;
@Repository
public class FreeBoardDAO extends SqlSessionDaoSupport{

	@Resource(name="ssf")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// 목록 
	public List<FreeBoardVO> freeboardListData(Map map)
	{
		return getSqlSession().selectList("freeboardListData", map); // map => #{start} #{end}
	}
	
	// 총페이지 
    public int freeboardTotalPage()
    {
    	return getSqlSession().selectOne("freeboardTotalPage");
    }
    
    // 상세보기
    /*
     *   <update id="freeboardHitIncrement" parameterType="int">
		    UPDATE spring_freeboard SET
		    hit=hit+1
		    WHERE no=#{no}
		  </update>  
		  <select id="freeboardDetailData" resultType="com.sist.vo.FreeBoardVO" parameterType="int">
		    SELECT * FROM spring_freeboard
		    WHERE no=#{no}
		  </select>
     */
    public FreeBoardVO freeboardDetailData(int no)
    {
    	getSqlSession().update("freeboardHitIncrement",no); // 조회수 증가
    	return getSqlSession().selectOne("freeboardDetailData", no);
    }
    // 수정하기
    /*
     *    <!-- 수정하기 -->
		  <!-- 비밀번호 체크 -->
		  <select id="freeboardGetPassword" resultType="string" parameterType="int">
		    SELECT pwd FROM spring_freeboard
		    WHERE no=#{no}
		  </select>
		  <!-- 실제 수정 -->
		  <!-- parameterMap : Procedure (매개변수 설정) -->
		  <update id="freeboardUpdate" parameterType="com.sist.vo.FreeBoardVO">
		    UPDATE spring_freeboard SET
		    name=#{name},
		    subject=#{subject},
		    content=#{content}
		    WHERE no=#{no}
		  </update>
     */
    public FreeBoardVO freeboardUpdateData(int no)
    {
    	return getSqlSession().selectOne("freeboardDetailData", no);
    }
    // 실제 수정
    public boolean freeboardUpdate(FreeBoardVO vo)
    {
    	boolean bCheck=false;
    	// 비밀번호 검색 
    	String db_pwd=getSqlSession().selectOne("freeboardGetPassword", vo.getNo());
    	if(db_pwd.equals(vo.getPwd()))
    	{
    		bCheck=true;
    		// 실제 수정
    		getSqlSession().update("freeboardUpdate",vo);
    	}
    	else
    	{
    		bCheck=false;
    	}
    	return bCheck;
    }
    // 삭제하기 
    // 게시물 추가
    public void freeboardInsert(FreeBoardVO vo)
    {
    	getSqlSession().insert("freeboardInsert",vo);
    }
    // 찾기 => 마이바티스의 동적 SQL 
}














