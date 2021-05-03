package com.sist.web;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
/*
 *   private int mno;
    private String title;
    private String poster;
    private String genre;
    private String director;
    private String actor;
    private String story;
    private String key;
 */
public interface MovieMapper {
   // Sequence 
   @SelectKey(keyProperty="mno",resultType=int.class,before=true,
		   statement="SELECT NVL(MAX(mno)+1,1) as no FROM naver_movie")
   @Insert(
		    "INSERT INTO naver_movie VALUES("
		   +"#{mno},#{title},#{poster},#{genre},#{director},#{actor},#{story},#{key})"
          )
   public void naverMovieInsert(MovieVO vo);
}










