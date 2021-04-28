package com.sist.dao;

public class FindVO {
    private String fs;
    private String ss;
	public String getFs() {
		return fs;
	}
	public void setFs(String fs) {
		this.fs = fs;
	}
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public String[] getFsArr()
	{
		return fs==null?new String[]{}:fs.split("");
	}
   
}
