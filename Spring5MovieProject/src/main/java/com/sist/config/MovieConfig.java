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
// application-context.xml => XML 대신 자바만 이용해서 사용 
/*
 *   <context:component-scan base-package="com.sist.*"/>
 *   <bean id="viewResolver"
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
         p:maxActive="10"
         p:maxIdle="10"
         p:maxWait="-1"
    />
    <!-- 마이바티스로 전송 : SqlSessionFactoryBean:getConnection(),disConnection() -->
    <bean id="ssf"
        class="org.mybatis.spring.SqlSessionFactoryBean"
        p:dataSource-ref="ds"
        p:configLocation="/WEB-INF/config/Config.xml"
    />
 */
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
//<context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages={"com.sist.*"})
// web에서 동작 
@EnableWebMvc
public class MovieConfig implements WebMvcConfigurer{
   /*
    *   <bean id="viewResolver"
          class="org.springframework.web.servlet.view.InternalResourceViewResolver"
          p:prefix="/"
          p:suffix=".jsp"
        />
    */
	
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver r=new InternalResourceViewResolver();
		r.setPrefix("/");
		r.setSuffix(".jsp");
		return r;
	}
	// HandlerMapping,HandlerAdapter초기화
	/*
	 *  요청 => DisaptcherServlet => HandlerMapping =============> ModelClass =====> HandlerAdapter 
	 *                             @Controller=>@RequestMapping       Model => HttpServletRequest
	 *                             클래스 찾기
	 *                             
	 *                             DispatcherServlet ==> ViewResolver => JSP
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		    configurer.enable();
	}
	/*
	 *  <bean id="ds"
         class="org.apache.commons.dbcp.BasicDataSource"
         p:driverClassName="oracle.jdbc.driver.OracleDriver"
         p:url="jdbc:oracle:thin:@localhost:1521:XE"
         p:username="hr"
         p:password="happy"
         p:maxActive="10"
         p:maxIdle="10"
         p:maxWait="-1"
    />
	 */
	@Bean
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
	 * <bean id="ssf"
        class="org.mybatis.spring.SqlSessionFactoryBean"
        p:dataSource-ref="ds"
        p:configLocation="/WEB-INF/config/Config.xml"
    />
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		Resource res=new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);
		return ssf.getObject();
	}
}















