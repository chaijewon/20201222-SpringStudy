package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeDAO {
   @Autowired
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
   
   public RecipeDetailVO recipeDetailData(int rno)
   {
	   return mapper.recipeDetailData(rno);
   }
}
