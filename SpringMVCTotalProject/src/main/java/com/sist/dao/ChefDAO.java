package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import java.util.*;
@Repository
public class ChefDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
    /*
     * <select id="chefListData" resultType="ChefVO" parameterType="hashmap">
	   SELECT chef_name,poster,mc1,mc2,mc3,mc7,num
	   FROM (SELECT chef_name,poster,mc1,mc2,mc3,mc7,rownum as num
	   FROM (SELECT chef_name,poster,mc1,mc2,mc3,mc7 
	   FROM chef ORDER BY chef_name ASC))
	   WHERE num BETWEEN #{start} AND #{end}
	  </select>
	  <select id="chefTotalPage" resultType="int">
	    SELECT CEIL(COUNT(*)/20.0) FROM chef
	  </select>
	  <select id="chefMakeRecipeData" resultType="RecipeVO" parameterType="string">
	    SELECT no,title,poster,chef,num
	    FROM (SELECT no,title,poster,chef,rownum as num 
	    FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk)/no,title,poster,chef 
	    FROM recipe WHERE chef=#{chef}))
	    WHERE num BETWEEN #{start} AND #{end}
	  </select>
	  <select id="chefMakeRecipeTotalPage" resultType="int" parameterType="string">
	    SELECT CEIL(COUNT(*)/12.0) FROM recipe
	    WHERE chef=#{chef}
	  </select>
     */
	public List<ChefVO> chefListData(Map map)
	{
		return getSqlSession().selectList("chefListData", map);
	}
	
	public int chefTotalPage()
	{
		return getSqlSession().selectOne("chefTotalPage");
	}
	
	public List<RecipeVO> chefMakeRecipeData(Map map)
	{
		return getSqlSession().selectList("chefMakeRecipeData", map);
	}
	
	public int chefMakeRecipeTotalPage(String chef)
	{
		return getSqlSession().selectOne("chefMakeRecipeTotalPage", chef);
	}
}
