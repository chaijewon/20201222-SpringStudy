package com.sist.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
@Repository
public class MusicDAO extends SqlSessionDaoSupport{

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *   <select id="musicListData" resultType="MusicVO" parameterType="hashmap">
		    SELECT no,title,singer,album,poster,state,idcrement,num
		    FROM (SELECT no,title,singer,album,poster,state,idcrement,rownum as num 
		    FROM (SELECT no,title,singer,album,poster,state,idcrement 
		    FROM genie_music ORDER BY no ASC))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
	 */
	public List<MusicVO> musicListData(Map map)
	{
		return getSqlSession().selectList("musicListData", map);
	}
	/*
	 *   <select id="musicTotalPage" resultType="int">
		    SELECT CEIL(COUNT(*)/50.0) FROM genie_music
		  </select>
	 */
	public int musicTotalPage()
	{
		return getSqlSession().selectOne("musicTotalPage");//ID명은 대소문 구분
	}
   
}
