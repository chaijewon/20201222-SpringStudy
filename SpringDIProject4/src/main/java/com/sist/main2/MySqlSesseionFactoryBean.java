package com.sist.main2;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/*
 *   <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
       p:dataSource-ref="ds"
       p:configLocation="classpath:config.xml"
    />
 */
@Component("ssf")
public class MySqlSesseionFactoryBean extends SqlSessionFactoryBean{

	@javax.annotation.Resource(name="ds")
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
    public MySqlSesseionFactoryBean()
    {
    	try
    	{
    		Resource res=new ClassPathResource("config.xml");
        	setConfigLocation(res);
    	}catch(Exception ex){}
    }
}










