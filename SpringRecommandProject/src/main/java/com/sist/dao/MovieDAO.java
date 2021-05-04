package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAO {
   @Autowired
   private MovieMapper mapper;
   
   public MovieVO movieData(String title)
   {
	   return mapper.movieData(title);
   }
   
   public List<String> movieGetTitleData()
   {
	   return mapper.movieGetTitleData();
   }
}
