package com.sist.main;

import org.apache.ibatis.annotations.Select;
import java.util.*;
public interface EmpMapper {
  @Select("SELECT empno,ename,job,hiredate,sal FROM emp")
  public List<EmpVO> empListData();
}
