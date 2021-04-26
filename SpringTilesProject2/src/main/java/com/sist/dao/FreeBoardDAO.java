package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.sist.vo.FreeBoardVO;

import java.util.*;

import javax.annotation.Resource;
@Repository
public class FreeBoardDAO extends SqlSessionDaoSupport{

	@Resource(name="ssf")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	// 목록 
	public List<FreeBoardVO> freeboardListData(Map map)
	{
		return getSqlSession().selectList("freeboardListData", map); // map => #{start} #{end}
	}
	
	// 총페이지 
    public int freeboardTotalPage()
    {
    	return getSqlSession().selectOne("freeboardTotalPage");
    }
    
    // 상세보기
    // 수정하기
    // 삭제하기 
    // 게시물 추가
    // 찾기 => 마이바티스의 동적 SQL 
}














