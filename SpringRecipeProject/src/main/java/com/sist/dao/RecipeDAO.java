package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class RecipeDAO extends SqlSessionDaoSupport{
	// 스프링에서 생성된 SqlSessionFactory 객체를 받아 온다 
	// getBean() , 어노테이션 이용 (@Autowired,@Resource(name=""), XML이용 
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
   
    // 기능 설정 
	public List<RecipeVO> recipeListData(Map map)
	{
		return getSqlSession().selectList("recipeListData", map);
	}
	
	public int recipeTotalPage()
	{
		return getSqlSession().selectOne("recipeTotalPage");
	}
	
	public RecipeDetailVO recipeDetailData(int rno)
	{
		return getSqlSession().selectOne("recipeDetailData", rno);
	}
}








