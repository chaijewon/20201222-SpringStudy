package com.sist.dao;
import java.util.*;

import javax.annotation.Resource;

import com.sist.vo.*;
import com.sist.mapper.*;
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
}
