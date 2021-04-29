package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
// 메모리 할당 
// SqlSessionFactory => 스프링으로부터 받아 온다 
@Repository
public class EmpDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
   // sqlsessionFactory를 받는다 
	/*
	 *  <select id="empGetEnameData" resultType="string">
		    SELECT ename FROM emp
		  </select>
		  <select id="empFindData" resultType="com.sist.dao.EmpVO" parameterType="hashmap">
		    SELECT empno,ename,job,TO_CHAR(hiredate,'YYYY/MM/DD') as dbday,sal
		    FROM emp
		    WHERE ename 
		    <trim prefix="IN">
		     <foreach collection="names" item="ename" open="(" close=")" separator=",">#{ename}</foreach>
		    </trim>
		  </select>
	 */
	public List<String> empGetEnameData()
	{
		return getSqlSession().selectList("empGetEnameData");
	}
	public List<EmpVO> empFindData(Map map)
	{
		return getSqlSession().selectList("empFindData",map);
	}
   
}






