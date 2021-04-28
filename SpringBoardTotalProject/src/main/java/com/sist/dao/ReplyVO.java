package com.sist.dao;
/*
 *  NO         NOT NULL NUMBER       
	BNO                 NUMBER       
	ID         NOT NULL VARCHAR2(20) 
	NAME       NOT NULL VARCHAR2(34) 
	MSG        NOT NULL CLOB         
	REDATE              DATE         
	GROUP_ID            NUMBER       
	GROUP_STEP          NUMBER       
	GROUP_TAB           NUMBER       
	ROOT                NUMBER       
	DEPTH               NUMBER  
 */
import java.util.*;
public class ReplyVO {
    private int no,bno,group_id,group_step,group_tab;
    private String id,name,msg;
    private Date redate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getGroup_step() {
		return group_step;
	}
	public void setGroup_step(int group_step) {
		this.group_step = group_step;
	}
	public int getGroup_tab() {
		return group_tab;
	}
	public void setGroup_tab(int group_tab) {
		this.group_tab = group_tab;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getRedate() {
		return redate;
	}
	public void setRedate(Date redate) {
		this.redate = redate;
	}
    
}
