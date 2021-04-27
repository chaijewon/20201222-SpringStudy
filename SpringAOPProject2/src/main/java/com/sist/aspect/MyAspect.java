package com.sist.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
   // 에러가 난 경우 
   @AfterThrowing(value="execution(* com.sist.manager.MyManager.display())", throwing="ex")
   public void afterThrowing(Exception ex)
   {
	   System.out.println("AOP에서 감지된 에러:"+ex.getMessage());
   }
}
