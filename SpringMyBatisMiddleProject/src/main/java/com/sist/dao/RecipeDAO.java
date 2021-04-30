package com.sist.dao;
import java.util.*;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class RecipeDAO {
	@Resource(name="recipeMapper")
    private RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData(Map map)
	{
		return mapper.recipeListData(map);
	}
	
	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}
	
	public int recipeCount()
	{
		return mapper.recipeCount();
	}
	public RecipeDetailVO recipeDetailData(int no)
	{
		return mapper.recipeDetailData(no);
	}
	public List<RecipeVO> findAllData()
	{
		return mapper.findAllData();
	}
	 
	public List<RecipeVO> findRequestData(String title)
	{
		return mapper.findRequestData(title);
	}
}
