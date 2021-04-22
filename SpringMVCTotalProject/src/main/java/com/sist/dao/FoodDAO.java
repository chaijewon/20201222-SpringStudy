package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

import javax.annotation.Resource;

import com.sist.vo.*;

@Repository
public class FoodDAO extends SqlSessionDaoSupport{

	@Resource(name="ssf")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *   <select id="categoryListData" resultType="CategoryVO" parameterType="int">
		    SELECT * FROM food_category
		    WHERE no=#{no}
		  </select>
	 */
	public List<CategoryVO> categoryListData(int no)
	{
		Map map=new HashMap();
		map.put("no", no);
		return getSqlSession().selectList("categoryListData",map);
	}
	/*
	 *   <select id="categoryFoodListData" resultType="FoodVO" parameterType="int">
		    SELECT no,poster,address,tel,score
		    FROM food_house
		    WHERE cno=#{cno}
		  </select>
	 */
	public List<FoodVO> categoryFoodListData(int cno)
	{
		return getSqlSession().selectList("categoryFoodListData",cno);
	}
	
	/*
	 *  <select id="foodDetailData" resultType="FoodVO" parameterType="int">
		    SELECT * FROM food_house
		    WHERE no=#{no}
		  </select>
	 */
	public FoodVO foodDetailData(int no)
	{
		return getSqlSession().selectOne("foodDetailData", no);
	}
    
}













