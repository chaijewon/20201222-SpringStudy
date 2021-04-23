package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.sist.vo.*;
@Repository
public class RecipeDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *   <select id="recipeListData" resultType="RecipeVO" parameterType="hashmap">
		   SELECT no,title,poster,chef,num
		   FROM (SELECT no,title,poster,chef,rownum as num 
		   FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)/no,title,poster,chef 
		   FROM recipe))
		   WHERE num BETWEEN #{start} AND #{end}
		  </select>
		  <select id="recipeTotalPage" resultType="int">
		    SELECT CEIL(COUNT(*)/12.0) FROM recipe
		  </select>
		  <select id="recipeDetailData" resultType="RecipeDetailVO" parameterType="int">
		    SELECT * FROM recipe_make
		    WHERE rno=#{rno}
		  </select>
	 */
	public List<RecipeVO>  recipeListData(Map map)
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
