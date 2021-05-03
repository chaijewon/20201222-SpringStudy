package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface MovieMapper {
   @Select("SELECT mno,title,poster,num "
		  +"FROM (SELECT mno,title,poster,rownum as num "
		  +"FROM (SELECT /*+ INDEX_ASC(naver_movie nm_mno_pk) */ mno,title,poster "
		  +"FROM naver_movie)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<MovieVO> movieListData(Map map);
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM naver_movie")
   public int movieTotalPage();
   
   @Select("SELECT mno,title,poster,genre,director,actor,story "
		  +"FROM naver_movie "
		  +"WHERE mno=#{mno}")
   public MovieVO movieDetailData(int mno);
   
   // 추천 
}
