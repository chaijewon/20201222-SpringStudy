package com.sist.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
/*
 *    double d=10
 *    int i='A'
 *    
 *    class A
 *    
 *    class B extends A
 *    class C extends A
 *    
 *    B b=new B()
 *    @Autowired
 *    @Resource(name="b")
 *    A a=new B()
 *    
 *    C c=new C();
 *    @Resource(name="c")
 *    A a=new C();
 *    
 */
import java.util.*;
@Service
public class BoardService {
   // SqlSessionDaoSupport sdf
   @Resource(name="boardDAO")
   private BoardDAO bDao;
   @Resource(name="replyDAO")
   private ReplyDAO rDao;
   
   public List<BoardVO> boardListData(Map map)
   {
	   return bDao.boardListData(map);
   }
   public int boardTotalPage()
   {
	   return bDao.boardTotalPage();
   }
   public void boardInsert(BoardVO vo)
   {
	   bDao.boardInsert(vo);
   }
   public BoardVO boardDetailData(int no)
   {
	   return bDao.boardDetailData(no);
   }
   public List<BoardVO> boardFindData(Map map)
   {
	   return bDao.boardFindData(map);
   }
   public int boardFindDataCount(Map map)
   {
	   return bDao.boardFindDataCount(map);
   }
   public BoardVO boardUpdateData(int no)
   {
	   return bDao.boardUpdateData(no);
   }
   public boolean boardUpdate(BoardVO vo)
   {
	   return bDao.boardUpdate(vo);
   }
   public boolean boardDelete(int no,String pwd)
   {
	   return bDao.boardDelete(no, pwd);
   }
   // 댓글 관련
   public List<ReplyVO> replyListData(int bno)
   {
	   return rDao.replyListData(bno);
   }
   
   public void replyInsert(ReplyVO vo)
   {
	   rDao.replyInsert(vo);
   }
   public void replyUpdate(ReplyVO vo)
   {
	   rDao.replyUpdate(vo);
   }
   public void replyToReplyInsert(int root,ReplyVO vo)
   {
	   rDao.replyToReplyInsert(root, vo);
   }
   public void replyDelete(int no)
   {
	   rDao.replyDelete(no);
   }
}























