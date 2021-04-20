package com.sist.dao;
/*
 *   NO        NOT NULL NUMBER         
	NAME      NOT NULL VARCHAR2(34)   
	SUBJECT   NOT NULL VARCHAR2(1000) 
	CONTENT   NOT NULL CLOB           
	PWD       NOT NULL VARCHAR2(10)   
	REGDATE            DATE           
	HIT                NUMBER         
	FILENAME           VARCHAR2(1000) 
	FILESIZE           VARCHAR2(500)  
	FILECOUNT          NUMBER    
 */
import java.util.*;

import org.springframework.web.multipart.MultipartFile;
public class DataBoardVO {
    private int no;
    private String name;
    private String subject;
    private String content;
    private String pwd;
    private Date regdate;
    private int hit;
    private String filename;
    private String filesize;
    private int filecount;
    private String dbday; // 날짜를 변환해서 받는다 
    private List<MultipartFile> files; // 파일업로드시 저장 => 여러개가 넘어온다 
    /*
     *    <input type=file name="files[0]">
     *    <input type=file name="files[1]">
     *    <input type=file name="files[2]">
     */
    
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilesize() {
		return filesize;
	}
	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}
	public int getFilecount() {
		return filecount;
	}
	public void setFilecount(int filecount) {
		this.filecount = filecount;
	}
  
}
