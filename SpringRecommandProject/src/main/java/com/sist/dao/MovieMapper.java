package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface MovieMapper {
   @Select("SELECT mno,title,poster "
		 +"FROM naver_movie "
		 +"WHERE title=#{title}")
   public MovieVO movieData(String title);
   
   @Select("SELECT title FROM naver_movie WHERE LENGTH(title)>=2 ORDER BY mno ASC")
   public List<String> movieGetTitleData();
}
