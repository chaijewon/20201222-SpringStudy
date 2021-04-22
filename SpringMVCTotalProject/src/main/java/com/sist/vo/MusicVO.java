package com.sist.vo;
/*
 *   NO           NUMBER(3)     
	 CNO          NUMBER(1)     
	 TITLE        VARCHAR2(300) 
	 SINGER       VARCHAR2(200) 
	 ALBUM        VARCHAR2(200) 
	 POSTER       VARCHAR2(260) 
	 STATE        CHAR(6)       
	 IDCREMENT    NUMBER(3) 
 */
public class MusicVO {
    private int no;
    private int cno;
    private String title;
    private String singer;
    private String album;
    private String state;
    private int idcrement;
    private String poster;
    
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
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
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getIdcrement() {
		return idcrement;
	}
	public void setIdcrement(int idcrement) {
		this.idcrement = idcrement;
	}
   
}
