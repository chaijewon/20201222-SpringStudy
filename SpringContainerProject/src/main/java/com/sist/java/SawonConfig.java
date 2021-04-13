package com.sist.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SawonConfig {
	//<bean id="sa" class="com.sist.main.Sawon"/>
   @Bean("sa")
   public Sawon sawonInfo()
   {
	   Sawon s=new Sawon();
	   return s;
   }
}
