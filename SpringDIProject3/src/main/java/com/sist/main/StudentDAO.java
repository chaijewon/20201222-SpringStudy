package com.sist.main;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
/*
 *   public class JdbcDaoSupport
 *   {
 *       private DataSource dataSource;
 *       private Connection conn;
 *       private PreparedStatement ps;
 *       public void setDataSource(DataSource dataSource)
 *       {
 *           this.dataSource=dataSource;
 *       }
 *       public void getConnection()
 *       {
 *            conn=DriverManager.getConnection(dataSource.getUrl(),dataSource.getUsername()..)
 *       }
 *       public void disConnection()
 *       {
 *       }
 *   }
 */
public class StudentDAO extends JdbcDaoSupport{
	// JdbcDaoSupport ==> getConnection(),disConnection() => DataSource(오라클 정보)
	/*
	 *    ResultSet rs=ps.executeQuery();
	 *    while(rs.next())
	 *    {
	 *       StudentVO vo=mapRow(rs);
	 *       list.add(vo);
	 *    }
	 *    
	 *    }
	 *    public Object mapRow(ResultSet rs, int rowNum)
	 *    {
	 *        StudentVO vo=new StudentVO();
	 *        vo.setName(rs.getString(1));
	 *        vo.setKor(rs.getInt(2));
	 *        vo.setEng(rs.getInt(3));
	 *        vo.setMath(rs.getInt(4));
	 *        return vo;
	 *    }
	 *    
	 *    
	 */
    public List studentAllData()
    {
    	return getJdbcTemplate().query("SELECT name,kor,eng,math,(kor+eng+math),(kor+eng+math)/3 FROM spring_student", 
    		       new RowMapper(){

					  @Override
					  public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						StudentVO vo=new StudentVO();
						vo.setName(rs.getString(1));
						vo.setKor(rs.getInt(2));
						vo.setEng(rs.getInt(3));
						vo.setMath(rs.getInt(4));
						vo.setTotal(rs.getInt(5));
						vo.setAvg(rs.getDouble(6));
						return vo;
					  }
    		          
    	           }
    		   );
    }
    /*
     *   객체 지향 프로그램 
     *   제네릭타입 
     */
    public StudentVO studentDetailData(String name)
    {
    	
    	String sql="SELECT name,kor,eng,math,(kor+eng+math),(kor+eng+math)/3 FROM spring_student WHERE name=?";
    	return getJdbcTemplate().queryForObject(sql,new Object[]{name}, new RowMapper<StudentVO>(){

			@Override
			public StudentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				StudentVO vo=new StudentVO();
				vo.setName(rs.getString(1));
				vo.setKor(rs.getInt(2));
				vo.setEng(rs.getInt(3));
				vo.setMath(rs.getInt(4));
				vo.setTotal(rs.getInt(5));
				vo.setAvg(rs.getDouble(6));
				return vo;
			}
    	});
    }
    public void studentInsert(StudentVO vo)
    {
    	// update(String sql,Object...args) => 가변형 매개변수
    	// update(String sql,Object[] args)
    	getJdbcTemplate().update("INSERT INTO spring_student VALUES(?,?,?,?)", vo.getName(),vo.getKor(),vo.getEng(),vo.getMath());
    }
    public void studentDelete(String name)
    {
    	getJdbcTemplate().update("DELETE FROM spring_student WHERE name=?", name);
    }
    public void studentUpdate(StudentVO vo)
    {
    	getJdbcTemplate().update("UPDATE spring_student SET kor=?,eng=?,math=? WHERE name=?",
    			         vo.getKor(),vo.getEng(),vo.getMath(),vo.getName());
    }
}














