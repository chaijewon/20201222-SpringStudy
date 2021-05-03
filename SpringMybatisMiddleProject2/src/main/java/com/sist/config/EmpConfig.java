package com.sist.config;

import javax.inject.Scope;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
// <context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages={"com.sist.*"})
@EnableWebMvc
public class EmpConfig implements WebMvcConfigurer{
    /*
                  요청 *.do
             |
         DispatcherServlet 
             |
          ***HandlerMapping : Model클래스를 찾아주는 역할 (스프링에서 동작하는 자체 라이브러리)
             |
           Model(사용자 정의 => @Controller) => POJO (상속,인터페이스 구현 이 없는 클래스)
             |
          ***HandlerAdapter : 형변환을 동일해게 제작  (스프링에서 동작하는 자체 라이브러리)
             |
         DispactherServlet : 설정 (web.xml)
             |
          ViewResolver : 설정  (자바,appplication-context.xml)
             |
            JSP 
     */
	// HandlerMapping,HandlerAdapter 생성 
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	// DataSource
	// @Bean(name="") => <bean id="ds" scope="propotype"> : XML코드는 자바로 변경할 때 주로 어노테이션 (XML을 대체하는 프로그램) 
	@Bean(name="ds")
	//@Scope("prototypy")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	// SSF
	@Bean(name="ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	// Mapper : SQL문장을 저장하고 있는 인터페이스의 메소드를 구현해 주는 역할 수행 => MapperFactoryBean  
	@Bean(name="mapper")
	public MapperFactoryBean mapperFactoryBean() throws Exception
	{
		MapperFactoryBean mapper=new MapperFactoryBean();
		mapper.setSqlSessionFactory(sqlSessionFactory());
		mapper.setMapperInterface(com.sist.dao.EmpMapper.class);
		return mapper;
	}
	// ViewResolver
	@Bean(name="viewResolver")
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}
	// Transcation
    
}


















