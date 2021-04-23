package com.sist.vo;
/*
 *   CHEF_NAME NOT NULL VARCHAR2(300) 
	POSTER    NOT NULL VARCHAR2(260) 
	MC1                VARCHAR2(20)  
	MC2                VARCHAR2(20)  
	MC3                VARCHAR2(20)  
	MC7                VARCHAR2(20)
 */
public class ChefVO {
    private String chef_name;
    private String poster;
    private String mc1,mc2,mc3,mc7;
	public String getChef_name() {
		return chef_name;
	}
	public void setChef_name(String chef_name) {
		this.chef_name = chef_name;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getMc1() {
		return mc1;
	}
	public void setMc1(String mc1) {
		this.mc1 = mc1;
	}
	public String getMc2() {
		return mc2;
	}
	public void setMc2(String mc2) {
		this.mc2 = mc2;
	}
	public String getMc3() {
		return mc3;
	}
	public void setMc3(String mc3) {
		this.mc3 = mc3;
	}
	public String getMc7() {
		return mc7;
	}
	public void setMc7(String mc7) {
		this.mc7 = mc7;
	}
	   
}
