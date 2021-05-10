package com.sist.dao;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/*
 *      ID    NOT NULL VARCHAR2(20)  
		PWD   NOT NULL VARCHAR2(10)  
		NAME  NOT NULL VARCHAR2(34)  
		SEX            VARCHAR2(10)  
		AGE            NUMBER        
		EMAIL          VARCHAR2(200) 
		POST  NOT NULL VARCHAR2(10)  
		ADDR1 NOT NULL VARCHAR2(300) 
		ADDR2          VARCHAR2(300) 
		TEL            VARCHAR2(20)  
 */
public class MemberVO {
	  @NotBlank
	  private String id;
	  @NotBlank
	  private String pwd;
	  @NotBlank
	  private String name;
	  @NotBlank
	  private String sex;
	  @Min(20)
	  private int age;
	  @Email
	  private String email;
	  @NotBlank
	  private String post;
	  @NotBlank
	  private String addr1;
	  private String addr2;
	  private String tel;
	  private String msg;
	  private int admin;
	  
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	  
}
