package com.sist.main;

import org.mybatis.spring.support.SqlSessionDaoSupport;
/*
 *   => SqlSessionDaoSupport 
 *      데이터베이스 정보 (DataSource)
 *      SqlSessionFactory : getConnection,disConnection ==> 스프링에서 셋팅
 *      =================
 *      SqlSession => sql문장 전송 , 결과값을 받는 역할 
 */
import java.util.*;
public class MusicDAO extends SqlSessionDaoSupport{
	/*
	 *    <select id="musicListData" resultType="MusicVO" parameterType="hashmap">
	 *                                           =======                 ========
	 *                                            리턴형                                      매개변수
	 *                                         List<MusicVO> => selectList
	 *                                         MusicVO       => selectOne
	 *     <select id="musicListData" resultType="MusicVO" parameterType="hashmap">
		     SELECT no,title,singer,album,num 
		     FROM (SELECT no,title,singer,album,rownum as num 
		     FROM (SELECT no,title,singer,album 
		     FROM genie_music ORDER BY no ASC))
		     WHERE num BETWEEN #{start} AND #{end}
		   </select>
	 */
   public List<MusicVO> musicListData(Map map)
   {
	   return getSqlSession().selectList("musicListData",map);
   }
   /*
    * <select id="musicTotalPage" resultType="int">
    */
   public int musicTotalPage()
   {
	   return getSqlSession().selectOne("musicTotalPage");
   }
   /*
    *   <select id="musicCount" resultType="int">
		     SELECT COUNT(*) FROM genie_music
		   </select>
    */
   // 총갯수 읽기
   public int musicCount()
   {
	   return getSqlSession().selectOne("musicCount");
   }
   // 상세보기 
   /*
    * <select id="musicDetailData" resultType="MusicVO" parameterType="int">
       SELECT * FROM genie_music
       WHERE no=#{no}
      </select>
    */
   public MusicVO musicDetailData(int no)
   {
	   return getSqlSession().selectOne("musicDetailData",no);
   }
   /*
    *  <select id="musicFindData" resultType="MusicVO" parameterType="hashmap">
	     SELECT no,title,singer,album
	     FROM genie_music
	     WHERE ${column} LIKE '%'||#{finddata}||'%'
	   </select>
    */
   public List<MusicVO> musicFindData(Map map)
   {
	   return getSqlSession().selectList("musicFindData",map);
   }
}










