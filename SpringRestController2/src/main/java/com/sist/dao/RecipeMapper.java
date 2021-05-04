package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
/*
 *  private int no;
    private String poster;
    private String title;
    private String chef;
 */
public interface RecipeMapper {
   @Select("SELECT no,poster,title,chef,num "
		  +"FROM (SELECT no,poster,title,chef,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(recipe recipe_no_pk) */ no,poster,title,chef "
		  +"FROM recipe)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<RecipeVO> recipeListData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
   public int recipeTotalPage();
   
   @Select("SELECT COUNT(*) FROM recipe")
   public int recipeCount();
   
   @Select("SELECT * FROM recipe_make "
		  +"WHERE rno=#{rno}")
   public RecipeDetailVO recipeDetailData(int rno);
}
