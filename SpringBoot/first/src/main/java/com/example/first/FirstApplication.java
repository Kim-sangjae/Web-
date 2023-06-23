package com.example.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@Configuration: 스프링한테 현재 클래스는 설정파일이다 라고 알려주는 어노테이션
//@ComponentScan : 자동으로 컴포넌트 객체를 탐색해서 객체로 만들어주는 어노테이션
//@EnableAutoConfiguration : 스프링의 다양한 설정들이 자동으로 구성되고 완료됨
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

}
