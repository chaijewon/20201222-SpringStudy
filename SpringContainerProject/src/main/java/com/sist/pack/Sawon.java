package com.sist.pack;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
/*
 *    메모리 할당 
 *    @Component : 일반 클래스 
 *    @Repository : DAO
 *    @Service : DAO+DAO (BI)
 *    @Controller : Model(return 경로/파일)
 *    @RestController : Model (return 문자열) => Ajax,Json,XML
 *    @Bean
 *    
 *    Sawon => sawon
 *    BoardDAO ==> boardDAO
 */
@Component
//@Repository
public class Sawon {
	   private String name;
	   private String sex;
	   private String addr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	   
}
