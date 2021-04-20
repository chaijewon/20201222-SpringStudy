package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
// 메모리 할당 => 스프링에서  객체주소 주입 
@Repository
public class DataBoardDAO extends SqlSessionDaoSupport{
	// SqlSessionFactory => 오라클 연결을 할 수 있다
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
   
    // 목록 출력 
	public List<DataBoardVO> databoardListData(Map map)
	{
		return getSqlSession().selectList("databoardListData", map);
	}
	// 데이터 추가
	public void databoardInsert(DataBoardVO vo)
	{
		getSqlSession().insert("databoardInsert", vo);
	}
	// 상세보기
	// databoardHitIncrement
	public DataBoardVO databoardDetailData(int no)
	{
		// 조회수 증가 
		getSqlSession().update("databoardHitIncrement",no);
		// 실제데이터 읽기
		return getSqlSession().selectOne("databoardDetailData", no);
	}
	// 수정
	// 삭제 
}














