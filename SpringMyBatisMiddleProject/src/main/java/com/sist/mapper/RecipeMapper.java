package com.sist.mapper;

import org.apache.ibatis.annotations.Select;
/*
 *   private int no;
    private String poster;
    private String title;
    private String chef;
    private String hit;
 */
import java.util.*;
import com.sist.vo.*;
public interface RecipeMapper {
   // 목록
   // <select id="" resultType="" parameterType="">inline-view</select>
   @Select("SELECT no,poster,title,chef,hit,num "
		  +"FROM (SELECT no,poster,title,chef,hit,rownum as num "
		  +"FROM (SELECT no,poster,title,chef,hit "
		  +"FROM recipe)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<RecipeVO> recipeListData(Map map);
   //     ============== ============== ========
   //      resultType          id       parameterType
   // 총페이지 
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
   public int recipeTotalPage();
   // 레시피 총갯수
   @Select("SELECT COUNT(*) FROM recipe")
   public int recipeCount();
   // 상세보기 
   @Select("SELECT * FROM recipe_make "
		  +"WHERE no=#{no}")
   public RecipeDetailVO recipeDetailData(int no);
   // 검색
   // 전체
   @Select("SELECT no,poster,title,chef,hit,rownum "
		  +"FROM recipe "
		  +"WHERE rownum<=20")
   public List<RecipeVO> findAllData();
   // 종류별  LIKE => 확장 (REGEXP_LIKE) |
   @Select("SELECT no,poster,title,chef,hit,rownum "
			  +"FROM recipe "
			  +"WHERE rownum<=20 "
			  +"AND REGEXP_LIKE(title,#{title})")
   public List<RecipeVO> findRequestData(String title);
   
}









