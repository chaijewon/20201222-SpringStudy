package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MemberDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *  <select id="memberIdCount" resultType="int" parameterType="string">
		    SELECT COUNT(*) FROM shop_member
		    WHERE id=#{id}
		  </select>
		  <!-- 비밀번호 확인 -->
		  <select id="memberGetPwd" resultType="MemberVO" parameterType="string">
		    SELECT pwd,name,admin
		    FROM shop_member
		    WHERE id=#{id}
		  </select>
	 */
	public MemberVO memberLogin(String id,String pwd)
	{
		MemberVO vo=new MemberVO();
		try
		{
			int count=getSqlSession().selectOne("memberIdCount",id);
			if(count==0) //ID가 없는 상태
			{
				vo.setMsg("NOID");
			}
			else // ID가 존재하는 상태
			{
				// 비밀번호 검색
				vo=getSqlSession().selectOne("memberGetPwd",id);
				if(pwd.equals(vo.getPwd()))
				{
					vo.setMsg("OK");
				}
				else
				{
					vo.setMsg("NOPWD");
				}
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return vo;
	}
   
}











