package com.sist.config;

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
// <context-component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages={"com.sist.*"})
@EnableWebMvc
/*
 *    사용자 요청 => DisptcherServlet => HandleMapping => Model클래스 => HandlerAdapter => DispatcherServlet
 *               ================
 *                 web.xml
 *      => ViewResolver => JSP
 *         ============
 *          application-context.xml
 *     *.do
 */
public class RecipeConfig implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
    // 필요한 객체 생성 => <bean> => @Bean
	/*
	 *   <bean id="ds"
	 *      class="org.apache.commons.dbcp.BasicDataSource"
	 *      p:driverClassName=""
	 *      p:url=""
	 *      p:username=""
	 *      p:password=""
	 *      p:maxActive=""
	 *      p:maxIdle=""
	 *      p:maxWait="">
	 */
	@Bean(name="ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		ds.setMaxActive(10);
		ds.setMaxIdle(10);
		ds.setMaxWait(-1);
		return ds;
	}
	/*
	 *   <bean id="ssf"
	 *     class="org.mybatis.spring.SqlSessionFactoryBean"
	 *     p:dataSource-ref="ds"
	 *     p:configLocation="/WEB-INF/config/Config.xml" => MyBatis(Annotation)
	 *   />
	 */
	@Bean(name="ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	
	@Bean(name="viewReoslver")
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Bean(name="recipeMapper")
	public MapperFactoryBean recipeMapper() throws Exception
	{
		MapperFactoryBean mfb=new MapperFactoryBean();
		// SqlSessionFactory
		mfb.setSqlSessionFactory(sqlSessionFactory());
		mfb.setMapperInterface(com.sist.mapper.RecipeMapper.class);
		return mfb;
	}
	@Bean(name="chefMapper")
	public MapperFactoryBean chefMapper() throws Exception
	{
		MapperFactoryBean mfb=new MapperFactoryBean();
		// SqlSessionFactory
		mfb.setSqlSessionFactory(sqlSessionFactory());
		mfb.setMapperInterface(com.sist.mapper.ChefMapper.class);
		return mfb;
	}
	
}













