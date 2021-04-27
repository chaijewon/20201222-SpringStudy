package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// 메모리 할당이 아니라 => 공통 사용되는 메소드를 모아두는 곳 

import com.sist.dao.BoardDAO;
@Component
@Aspect
public class MyAspect {
   /*@Autowired
   private BoardDAO dao;*/
   
   @Before("execution(* com.sist.dao.BoardDAO.*(..))")
   /*
    *   * com.sist.dao.BoardDAO.*(..)
    *  ==                       = ===  .. 매개변수(X) , 매개변수(O=>데이터형과 갯수 상관)
    *  리턴형 (모든 리턴형)         모든 메소드 
    */
   public void before()
   {
	   System.out.println("오라클 연결...");
   }
   @After("execution(* com.sist.dao.BoardDAO.*(..))")
   public void after()
   {
	   System.out.println("오라클 연결 해제...");
   }
}









