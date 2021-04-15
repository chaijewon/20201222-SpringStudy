package com.sist.main;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class MusicDAO extends SqlSessionDaoSupport{
  /*
   *  <select id="musicAllData" resultType="MusicVO">
	    SELECT * FROM genie_music
	  </select>
   */
	public List<MusicVO> musicAllData()
	{
		return getSqlSession().selectList("musicAllData");
	}
}
