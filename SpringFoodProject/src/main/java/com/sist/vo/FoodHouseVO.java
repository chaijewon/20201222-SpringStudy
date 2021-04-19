package com.sist.vo;
/*
 *   NO      NOT NULL NUMBER         
CNO              NUMBER         
POSTER  NOT NULL VARCHAR2(4000) 
TITLE   NOT NULL VARCHAR2(200)  
SCORE   NOT NULL NUMBER(2,1)    
ADDRESS NOT NULL VARCHAR2(300)  
TEL     NOT NULL VARCHAR2(30)   
TYPE    NOT NULL VARCHAR2(100)  
PRICE   NOT NULL VARCHAR2(50)   
PARKING          VARCHAR2(500)  
TIME             VARCHAR2(500)  
MENU             VARCHAR2(2000) 
GOOD             NUMBER         
SOSO             NUMBER         
BAD              NUMBER         
RDAYS            VARCHAR2(100)  
 */
public class FoodHouseVO {
    private int no;
    private int cno;
    private String poster;
    private String title;
    private Double score;
    private String address;
    private String tel;
    private String type;
    private String price;
    private String parking;
    private String time;
    private String menu;
    private int good,soso,bad;
    private String rdays;
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
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getSoso() {
		return soso;
	}
	public void setSoso(int soso) {
		this.soso = soso;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int bad) {
		this.bad = bad;
	}
	public String getRdays() {
		return rdays;
	}
	public void setRdays(String rdays) {
		this.rdays = rdays;
	}
   
}
