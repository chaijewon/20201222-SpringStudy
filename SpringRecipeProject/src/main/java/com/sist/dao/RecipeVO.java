package com.sist.dao;
/*
 *   NO     NOT NULL NUMBER         
	POSTER NOT NULL VARCHAR2(260)  
	TITLE  NOT NULL VARCHAR2(1000) 
	CHEF   NOT NULL VARCHAR2(200)  
	HIT             VARCHAR2(100)  
	LINK            VARCHAR2(100) 
 */
public class RecipeVO {
    private int no;
    private String poster;
    private String title;
    private String chef;
    private String hit;
    private String link;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChef() {
		return chef;
	}
	public void setChef(String chef) {
		this.chef = chef;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
   
}
