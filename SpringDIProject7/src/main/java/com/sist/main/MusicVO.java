package com.sist.main;

public class MusicVO {
	   private int no,cno; // MyBatis => 컬럼명과 멤버가 일치 
	   // 일치하지 않는 경우에는 반드시 => as를 사용한다
	   /*
	    *   1. 변수명과 컬럼이 틀릴 경우 
	    *   2. SQL 문장 => id를 부여 => 사용시 id가 틀린경우 
	    *   3. SQL문장에서 오류 
	    *   스프링과 마이바티스의 장점 => 이미 검증된 라이브러리 
	    */
	    private String title,singer,album,poster,state,idcrement;
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
		public String getPoster() {
			return poster;
		}
		public void setPoster(String poster) {
			this.poster = poster;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getIdcrement() {
			return idcrement;
		}
		public void setIdcrement(String idcrement) {
			this.idcrement = idcrement;
		}
	    
}
