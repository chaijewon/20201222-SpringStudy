package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
@Repository
public class MovieDAO  extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public List<MovieVO> movieListData(Map map)
	{
		return getSqlSession().selectList("movieListData", map);
	}
	
	public int movieTotalPage(int cno)
	{
		return getSqlSession().selectOne("movieTotalPage", cno);
	}
	
	public MovieVO movieDetailData(int mno)
	{
		return getSqlSession().selectOne("movieDetailData", mno);
	}
   
}
