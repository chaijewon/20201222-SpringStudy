package com.sist.main2;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*                      JDBC          MyBatis => 필요한 데이터는 XML,Annotation
 *   1) Connection   직접 생성                    자동 생성 
 *   2) Statement    직접 전송                    자동 전송 
 *   3) ResultSet    직접 처리                    자동 생성 
 *   4) close        직접 처리                    자동 처리
 *                                   필요한 데이터 
 *                                    1) 오라클 정보  => DataSource
 *                                    2) SQL문장     => mapper.xml
 *                                    3) 결과값 받는 데이터형 설정 => resultType , parameterType
 *                                    
 *     public List selectList()
 *     {
 *          getConnection()
 *          ================================
 *          
 *          ================================
 *          ps=conn.preparedStatement(sql);
 *          ================================
 *          
 *          ================================
 *          ResultSet rs=ps.executeQuery();
 *          while(rs,next())
 *          {
 *             
 *          }
 *          disConnection()
 *     }
 */
import java.util.*;

import javax.annotation.Resource;
/*
 *   <bean id="dao" class="com.sist.main.EmpDAO"
      p:sqlSessionFactory-ref="ssf"
    />
 */
@Repository("dao")
public class EmpDAO extends SqlSessionDaoSupport{
	
    @Resource(name="ssf")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
    
	public List<EmpVO> empAllData()
    {
    	return getSqlSession().selectList("empAllData");
    }
    public EmpVO empDetailData(int empno)
    {
    	
    	return getSqlSession().selectOne("empDetailData",empno);
    }
}














