package com.sist.web;

import java.util.Spliterator;

public class FindVO {
   private String type;
   private String ss;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
  
	public String[] getTypeArr()
	{
		return type==null?new String[]{}:type.split("");
	}
}
