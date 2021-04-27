package com.sist.dao;

import org.springframework.stereotype.Repository;
/*
 *    AOP (횡단지향프로그램) : 분석이 어렵다  => 스프링에서 지원하는 로그파일,트랜잭션 , 보안 (AOP)
 *    
 *    public void insert()
 *    {
 *       getConnection();
 *       try
 *       {
 *           conn.setAutoCommit(false);
 *           INSERT문장 실행
 *           INSERT문장 실행
 *           conn.commit();
 *       }catch(Exception ex)
 *       {
 *           conn.rollback();
 *           ex.printStackTrace();
 *       }
 *       finally
 *       {
 *          conn.setAutoCommit(true)
 *          disConnection();
 *       }
 *       
 *    }
 *    
 *    @Transactional
 *    public void insert()
 *    {
 *           getConnection();
 *           INSERT문장 실행
 *           INSERT문장 실행
 *           disConnection();
 *    }
 *    
 *    1. JoinPoint
 *         어디에서 호출 
 *         BEFORE
 *         public void display()
 *         {
 *             ====> Before
 *             try
 *             {
 *             
 *             }catch(Exception ex)
 *             {
 *             
 *             }
 *         }
 *         AFTER
 *         public void display()
 *         {
 *             
 *             try
 *             {
 *             
 *             }catch(Exception ex)
 *             {
 *             
 *             }
 *             finally
 *             {
 *                ==> After
 *             }
 *         }
 *         AFTERRETURNING
 *         public void display()
 *         {
 *             
 *             try
 *             {
 *             
 *             }catch(Exception ex)
 *             {
 *             
 *             }
 *             finally
 *             {
 *                ==> After
 *             }
 *             
 *             return => 정상수행 => return값을 받을 수 있다 
 *         }
 *         AFTERTHROWING
 *         public void display()
 *         {
 *             
 *             try
 *             {
 *             
 *             }catch(Exception ex)
 *             {
 *                => 에러발생시 처리 => 에러내용을 받아 볼 수 있다 
 *             }
 *             finally
 *             {
 *                ==> After
 *             }
 *         }
 *         AROUND
 *         public void display()
 *         {
 *             
 *             try
 *             {
 *                ==============
 *                  소수 코딩 
 *                ==============
 *             }catch(Exception ex)
 *             {
 *             
 *             }
 *             finally
 *             {
 *                ==> After
 *             }
 *         }
 *    2. PointCut
 *         어떤 메소드가 호출될때 적용 
 *    3. Advice
 *         JointPoint+PointCut
 *    4. Aspect
 *         Advice여러개를 가지고 있는 클래스 
 */
@Repository
public class BoardDAO {
   /*public void getConnection()
   {
	   System.out.println("오라클 연결...");
   }
   public void disConnection()
   {
	   System.out.println("오라클 연결 해제...");
   }*/
   public void aopselect()
   {
	   //getConnection(); // 반복
	   System.out.println("SELECT 문장 수행 완료..."); // 핵심모듈 (스프링 => 핵심만 코딩한다)
	   //disConnection(); // 반복  ==> 반복 구간 (공통모듈:관심사)
   }
   public void aopinsert(String name)
   {
	   //getConnection();
	   System.out.println("INSERT 문장 수행 완료("+name+") 입력...");
	   //disConnection();
   }
   public void aopupdate()
   {
	   //getConnection();
	   System.out.println("UPDATE 문장 완료...");
	   //disConnection();
   }
   public void aopdelete()
   {
	   //getConnection();
	   System.out.println("DELETE 문장 완료...");
	   //disConnection();
   }
   public String aopfind()
   {
	  // getConnection();
	   System.out.println("SELECT ~ FIND 문장 완료...");
	   //disConnection();
	   return "홍길동";
   }
}
