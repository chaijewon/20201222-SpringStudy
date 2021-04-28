package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class BoardDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	/*
	 *   <select id="boardListData" resultType="BoardVO" parameterType="hashmap">
		   SELECT no,subject,name,redate,hit,replyCount,num
		   FROM (SELECT no,subject,name,redate,hit,replyCount,rownum as num 
		   FROM (SELECT /*+ INDEX_DESC(spring_freeboard sf_no_pk) / no,subject,name,redate,hit,replyCount 
		   FROM spring_freeboard))
		   WHERE num BETWEEN #{start} AND #{end}
		 </select>
		 <select id="boardTotalPage" resultType="int">
		   SELECT CEIL(COUNT(*)/10.0) FROM spring_freeboard
		 </select>
	 */
     public List<BoardVO> boardListData(Map map)
     {
    	 return getSqlSession().selectList("boardListData", map);
     }
     public int boardTotalPage()
     {
    	 return getSqlSession().selectOne("boardTotalPage");
     }
     /*
      *   <insert id="boardInsert" parameterType="BoardVO">
		    <selectKey keyProperty="no" resultType="int" order="BEFORE">
		     SELECT NVL(MAX(no)+1,1) as no FROM spring_freeboard
		    </selectKey>
		    INSERT INTO spring_freeboard VALUES(
		      #{no},
		      #{name},
		      #{subject},
		      #{content},
		      #{pwd},
		      SYSDATE,
		      0
		    )
		  </insert>
      */
     public void boardInsert(BoardVO vo)
     {
    	 getSqlSession().insert("boardInsert", vo);
     }
     /*
      *   <!-- 상세보기 -->
		  <update id="boardHitIncrement" parameterType="int">
		   UPDATE spring_freeboard SET
		   hit=hit+1
		   WHERE no=#{no}
		  </update>
		  <select id="boardDetailData" resultType="BoardVO" parameterType="int">
		   SELECT * FROM spring_freeboard
		   WHERE no=#{no}
		  </select>
      */
     public BoardVO boardDetailData(int no)
     {
    	 getSqlSession().update("boardHitIncrement",no);
    	 return getSqlSession().selectOne("boardDetailData", no);
     }
     /*
      *   <select id="boardFindData" resultType="BoardVO" parameterType="hashmap">
		   SELECT no,subject,name,redate as regdate,hit 
		   FROM spring_freeboard
		   <!-- 
		         fs=="name"
		         문자열 :
		            ==
		            equals
		    -->
		   <if test='fs.equals("name")'>
		     WHERE name LIKE '%'||#{ss}||'%'
		   </if>
		   <if test='fs.equals("subject")'>
		     WHERE subject LIKE '%'||#{ss}||'%'
		   </if>
		   <if test='fs.equals("content")'>
		     WHERE content LIKE '%'||#{ss}||'%'
		   </if>
		  </select>
      */
     public List<BoardVO> boardFindData(Map map)
     {
    	 List<BoardVO> list=null;
    	 try
    	 {
    		list=getSqlSession().selectList("boardFindData",map);
    	 }catch(Exception ex)
    	 {
    		 ex.printStackTrace();
    	 }
    	 return list;
     }
     public int boardFindDataCount(Map map)
     {
    	 return getSqlSession().selectOne("boardFindDataCount",map);
     }
}











