package context;

import java.sql.Connection;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.VisitDAO;




@Configuration
public class Context_3_dao {

	

	@Bean
	public VisitDAO visit_dao(SqlSession sqlSession) {
		
		return new VisitDAO(sqlSession);
	}
	
	
}
