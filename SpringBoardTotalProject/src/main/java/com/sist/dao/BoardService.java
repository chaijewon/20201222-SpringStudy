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
}























