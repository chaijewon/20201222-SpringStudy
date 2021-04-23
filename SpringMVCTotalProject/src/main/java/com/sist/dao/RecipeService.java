package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// BI
import java.util.*;
import com.sist.vo.*;
@Service  
public class RecipeService {
   @Autowired
   private ChefDAO cDao;
   
   @Autowired
   private RecipeDAO rDao;
   
    public List<ChefVO> chefListData(Map map)
	{
		return cDao.chefListData(map);
	}
	
	public int chefTotalPage()
	{
		return cDao.chefTotalPage();
	}
	
	public List<RecipeVO> chefMakeRecipeData(Map map)
	{
		return cDao.chefMakeRecipeData(map);
	}
	
	public int chefMakeRecipeTotalPage(String chef)
	{
		return cDao.chefMakeRecipeTotalPage(chef);
	}
	
	public List<RecipeVO>  recipeListData(Map map)
	{
		return rDao.recipeListData(map);
	}
	
	public int recipeTotalPage()
	{
		return rDao.recipeTotalPage();
	}
	
	public RecipeDetailVO recipeDetailData(int rno)
	{
		return rDao.recipeDetailData(rno);
	}
}
