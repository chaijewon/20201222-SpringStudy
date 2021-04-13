package com.sist.main;
import java.util.*;
public class EmpDAO {
    private EmpMapper mapper;

	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<EmpVO> empListData()
	{
		return mapper.empListData();
	}
   
}
