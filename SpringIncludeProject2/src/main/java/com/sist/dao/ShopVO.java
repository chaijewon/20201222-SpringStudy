package com.sist.dao;
/*
 *   NO      NOT NULL NUMBER        
	CNO              NUMBER        
	TITLE   NOT NULL VARCHAR2(300) 
	POSTER  NOT NULL VARCHAR2(500) 
	PRICE   NOT NULL VARCHAR2(30)  
	ACCOUNT          NUMBER 
 */
public class ShopVO {
    private int no;
    private int cno;
    private String title;
    private String poster;
    private String price;
    private int account;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
   
}
