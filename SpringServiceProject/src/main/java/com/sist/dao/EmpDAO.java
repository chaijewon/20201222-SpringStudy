package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class EmpDAO extends SqlSessionDaoSupport{
    // SqlSessionFactory => Config.xml(emp-mapper.xml,dept-mapper.xml) 파싱한 내용을 가지고 있다
	// 자동 주입 
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
    
	public List<EmpVO> empListData()
	{
		return getSqlSession().selectList("empListData");
	}
	
	public List<EmpVO> empdeptJoinData()
	{
		return getSqlSession().selectList("empdeptJoinData");
	}
	
	public List<EmpVO> empSubQueryData(String ename)
	{
		return getSqlSession().selectList("empSubQueryData",ename);
	}
}














