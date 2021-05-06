package com.sist.dao;
/*
 *      MNO      NOT NULL NUMBER        
		TITLE    NOT NULL VARCHAR2(500) 
		POSTER   NOT NULL VARCHAR2(260) 
		GENRE    NOT NULL VARCHAR2(300) 
		DIRECTOR          VARCHAR2(200) 
		ACTOR             VARCHAR2(500) 
		STORY    NOT NULL CLOB          
		KEY               VARCHAR2(50)
 */
public class MovieVO {
    private int mno;
    private String title;
    private String poster;
    private String genre;
    private String director;
    private String actor;
    private String story;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
   
}
