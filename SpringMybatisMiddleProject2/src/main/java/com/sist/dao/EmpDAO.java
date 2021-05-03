package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class EmpDAO {
	@Autowired
    private EmpMapper mapper;
	
	public List<EmpVO> empJoinData()
	{
		return mapper.empJoinData();
	}
	
	public EmpVO empFindData(int empno)
	{
		return mapper.empFindData(empno);
	}
}
