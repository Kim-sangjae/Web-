package com.example.first.dependency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
//@Slf4j // 롬복에 있는 로그를 찍어볼 수 있는 어노테이션
@Log
public class ComputerTest {
	
	@Autowired
	Coding coding;// 우리가 직접 만든 객체가아니라 스프링에게 맡겨놓은 객체를 알아야한다.
	
	
	@Test
	public void computerTest() {
	
		
		log.info( coding.getComputer().toString());
		// 객체를 메모리에 올리지 않았기 때문에 호출이 안된다.
	}
	

}
