package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Advice {
	
	// 공통 기능이 담기는 클래스
	long start; //시작시간을 담을 변수
	
	@Pointcut("execution(* dao.*DAO.*(..))") // 실제 advice가 적용될 지점 - dao패키지안에 DAO라는 모든 파일과 모든메서드(..)-> 파라미터갯수
	public void myPoint() {}
	
	
	@Before("myPoint()") // 모든 메서드 실행전 적용
	public void before(JoinPoint jp) {
		//before()가 호출되었을때의 시간
		start=System.currentTimeMillis();
		
		// getSignature() 타겟으로 삼고있는 메서드의 정보를 가져온다
		System.out.println("--before: " + jp.getSignature()); 
	}
	
	@After("myPoint()")
	public void after(JoinPoint jp) {
		
		long end = System.currentTimeMillis();
		
		 // toLongString() 타겟 메서드를 완전한게 표현한 메서드( 메서드의 리턴타입 , 파라미터 타입까지 표기 )
		System.out.println("--after: " + jp.toLongString());
		System.out.printf("[수행시간] : %d(ms)\n",end - start);
	}
	
	

}
