package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
 *  <context:component-scan base-package="com.sist.*"/>
    <!-- ViewResolver -->
    <bean id="viewResolver"
      class="org.springframework.web.servlet.view.InternalResourceViewResolver"
      p:prefix="/"
      p:suffix=".jsp"
    />
    <bean id="ds"
       class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@localhost:1521:XE"
       p:username="hr"
       p:password="happy"
    />
    <bean id="ssf"
      class="org.mybatis.spring.SqlSessionFactoryBean"
      p:dataSource-ref="ds"
      p:configLocation="/WEB-INF/config/Config.xml"
    />
 */
@Configuration
@EnableWebMvc
// <context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages={"com.sist.*"})
/*
 *                                 찾기(Model)
 *     요청 ===== DispatcherServlet ======= Controller(Model) 
 *                                 =======
 *                                 결과값 (Model)
 *                       |
 *                      ViewRsolver 
 *                       | request
 *                      JSP
 */
public class EmpConfig implements WebMvcConfigurer{
   // 클래스를 찾기 : HandlerMapping , 형변환 : HandlerAdapter => 두개 클래스를 초기화(메모리 할당)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
   /*
    *  <bean id="viewResolver"
	      class="org.springframework.web.servlet.view.InternalResourceViewResolver"
	      p:prefix="/"
	      p:suffix=".jsp"
	    />
    */
	@Bean(name="viewResolver")
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver rv=new InternalResourceViewResolver();
		rv.setPrefix("/");
		rv.setSuffix(".jsp");
		return rv;
	}
	/*
	 *   <bean id="ds"
	       class="org.apache.commons.dbcp.BasicDataSource"
	       p:driverClassName="oracle.jdbc.driver.OracleDriver"
	       p:url="jdbc:oracle:thin:@localhost:1521:XE"
	       p:username="hr"
	       p:password="happy"
	    />
	 */
	@Bean(name="ds")
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
	 *   <bean id="ssf"
		      class="org.mybatis.spring.SqlSessionFactoryBean"
		      p:dataSource-ref="ds"
		      p:configLocation="/WEB-INF/config/Config.xml"
		    />
	 */
	@Bean(name="ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		Resource res=new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);
		return ssf.getObject();
	}
}





















