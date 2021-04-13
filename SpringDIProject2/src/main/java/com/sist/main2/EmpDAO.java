package com.sist.main2;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class EmpDAO extends JdbcDaoSupport{
   public List empAllData()
   {
	   return getJdbcTemplate().query("SELECT empno,ename,job,hiredate,sal FROM emp",new RowMapper(){
            
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				EmpVO vo=new EmpVO();
				    rs.next();
					vo.setEmpno(rs.getInt(1));
					vo.setEname(rs.getString(2));
					vo.setJob(rs.getString(3));
					vo.setHiredate(rs.getDate(4));
					vo.setSal(rs.getInt(5));
				
				return vo;
			}
		   
	   });
	   
   }
}
