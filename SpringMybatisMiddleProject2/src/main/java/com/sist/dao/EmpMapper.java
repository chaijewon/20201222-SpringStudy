package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
public interface EmpMapper {
   // 조인 <resultMap>
   @Results({
	   @Result(property="empno",column="empno"), // setEmpno(rs.getInt("empno"))
	   @Result(property="ename",column="ename"),
	   @Result(property="job",column="job"),
	   @Result(property="mgr",column="mgr"),
	   @Result(property="hiredate",column="hiredate"),
	   @Result(property="sal",column="sal"),
	   @Result(property="comm",column="comm"),
	   @Result(property="deptno",column="deptno"), // setDeptno(rs.getInt("deptno"))
	   @Result(property="dvo.dname",column="dname"),  // getDvo().setDname(rs.getString("dname"))
	   @Result(property="dvo.loc",column="loc")
   })
   @Select("SELECT empno,ename,job,mgr,hiredate,sal,com,emp.deptno,dname,loc "
		  +"FROM emp,dept "
		  +"WHERE emp.deptno=dept.deptno")
   public List<EmpVO> empJoinData();
   // ResultSet rs=ps.executeQuery();
   // rs.next(); => vo.setXxx()...
   @Results({
	   @Result(property="empno",column="empno"), // setEmpno(rs.getInt("empno"))
	   @Result(property="ename",column="ename"),
	   @Result(property="job",column="job"),
	   @Result(property="mgr",column="mgr"),
	   @Result(property="hiredate",column="hiredate"),
	   @Result(property="sal",column="sal"),
	   @Result(property="comm",column="comm"),
	   @Result(property="deptno",column="deptno"), // setDeptno(rs.getInt("deptno"))
	   @Result(property="dvo.dname",column="dname"),  // getDvo().setDname(rs.getString("dname"))
	   @Result(property="dvo.loc",column="loc")
   })
   @Select("SELECT empno,ename,job,mgr,hiredate,sal,com,emp.deptno,dname,loc "
		  +"FROM emp,dept "
		  +"WHERE emp.deptno=dept.deptno "
		  +"AND empno=#{empno}")
   public EmpVO empFindData(int empno);
   
}







