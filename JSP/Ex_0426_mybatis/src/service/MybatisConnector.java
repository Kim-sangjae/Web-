package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnector {
	//mybatis는 데이터베이스 프로그래밍을 좀 더 쉽고 간편하게 할 수 있도록 도와주는 프레임워크

	
	SqlSessionFactory factory = null;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static MybatisConnector single = null;

	public static MybatisConnector getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new MybatisConnector();
		//생성된 객체정보를 반환
		return single;
	}
	
	
	public MybatisConnector() {
		//sqlMapConfig.xml 파일을 읽어오는 작업
		//sqlMapConfig는 mybatis에 대한 정보를 담고 있는 설정 파일
		
		try {
			//reader로 char기반의 스트림으로 설정파일을 읽어온다
			//""로 묶어서 그냥 문자열 형태로 읽어온다
			Reader reader = Resources.getResourceAsReader("config/mybatis/sqlMapConfig.xml");
			
			//문자열을 실제로 읽어주는 코드
			//sqlMapConfig.xml 에서 지정해둔 접근 경로를 실제로 읽어온다.
			factory = new SqlSessionFactoryBuilder().build(reader);
			
			reader.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	//다른 클래스에서도 쓸수있게 메서드형태로 만들었다
	//sqlMapConfig.xml의 정보를 담고있는 factory객체를 반환
	public SqlSessionFactory getFactory() {
		return factory;
	}
	
	
	
	
	
}
