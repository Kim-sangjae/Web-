package com.example.first.quailfier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.first.qualifier.Computer;

import lombok.extern.java.Log;

@SpringBootTest
@Log
public class ComputerTest {
	
	@Autowired
	@Qualifier("laptop")
	Computer laptop; // 인터페이스 -> 자동으로 구현을 한 클래스의 객체가 들어온다
	
	@Autowired
	@Qualifier("desktop")
	Computer desktop;
	
	@Autowired
	Computer computer;
	
	@Test
	public void computerTest() {
		log.info(laptop.getScreenWidth());
		log.info(desktop.getScreenWidth());
		
		log.info(computer.getScreenWidth());
	}

}
