package com.example.first.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//@Component
//@NoArgsConstructor // 기본생성자
//@AllArgsConstructor // 전체 필드를 요소로 갖는 생성자 생성
@RequiredArgsConstructor // final이 붙어있거나 , @NonNull 어노테이션이 붙어있는 필드나 , 객체를 생성자의 파라미터로 넣는다
public class Coding {
	
//	@Autowired
//	private Computer computer; // 필드주입 , 하지만 필드주입보다는 생성자 주입이 더 권장된다.
	
	// 필드 주입시 편하게 주입할 수 있으나 순환참조(무한루프)시 오류가 발생하지 않기 때문에 StackOverflow가 발생한다
	// 순환참조 : A클래스가 B클래스의 Bean을 주입받고 , B클래스가 A클래스의 Bean을 주입받는 상황 ( 서로 주입받는다 )
	
	// 생성자 주입은 순환참조시 컴파일러가 인지가능 하고 , 오류를 발생시킨다
	// 초기화 생성자를 사용하면 해당 객체에 final 키워드를 붙힐 수 있다.
	// final을 사용하면 다른곳에서 변경이 불가능하다.
	// 생성자 주입시 의존성 주입이 되지않으면 객체가 생성되지 않으므로 NullPointerException을 예방할 수 있다.
	
	// 부트는 생성자 주입을 기본적으로 권장한다.
	
	
	private final Computer computer;
	
//	@Autowired 부트에서는 생략이 가능하고 대신 final을 붙인다
//	public Coding(Computer computer) {
//		this.computer = computer;
//	}
	
	
	
	
}
