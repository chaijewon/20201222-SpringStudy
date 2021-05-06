package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 *     SqlSessionFactory ssf=new SqlSessionFactory()
 *     ssf.setConfigLocation(Config.xml);
 *     ssf.setDataSource(ds)
 */
import java.util.*;
@Repository
public class RecipeDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public List<RecipeVO> recipeListData(Map map)
	{
		return getSqlSession().selectList("recipeListData",map);
	}
	
	public int recipeTotalPage()
	{
		return getSqlSession().selectOne("recipeTotalPage");
	}
	
	public List<RecipeVO> recipeFindData(Map map)
	{
		return getSqlSession().selectList("recipeFindData",map);
	}
   
}
