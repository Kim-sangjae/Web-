package com.korea.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import context.Context_1_dataSource;
import lombok.extern.log4j.Log4j;

// JUnit 프레임워크이 테스트 실행방법을 확장할때 사용하는 어노테이션
// 확장한다 -> 톰캣 말고도 스프링에 접근할 수 있게해준다
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Context_1_dataSource.class}) // 설정 파일을 읽어야 하는데 , 설정파일을 로드해주는 어노테이션
@Log4j
public class DataSourceTest {

	@Autowired
	private DataSource dataSource;
	
	
	
	
	@Test
	public void testConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		log.info("///log/// = " + connection);
	}
	
	
	
	
	
}
