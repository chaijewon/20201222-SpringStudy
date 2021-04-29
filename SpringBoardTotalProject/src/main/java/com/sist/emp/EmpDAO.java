package com.sist.emp;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class EmpDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	/*
	 *   <select id="empGetEnameData" resultType="string">
		   SELECT DISTINCT ename FROM emp
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
	
	public List<String> empGetJobData()
	{
		return getSqlSession().selectList("empGetJobData");
	}
   
}
