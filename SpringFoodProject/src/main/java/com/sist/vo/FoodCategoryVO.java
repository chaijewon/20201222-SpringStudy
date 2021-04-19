package com.sist.vo;
/*
 *  NO      NOT NULL NUMBER        
TITLE   NOT NULL VARCHAR2(100) 
SUBJECT NOT NULL VARCHAR2(100) 
POSTER  NOT NULL VARCHAR2(260) 
LINK             VARCHAR2(100) 
 */
public class FoodCategoryVO {
    private int no;
    private String title;
    private String subject;
    private String poster;
    private String link;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	   
}
