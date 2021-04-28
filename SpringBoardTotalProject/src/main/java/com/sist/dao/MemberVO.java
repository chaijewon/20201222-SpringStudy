package com.sist.dao;
/*
 *  ID   NOT NULL VARCHAR2(20) 
NAME NOT NULL VARCHAR2(30) 
SEX           VARCHAR2(10) 
PWD  NOT NULL VARCHAR2(10) 
 */
public class MemberVO {
    private String id;
    private String name;
    private String sex;
    private String pwd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	  
}
