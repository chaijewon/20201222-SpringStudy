package com.sist.manager;

import org.springframework.stereotype.Component;

@Component
public class MyManager {
   public void display()
   {
	   int i=10/0;
	   System.out.println("i="+i);
   }
}
