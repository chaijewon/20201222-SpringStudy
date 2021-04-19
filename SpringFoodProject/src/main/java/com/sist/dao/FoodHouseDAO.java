package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;

@Repository
public class FoodHouseDAO extends SqlSessionDaoSupport{
    /*
     *  <bean id="ssf"
	       class="org.mybatis.spring.SqlSessionFactoryBean"
	       p:dataSource-ref="ds"
	       p:configLocation="/WEB-INF/config/Config.xml"
	    />
	    public class A
	    {
	       @Autowired
	       private B b; : FIELD 
	       
	       @Autowired
	       public A(B b)  : CONSTRUCTOR (매개변수에 값 주입)
	       {
	       
	       }
	       
	       @Autowired
	       public void setB(B b) : METHOD
	       {
	       
	       }
	       
	       @Autowired
	       public void initDao(B b) : PARAMETER
	       {
	       
	       }
	    }
     */
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// sql실행 문장 
	public List<FoodHouseVO> categoryFoodData(int cno)
	{
		return getSqlSession().selectList("categoryFoodData",cno);
	}
	
	
   
}











