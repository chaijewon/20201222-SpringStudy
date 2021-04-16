package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import java.util.*;
@Repository
public class MovieDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// 목록 읽기
	public List<MovieVO> movieListData(Map map)
	{
		return getSqlSession().selectList("movieListData", map);
	}
	// 총페이지 
	public int movieTotalPage()
	{
		return getSqlSession().selectOne("movieTotalPage");
	}
	// 상세보기
	public MovieVO movieDetailData(int mno)
	{
		return getSqlSession().selectOne("movieDetailData", mno);
	}
	// 찾기
	public List<MovieVO> movieFindData(String title)
	{
		return getSqlSession().selectList("movieFindData",title);
	}
    
}















