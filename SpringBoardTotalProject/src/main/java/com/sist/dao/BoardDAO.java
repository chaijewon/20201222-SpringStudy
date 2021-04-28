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
}











