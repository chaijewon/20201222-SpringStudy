package com.sist.dao;

public class FindVO {
    private String fd;
    private String ss;
	public String getFd() {
		return fd;
	}
	public void setFd(String fd) {
		this.fd = fd;
	}
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	// 한글자 T , C  TC => {"T","C"}
	public String[] getFdArr()
	{
		return fd==null?new String[]{}:fd.split("");
	}
  
}
