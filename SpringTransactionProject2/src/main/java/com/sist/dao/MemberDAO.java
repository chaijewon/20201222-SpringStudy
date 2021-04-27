package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MemberDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *   DML(INSERT,UPDATE,DELETE)이 여러개 일때
	 *   게시물 = 댓글 
	 *   답변 => 
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void memberInsert()
	{
		MemberVO vo=new MemberVO();
		vo.setNo(3);
		vo.setName("박문수");
		vo.setSex("남자");
		getSqlSession().insert("memberInsert",vo);
		
		vo=new MemberVO();
		vo.setNo(3);
		vo.setName("춘향이");
		vo.setSex("여자");
		getSqlSession().insert("memberInsert",vo);
		
	}
    
}










