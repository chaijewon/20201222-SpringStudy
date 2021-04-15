package com.sist.main;

import org.mybatis.spring.support.SqlSessionDaoSupport;
/*
 *   => SqlSessionDaoSupport 
 *      데이터베이스 정보 (DataSource)
 *      SqlSessionFactory : getConnection,disConnection ==> 스프링에서 셋팅
 *      =================
 *      SqlSession => sql문장 전송 , 결과값을 받는 역할 
 */
public class MusicDAO extends SqlSessionDaoSupport{

}
