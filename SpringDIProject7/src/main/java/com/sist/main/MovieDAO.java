package com.sist.main;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class MovieDAO extends SqlSessionDaoSupport{
  /*
   *   <select id="movieListData" resultType="MovieVO">
		    SELECT mno,title,regdate,genre,nation,grade,time,story
		    FROM daum_movie WHERE cno=1
		  </select>
   */
	public List<MovieVO> movieListData()
	{
		return getSqlSession().selectList("movieListData");
	}
}
