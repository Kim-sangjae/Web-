package context;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dao.DeptDAO;



@Configuration
public class Context_3_dao {
	
	
	@Bean
	public DeptDAO dept_dao(SqlSession sqlSession) {
		return new DeptDAO(sqlSession);
	}

	
	

}
