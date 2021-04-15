package com.sist.main;
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(MusicConfig.class);
            // 스프링에 저장된 DAO를 가지고 온다 
     		MusicDAO dao=(MusicDAO)app.getBean("dao");
     		// 사용
     		int totalpage=dao.musicTotalPage();
     		Scanner scan=new Scanner(System.in);
     		System.out.print("페이지 입력:(1~"+totalpage+")=>");
     		int curpage=scan.nextInt();
     		Map map=new HashMap();
     		int rowSize=10;
     		int start=(rowSize*curpage)-(rowSize-1);
     		int end=(rowSize*curpage);
     		// WHERE num BETWEEN #{start} AND #{end}
     		map.put("start", start);
     		map.put("end", end);
     		
     		// 결과값 받기
     		List<MusicVO> list=dao.musicListData(map);
     		// 출력 
     		for(MusicVO vo:list)
     		{
     			System.out.println("순위:"+vo.getNo());
     			System.out.println("노래명:"+vo.getTitle());
     			System.out.println("가수명:"+vo.getSinger());
     			System.out.println("앨범:"+vo.getAlbum());
     			System.out.println("=============================================");
     		}
     		int count=dao.musicCount();
     		System.out.print("상세보기:(1~"+count+")");
     		int no=scan.nextInt();
     		MusicVO vo=dao.musicDetailData(no);
     		System.out.println("=======상세보기 결과==========");
     		System.out.println("순위:"+vo.getNo());
     		System.out.println("제목:"+vo.getTitle());
     		System.out.println("가수명:"+vo.getSinger());
     		System.out.println("앨범:"+vo.getAlbum());
     		System.out.println("상태:"+vo.getState());
     		System.out.println("등폭:"+vo.getIdcrement());
     		System.out.println("==========================");
     		System.out.print("제목(title),가수(singer):");
     		String column=scan.next();
     		System.out.print("검색어 입력:");
     		String finddata=scan.next();
     		/*
     		 *  <select id="musicFindData" resultType="MusicVO" parameterType="hashmap">
     			     SELECT no,title,singer,album
     			     FROM genie_music
     			     WHERE ${column} LIKE '%'||#{finddata}||'%'
     			   </select>
     		 */
     		map.put("column", column);
     		map.put("finddata", finddata);
     		List<MusicVO> fList=dao.musicFindData(map);
     		for(MusicVO fvo:fList)
     		{
     			System.out.println("순위:"+fvo.getNo());
     			System.out.println("노래명:"+fvo.getTitle());
     			System.out.println("가수명:"+fvo.getSinger());
     			System.out.println("앨범:"+fvo.getAlbum());
     			System.out.println("=============================================");
     		}
	}

}
