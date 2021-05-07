package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class ShopDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void shopGoodsInsert(ShopVO vo)
	{
		getSqlSession().insert("shopGoodsInsert",vo);
	}
	
	/*
	 *  <select id="shopGoodsListData" resultType="ShopVO" parameterType="hashmap">
		    SELECT no,title,poster,price,num 
		    FROM (SELECT no,title,poster,price,rownum as num 
		    FROM (SELECT /*+ INDEX_ASC(shop_goods sg_no_pk) / no,title,poster,price 
		    FROM shop_goods WHERE cno=#{cno}))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
	 */
   public List<ShopVO> shopGoodsListData(Map map)
   {
	   List<ShopVO> list=new ArrayList<ShopVO>();
	   try
	   {
		   list=getSqlSession().selectList("shopGoodsListData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   return list;
   }
   /*
    *   <select id="shopGoodsTotalPage" parameterType="int">
		    SELECT CEIL(COUNT(*)/18.0) FROM shop_goods
		    WHERE cno=#{cno}
		  </select>
    */
   public int shopGoodsTotalPage(int cno)
   {
	   return getSqlSession().selectOne("shopGoodsTotalPage",cno);
   }
}








