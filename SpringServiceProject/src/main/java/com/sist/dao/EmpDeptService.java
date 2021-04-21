package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class EmpDeptService {
   @Autowired
   private EmpDAO eDao;
   
   @Autowired
   private DeptDAO dDao;
   
   public List<EmpVO> empListData()
   {
	   return eDao.empListData();
   }
   public List<DeptVO> deptListData()
   {
	   return dDao.deptListData();
   }
   
   public List<EmpVO> empdetpJoinData()
   {
	   return eDao.empdeptJoinData();
   }
   
   public List<EmpVO> empSubQueryData(String ename)
   {
	   return eDao.empSubQueryData(ename);
   }
   
}
