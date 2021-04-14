package com.sist.main;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
public interface EmpMapper {
  @Select("SELECT empno,ename,job,hiredate,sal FROM emp")
  public List<EmpVO> empListData();
  @Select("SELECT empno,ename,job,hiredate,sal FROM emp WHERE empno=#{empno}")
  public EmpVO empDetailData(int empno);
 
}
