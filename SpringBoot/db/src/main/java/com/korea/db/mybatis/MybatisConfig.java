package com.korea.db.mybatis;

import java.io.IOException;

import javax.sql.DataSource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;

@Configuration // 이 클래스가 설정파일임을 알려주는 어노테이션
@RequiredArgsConstructor
public class MybatisConfig {
	
	private final ApplicationContext applicationContext;
	
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	@Bean // HikariCP(히카리 커넥션풀) -> jdbc api에 같이 포함되어있다
	public HikariConfig hikariConfig() {
		
		return new HikariConfig();
	}
	
	//userName,password에 대한 설정을 HikariConfig 객체에 넣어줘야 한다
	//application.yml 파일에 작성
	
	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws IOException{
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource()); // classpath가 resources까지의 경로를 알고 있다.
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:/mapper/*.xml"));
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/config/config.xml"));
		
		try {
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
			sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true); // 데이터베이스에 _ 를 카멜케이스로 변경해주는것
			return sqlSessionFactory;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	

}
