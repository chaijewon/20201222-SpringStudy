package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAO {
   @Autowired
   private MovieMapper mapper;
   
   public void naverMovieInsert(MovieVO vo)
   {
	   mapper.naverMovieInsert(vo);
   }
}
