package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
public class MainClass {
   public static void main(String[] args) {
	  String[] xml={"datasource.xml","music_app.xml","movie_app.xml"};
	  // *_app.xml
	  ApplicationContext app=
			  new ClassPathXmlApplicationContext(xml);
	  MusicDAO musicdao=(MusicDAO)app.getBean("musicDao");
	  MovieDAO moviedao=(MovieDAO)app.getBean("movieDao");
	  // 스프링에서 생성된 객체를 얻어오면 => 객체에서 필요한 메소드 호출 
	  List<MovieVO> mList=moviedao.movieListData();
	  List<MusicVO> nList=musicdao.musicAllData();
	  System.out.println("====================영화목록=================");
	  for(MovieVO vo:mList)
	  {
		  System.out.println("제목:"+vo.getTitle());
		  System.out.println("장르:"+vo.getGenre());
		  System.out.println("========================================");
	  }
	  System.out.println("=========================뮤직목록================");
	  for(MusicVO vo:nList)
	  {
		  System.out.println("노래명:"+vo.getTitle());
		  System.out.println("가수명:"+vo.getSinger());
		  System.out.println("===========================================");
	  }
   }
}
