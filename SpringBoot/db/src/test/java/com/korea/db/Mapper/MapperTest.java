package com.korea.db.Mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.java.Log;

@SpringBootTest
@Log
public class MapperTest {
	
	@Autowired
	private TimeMapper timeMapper;
	
	
	@Test
	public void getTimeTest() {
		
		log.info("timeLog : " + timeMapper.getTime());
		
	}
	
	

}
