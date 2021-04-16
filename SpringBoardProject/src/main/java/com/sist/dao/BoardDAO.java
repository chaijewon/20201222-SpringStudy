package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 *   CONSTRUCTOR, FIELD, METHOD, PARAMETER
     public class A
     {
         @Autowired
         BoardDAO dao;  FIELD (멤버변수)
         
         @Autowired
         public A(BoardDAO dao){} CONSTRUCTOR
         
         @Autowired
         public void setBoardDAO(BoardDAO dao){} METHOD
         
         @Autowired
         public void init(BoardDAO dao){} PARAMETER
     }
 */
import java.util.*;
@Repository
public class BoardDAO extends SqlSessionDaoSupport{

	// @Autowired : 스프링에서 클래스를 찾아서 자동으로 객체주소를 넘겨준다 (일반변수는 사용하지 않는다) : 객체주소값만 주입
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	// 목록 출력 
    public List<BoardVO> boardListData(Map map)
    {
    	return getSqlSession().selectList("boardListData",map);
    }
    // 총페이지 
    public int boardTotalpage()
    {
    	return getSqlSession().selectOne("boardTotalpage");
    }
    // 상세보기 
    public BoardVO boardDetailData(int no)
    {
    	getSqlSession().update("boardHitIncrement",no); // 조회수증가 
    	return getSqlSession().selectOne("boardDetailData", no);
    }
    // 글쓰기
    public void boardInsert(BoardVO vo)
    {
    	getSqlSession().insert("boardInsert",vo);
    }
    // 수정데이터 읽기 => 같은 SQL문장이 있는 경우 재사용이 가능 
    public BoardVO boardUpdateData(int no)
    {
    	return getSqlSession().selectOne("boardDetailData",no);
    }
    // 수정하기
    public boolean boardUpdate(BoardVO vo)
    {
    	boolean bCheck=false;
    	// 비밀번호 받기 
    	String db_pwd=getSqlSession().selectOne("boardGetPassword",vo.getNo());
    	if(db_pwd.equals(vo.getPwd()))
    	{
    		bCheck=true;
    		getSqlSession().update("boardUpdate",vo);
    	}
    	else
    	{
    		bCheck=false;
    	}
    	return bCheck;
    }
    // 삭제하기
    public boolean boardDelete(int no,String pwd)
    {
    	boolean bCheck=false;
    	String db_pwd=getSqlSession().selectOne("boardGetPassword",no);
    	if(db_pwd.equals(pwd))
    	{
    		getSqlSession().delete("boardDelete",no);
    		bCheck=true;
    	}
    	return bCheck;
    }
}






















