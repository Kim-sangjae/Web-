package context;

import java.sql.Connection;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.GogekDAO;
import dao.SawonDAO;


@Configuration
public class Context_3_dao {
	

	@Bean
	public SawonDAO sawon_dao(SqlSession sqlSession) {
		SawonDAO sawon_dao = new SawonDAO();
		sawon_dao.setSqlSession(sqlSession);
		return sawon_dao;
	}

	
	
	@Bean
	public GogekDAO gogek_dao(SqlSession sqlSession) {
		GogekDAO gogek_dao = new GogekDAO();
		gogek_dao.setSqlSession(sqlSession);
		
		return gogek_dao;
	}
	


}
