package com.sist.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
@Repository
public class ReplyDAO extends SqlSessionDaoSupport{

	@Resource(name="ssf")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	/*
	 *  <select id="replyListData" resultType="ReplyVO" parameterType="int">
		    SELECT no,cno,id,name,msg,TO_CHAR(redate,'YYYY-MM-DD HH24:MI:SS') as dbday,group_tab
		    FROM spring_reply
		    WHERE bno=#{bno}
		    ORDER BY group_id DESC,group_step ASC
		  </select>
	 */
	public List<ReplyVO> replyListData(int bno)
	{
		return getSqlSession().selectList("replyListData", bno);
	}
	/*
	 *   <insert id="replyInsert" parameterType="ReplyVO">
		   <!-- mybatis 자동 증가 번호 -->
		   <selectKey keyProperty="no" resultType="int" order="BEFORE">
		     SELECT NVL(MAX(no)+1,1) as no FROM spring_reply
		   </selectKey>
		   INSERT INTO spring_reply(no,bno,id,name,msg,group_id) VALUES(
		     #{no},
		     #{bno},
		     #{id},
		     #{name},
		     #{msg},
		     (SELECT NVL(MAX(group_id)+1,1) FROM spring_reply)
		   )
		  </insert>
	 */
	public void replyInsert(ReplyVO vo)
	{
		getSqlSession().insert("replyInsert",vo);
	}
	/*
	 *  <update id="replyUpdate" parameterType="ReplyVO">
		    UPDATE spring_reply SET
		    msg=#{msg}
		    WHERE no=#{no}
		  </update>
	 */
	public void replyUpdate(ReplyVO vo)
	{
		getSqlSession().update("replyUpdate",vo);
	}
   
	/*
     *   <select id="replyParentInfoData" resultType="ReplyVO" parameterType="int">
		   SELECT group_id,group_step,group_tab 
		   FROM spring_reply
		   WHERE no=#{no}
		  </select>
		  <!--  댓글의 핵심  -->
		  <update id="replyGroupStepIncrement" parameterType="ReplyVO">
		   UPDATE spring_reply SET
		   group_step=group_step+1
		   WHERE group_id=#{group_id} AND group_step>#{group_step}
		  </update>
		  <insert id="replyToReplyInsert" parameterType="ReplyVO">
		    <selectKey keyProperty="no" resultType="int" order="BEFORE">
		      SELECT NVL(MAX(no)+1,1) as no FROM spring_reply
		    </selectKey>
		    INSERT INTO spring_reply VALUES(
		      #{no},
		      #{bno},
		      #{id},
		      #{name},
		      #{msg},
		      SYSDATE,
		      #{group_id},
		      #{group_step},
		      #{group_tab},
		      #{root},
		      0
		    )
		  </insert>
		  <update id="replyDepthIncrement" parameterType="int">
		    UPDATE spring_reply SET
		    depth=depth+1
		    WHERE no=#{no}
		  </update>
     */
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    // 일괄 처리 (동시에 처리 : 성공 , 한개 실패=> 전부 취소)
    public void replyToReplyInsert(int root,ReplyVO vo)
    {
	   	 // 1. 상위 정보 
	   	 ReplyVO pvo=getSqlSession().selectOne("replyParentInfoData",root);
	   	 // parent => group_id , group_step , group_tab
	   	 getSqlSession().update("replyGroupStepIncrement",pvo);
	   	 // 실제 추가 
	   	 vo.setGroup_id(pvo.getGroup_id());
	   	 vo.setGroup_step(pvo.getGroup_step()+1);
	   	 vo.setGroup_tab(pvo.getGroup_tab()+1);
	   	 vo.setRoot(root);
	   	 getSqlSession().insert("replyToReplyInsert",vo);
	   	 // depth증가
	   	 getSqlSession().update("replyDepthIncrement",root);
    }
    /*
     *    <select id="replyInfoData" resultType="ReplyVO" parameterType="int">
		    SELECT root,depth FROM spring_reply
		    WHERE no=#{no}
		  </select>
		  <update id="replyMsgUpdate" parameterType="int">
		    UPDATE spring_reply SET
		    msg='관리자가 삭제한 댓글입니다'
		    WHERE no=#{no}
		  </update>
		  <delete id="replyDelete" parameterType="int">
		    DELETE FROM spring_reply
		    WHERE no=#{no}
		  </delete>
		  <update id="depthDecrement" parameterType="int">
		    UPDATE spring_reply SET
		    depth=depth-1
		    WHERE no=#{no}
		  </update>
     */
    @Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public void replyDelete(int no)
    {
    	ReplyVO vo=getSqlSession().selectOne("replyInfoData", no);
    	if(vo.getDepth()==0) // 댓글이 없는 경우
    	{
    		getSqlSession().delete("replyDelete",no);
    	}
    	else // 댓글이 있는 경우 
    	{
    		getSqlSession().update("replyMsgUpdate",no);
    	}
    	getSqlSession().update("depthDecrement",vo.getRoot());
    }
}








