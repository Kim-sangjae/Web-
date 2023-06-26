package com.korea.db.Mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper {
	//mapper.xml 파일에 있는 쿼리문을 호출하기위한 인터페이스
	//DAO 대신 @Mapper 어노테이션을 사용한다 (mybatis 3.0 이상 부터 가능)
	//@Mapper 어노테이션을 사용하면 Bean으로 등록되며 Controller에서 의존성 주입으로 사용할 수 있다.
	//추상 메서드의 이름은 Mapper파일의 id 와 맞춰야 한다.
	public String getTime();
}
