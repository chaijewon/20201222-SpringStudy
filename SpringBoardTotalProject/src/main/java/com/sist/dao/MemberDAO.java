package com.sist.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
/*
 *    스프링 => 클래스 관리 
 *            ========
 *            객체 생성 => 객체주소를 저장 (필요한 데이터 설정:setterDI,constructorDI,MethodDI) 
 *            객체 소멸 => 메모리에서 삭제
 *    => 객체주소 주입
 *       @Autowired : 자동 주입 (스프링에서 저장된 객체주소중에 같은 클래스형을 찾아서 주입 , instanceof사용)
 *                    단점이 같은 유형의 클래스가 있는 경우에 찾지 못한다 
 *       @Qualifier : @Autowired단점 해결 => 특정객체를 지정
 *       @Resource  : @Autowired + @Qualifier
 */
import java.util.*;
@Repository
public class MemberDAO extends SqlSessionDaoSupport{

	@Autowired
	@Qualifier("ssf")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *    <!-- ID존재여부 -->
		  <select id="memberIdCount" resultType="int" parameterType="string">
		    SELECT COUNT(*) FROM webmember
		    WHERE id=#{id}
		  </select>
		  <!-- 비밀번호 확인 -->
		  <select id="memberGetPassword" resultType="hashmap" parameterType="string">
		    SELECT pwd,name FROM webmember
		    WHERE id=#{id}
		  </select>
	 */
	public String isLogin(String id,String pwd)
	{
		String result="";
		int count=getSqlSession().selectOne("memberIdCount",id);
		if(count==0)
		{
			result="NOID";
		}
		else
		{
			MemberVO vo=getSqlSession().selectOne("memberGetPassword", id);
			String db_pwd=vo.getPwd();
			String name=vo.getName();
			// Map을 통해서 가지고 올때 => key명은 column명이다 
			if(db_pwd.equals(pwd))
			{
				result=name;
			}
			else
			{
				result="NOPWD";
			}
		}
		return result;
	}
  
}















