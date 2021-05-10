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
   /*
    *   <select id="shopGoodsDetailData" resultType="ShopVO" parameterType="int">
	     SELECT no,title,poster,price,account
	     FROM shop_goods
	     WHERE no=#{no}
	   </select>
    */
   public ShopVO shopGoodsDetailData(int no)
   {
	   return getSqlSession().selectOne("shopGoodsDetailData",no);
   }
   // <insert id="shopGoodsInputInsert" parameterType="ShopInputVO">
   public void shopGoodsInputInsert(ShopInputVO vo)
   {
	   getSqlSession().insert("shopGoodsInputInsert",vo);
   }
   // <select id="myAdminPageListData" resultMap="shopInputMap" parameterType="string">
   public List<ShopInputVO> myAdminPageListData(String id)
   {
	   return getSqlSession().selectList("myAdminPageListData",id);
   }
   // <select id="adminPageListData" resultMap="shopInputMap">
   public List<ShopInputVO> adminPageListData()
   {
	   return getSqlSession().selectList("adminPageListData");
   }
   /*
    *  <update id="adminOkUpdate" parameterType="int">
		     UPDATE shop_input SET
		     state='y'
		     WHERE no=#{no}
		   </update>
    */
   public void adminOkUpdate(int no)
   {
	   getSqlSession().update("adminOkUpdate",no);
   }
}








