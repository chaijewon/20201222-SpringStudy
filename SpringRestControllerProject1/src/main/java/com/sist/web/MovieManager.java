package com.sist.web;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/*
 *                 <td class="title">
						<div class="tit5">
							<a href="/movie/bi/mi/basic.nhn?code=10114" title="아마데우스">아마데우스</a>
						</div>
					</td>
 */
@Component
public class MovieManager {
   @Autowired
   private MovieDAO dao;
   public static void main(String[] args) {
	   ApplicationContext app=
			   new ClassPathXmlApplicationContext("app.xml");
	   MovieManager m=(MovieManager)app.getBean("movieManager");
	   m.movieAllData();
   }
   /*
    *    <div class="wide_info_area" >
	<!-- 포스터 -->
	<div class="poster">	
				<a href="#" onclick="javascript:common.iwopen('31795');clickcr(this,'ifo.img','','',event);return false;"><img src="https://movie-phinf.pstatic.net/20210311_91/16154244436748I97J_JPEG/movie_image.jpg?type=m77_110_2" alt="반지의 제왕: 두 개의 탑" onerror="this.src='https://ssl.pstatic.net/static/movie/2012/06/dft_img77x110_1.png'"/><span>포스터 크게보기</span></a>
	</div>
	<!-- //포스터 -->
	<div class="mv_info">
		<h3 class="h_movie">
			<a href="./basic.nhn?code=31795">반지의 제왕: 두 개의 탑</a><!-- N=a:ifo.title -->
		</h3>
    */
   public void movieAllData()
   {
	   try
	   {
		 int k=1;
		 for(int i=1;i<=40;i++)
		 {
		   try
		   {
		     Document doc=Jsoup.connect("https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20210502&page="+i).get();
		     Elements link=doc.select("td.title div.tit5 a");
		     for(int j=0;j<link.size();j++)
		     {
		    	 //System.out.println(k+"."+link.get(j).attr("href"));
		    	 // genre , director , actor , story , key
		    	 String mLink="https://movie.naver.com"+link.get(j).attr("href");
		    	 Document doc2=Jsoup.connect(mLink).get();
		    	 Element poster=doc2.selectFirst("div.poster a img");
		    	 Element title=doc2.selectFirst("h3.h_movie a");
		    	 /*
		    	  * <div class="story_area">
								<div class="title_area">
									<h4 class="h_story"><strong class="blind">줄거리</strong></h4>
								</div>
								
									<h5 class="h_tx_story">
		    	  */
		    	 Element genre=doc2.selectFirst("p.info_spec span");
		    	 Element director=doc2.selectFirst("div.info_spec2 dl.step1 dd");
		    	 Element actor=doc2.selectFirst("div.info_spec2 dl.step2 dd");
		    	 Element story=doc2.selectFirst("div.story_area");
		    	 
		    	 System.out.println("순위:"+k);
		    	 System.out.println("포스터:"+poster.attr("src"));
		    	 System.out.println("영화명:"+title.text());
		    	 System.out.println("장르:"+genre.text());
		    	 System.out.println("감독:"+director.text());
		    	 System.out.println("출연:"+actor.text());
		    	 System.out.println("줄거리:"+story.text());
		    	 System.out.println("====================================================================");
		    	 
		    	 MovieVO vo=new MovieVO();
		    	 vo.setTitle(title.text());
		    	 vo.setPoster(poster.attr("src"));
		    	 vo.setGenre(genre.text());
		    	 vo.setDirector(director.text());
		    	 vo.setActor(actor.text());
		    	 vo.setStory(story.text());
		    	 vo.setKey("");
		    	 
		    	 dao.naverMovieInsert(vo);
		    	 
		    	 k++;
		     }
		   }catch(Exception ex){}
		 }
	   }catch(Exception ex){}
   }
}









