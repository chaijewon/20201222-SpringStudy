package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface MovieMapper {
   @Select("SELECT mno,poster,title,num "
		  +"FROM (SELECT mno,poster,title,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(daum_movie dm_mno_pk) */ mno,poster,title "
		  +"FROM daum_movie WHERE cno=#{cno})) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<MovieVO> movieListData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM daum_movie WHERE cno=#{cno}")
   public int movieTotalPage(int cno);
   
   @Select("SELECT DISTINCT title FROM naver_movie")
   public List<String> movieGetTitleData();
   
   @Select("SELECT title,poster FROM naver_movie WHERE title=#{title}")
   public MovieVO movieInfoData(String title);
   
   
   
}
