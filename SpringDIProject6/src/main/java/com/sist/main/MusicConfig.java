package com.sist.main;

import org.springframework.context.annotation.Configuration;
// 클래스 등록 (xml없이 순수자바만 이용해서 등록)
/*
 *   <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
      p:driverClassName="#{db['driver']}"
      p:url="#{db['url']}"
      p:username="#{db['username']}"
      p:password="#{db['password']}"
    />
    <!-- MyBatis로 전송  -->
    <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
      p:dataSource-ref="ds"
      p:configLocation="classpath:Config.xml"
    />
    <!-- 사용자 정의 DAO에 전송 -->
    <bean id="dao" class="com.sist.main.MusicDAO"
      p:sqlSessionFactory-ref="ssf"
    />   
 */
@Configuration
public class MusicConfig {
   /*
    *  <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
	      p:driverClassName="#{db['driver']}"
	      p:url="#{db['url']}"
	      p:username="#{db['username']}"
	      p:password="#{db['password']}"
       />
    */
	/*
	 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
	      p:dataSource-ref="ds"
	      p:configLocation="classpath:Config.xml"
	    />
	 */
	/*
	 * <bean id="dao" class="com.sist.main.MusicDAO"
	      p:sqlSessionFactory-ref="ssf"
	    />   
	 */
}
