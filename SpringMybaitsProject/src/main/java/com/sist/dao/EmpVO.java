package com.sist.dao;
import java.util.*;
/*
 *   => 단일 조건문 
 *   <if test="조건">실행 SQL</if>
 *   <if test="조건">name=#{name}</if>
 *   
 *   => 다중 조건문 
 *   <choose>
 *     <when test="">SQL</when>
 *     <when test="">SQL</when>
 *     <otherwise></otherwise> ==> else
 *   </choose>
 *   
 *   => <foreach> => IN(값,값,값...)
 *      <foreach collection="배열,List.." item="name"
 *          open="(" close=")" separator=",">
 *          #{name}
 *      </foreach>
 *   => <trim> => 추가 , 제거 
 *      <trim prefix="" suffix="" prefixOverrrides="OR">
 *      prefix="" : 앞에 추가 
 *      suffix="" : 맨뒤에 추가 
 *      prefixOverrrides="OR" : 제거 
 *      
 */
public class EmpVO {
    private int empno;
    private String ename;
    private String job;
    private Date hiredate;
    private int sal;
    private String dbday;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
   
}
