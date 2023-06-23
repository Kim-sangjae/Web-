package com.example.first.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("desktop") @Primary //참조되는 객체가 여러개일때는 기본값으로 이 클래스를 기본값으로 불러오게 한다.
public class DeskTop implements Computer{
	
	
	@Override
	public String getScreenWidth() {
		// TODO Auto-generated method stub
		return "1920";
	}

}
