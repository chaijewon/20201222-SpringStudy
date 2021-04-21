package com.sist.temp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MyApp implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware{
    private String name;
    private String sex;
    public MyApp()
    {
    	System.out.println("메모리 할당후 스프링 컨테이너네 저장");
    }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("name => setter 완료");
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		System.out.println("sex => setter 완료");
		this.sex = sex;
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("setBeanName Call..:"+name);
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destory() Call...");
	}
    
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet() Call...");
	}
	public void init_user()
	{
		System.out.println("init_user() Call...");
	}
	public void destory_user()
	{
		System.out.println("destory_user() Call...");
	}
	public void userCall()
	{
		System.out.println("=== 프로그래머 호출 ===");
		System.out.println("이름:"+name);
		System.out.println("성별:"+sex);
		System.out.println("==================");
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("setBeanFactory Call..:"+beanFactory.getClass());
	}

}
