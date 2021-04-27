package com.sist.dao;

import org.springframework.stereotype.Repository;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.sql.*;
@Repository
public class MemberDAO {
    private Connection conn;
    private PreparedStatement ps;
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    // 객체 생성시에 호출되는 메소드 지정 => XML(init-method)
    @PostConstruct
    public void init()
    {
    	try
    	{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    	}catch(Exception ex){}
    }
    // 객체가 메모리에서 삭제 메소드 지정 => XML(destory-method)
    @PreDestroy
    public void close()
    {
    	try
    	{
    		if(ps!=null) ps.close();
    		if(conn!=null) conn.close();
    	}catch(Exception ex){}
    }
    
    public void getConnection()
    {
    	try
    	{
    		conn=DriverManager.getConnection(URL,"hr","happy");
    	}catch(Exception ex){}
    }
    public void disConnection()
    {
    	try
    	{
    		if(ps!=null) ps.close();
    		if(conn!=null) conn.close();
    	}catch(Exception ex){}
    }
    
    // 기능 설정 (DML여러개 있는 경우) = 동시에 처리 (트랜잭션)
    public void memberInsert()
    {
    	try
    	{
    		getConnection();
    		String sql="INSERT INTO spring_member VALUES(1,'홍길동','남자')"; // 출금
    		ps=conn.prepareStatement(sql);
    		ps.executeUpdate(); // commit
    		
    		sql="INSERT INTO spring_member VALUES(1,'심청이','여자')"; //입금
    		ps=conn.prepareStatement(sql);
    		ps.executeUpdate(); // catch => rollback
    		
    		
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		disConnection();
    	}
    }
    // 트랜잭션 처리
    public void memberInsert2()
    {
    	try
    	{
    		getConnection(); // Before
    		conn.setAutoCommit(false); // commit()을 해제 
    		
    		String sql="INSERT INTO spring_member VALUES(2,'홍길동2','남자')"; // 출금
    		ps=conn.prepareStatement(sql);
    		ps.executeUpdate(); // commit(X)
    		
    		sql="INSERT INTO spring_member VALUES(1,'심청이','여자')"; //입금
    		ps=conn.prepareStatement(sql);
    		ps.executeUpdate(); // commit(X)
    		
    		conn.commit(); // Around
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    		try
    		{
    			conn.rollback();// 전체 취소  AfterThrowing
    		}catch(Exception e){}
    	}
    	finally
    	{
    		try
    		{
    			conn.setAutoCommit(true); // After
    		}catch(Exception ex){}
    		disConnection();
    	}
    }
    
}













