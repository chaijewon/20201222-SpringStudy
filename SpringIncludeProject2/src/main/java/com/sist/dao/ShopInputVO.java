package com.sist.dao;
/*
 *   NO          NOT NULL NUMBER        
	ID                   VARCHAR2(20)  
	GOODS_NO             NUMBER        
	GOODS_COUNT          NUMBER        
	REGDATE              DATE          
	ADDRESS     NOT NULL VARCHAR2(500) 
	TEL         NOT NULL VARCHAR2(20)  
	EMAIL       NOT NULL VARCHAR2(100) 
	STATE                VARCHAR2(1)
 */
import java.util.*;
public class ShopInputVO {
    private int no;
    private String id;
    private int goods_no;
    private int goods_count;
    private Date regdate;
    private String address;
    private String tel;
    private String email;
    private String state;
    private int total_price;
    private int goods_price;
    
    public int getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}
	// 임시 변수
    private ShopVO svo=new ShopVO();
    
	public ShopVO getSvo() {
		return svo;
	}
	public void setSvo(ShopVO svo) {
		this.svo = svo;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}
	public int getGoods_count() {
		return goods_count;
	}
	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
   
}
