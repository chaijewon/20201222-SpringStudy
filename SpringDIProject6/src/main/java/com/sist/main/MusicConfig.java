package com.sist.main;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
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
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	
	/*
	 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
	      p:dataSource-ref="ds"
	      p:configLocation="classpath:Config.xml"
	    />
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		Resource res=new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);
		return ssf.getObject();
	}
	/*
	 * <bean id="dao" class="com.sist.main.MusicDAO"
	      p:sqlSessionFactory-ref="ssf"
	    />   
	 */
	@Bean("dao")
	public MusicDAO musicDAO() 
	{
		MusicDAO dao=new MusicDAO();
		try
		{
			dao.setSqlSessionFactory(sqlSessionFactory());
		}catch(Exception ex){}
		return dao;
	}
}
