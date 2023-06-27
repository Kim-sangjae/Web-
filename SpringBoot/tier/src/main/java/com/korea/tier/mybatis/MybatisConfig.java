package com.korea.tier.mybatis;

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

@Configuration //스프링한테 해당 클래스가 설정파일임을 알려주는 어노테이션
@RequiredArgsConstructor
public class MybatisConfig {
	
	private final ApplicationContext applicationContext;
	
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	@Bean //HikariCP
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	//userName, password에 대한 설정을 HikariConfig객체에 넣어줘야 한다.
	//application.yml 파일에 작성을 할것이다.
	
	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());//classpath가 resources까지의 경로를 알고있다.
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:/mapper/*.xml"));
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/config/config.xml"));
		
		try {
			SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
			sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
			return sqlSessionFactory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	

}










