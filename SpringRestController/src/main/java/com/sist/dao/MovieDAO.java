package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class MovieDAO {
   @Autowired
   private MovieMapper mapper;
   
   public List<MovieVO> movieListData(Map map)
   {
	   return mapper.movieListData(map);
   }
   
   public int movieTotalPage()
   {
	   return mapper.movieTotalPage();
   }
   
   public MovieVO movieDetailData(int mno)
   {
	   return mapper.movieDetailData(mno);
   }
}
