package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BoardAspect {
   @Around("execution(* com.sist.web.BoardController.*(..))")
   public Object around(ProceedingJoinPoint jp)
   {
	   Object obj=null;
	   try
	   {
		   long start=System.currentTimeMillis();
		   obj=jp.proceed();// 메소드 호출 
		   long end=System.currentTimeMillis();
		   System.out.println("사용자 요청 메소드:"+jp.getSignature());
		   System.out.println("수행시간:"+(end-start));
		   // log파일
	   }catch(Throwable ex){}
	   return obj;
   }
   
}











