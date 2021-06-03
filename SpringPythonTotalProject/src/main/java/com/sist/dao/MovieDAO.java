package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MovieDAO {
   @Autowired
   private MovieMapper mapper;
   public List<MovieVO> movieListData(Map map)
   {
	   return mapper.movieListData(map);
   }
   public int movieTotalPage(int cno){
	   return mapper.movieTotalPage(cno);
   }
   //@Select("SELECT DISTINCT title FROM naver_movie")
   public List<String> movieGetTitleData()
   {
	   return mapper.movieGetTitleData();
   }
   
   //@Select("SELECT title,poster FROM naver_movie WHERE title=#{title}")
   public MovieVO movieInfoData(String title)
   {
	   return mapper.movieInfoData(title);
   }
}
