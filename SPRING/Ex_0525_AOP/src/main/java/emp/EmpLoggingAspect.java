package emp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmpLoggingAspect {
	
	
	@Before("execution(* emp.EmpManager.get*(..) )")
	public void before(JoinPoint jp) {
		System.out.println(">>> beforee advice : " + jp.getSignature().getName());
	}
	
	
	//@Around : 핵식메서드가 실행되기전 , 리턴된 후 around메서드가 적용된다.
	@Around("execution(* emp.EmpManager.get*(..) )")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(">>> around advice[전] : " +pjp.getSignature().getName());
		
		Object o = pjp.proceed();
		
		System.out.println(">>> around advice[후] : " +pjp.getSignature().getName());
		
		return o;
	}
	
	
	
	//@AfterReturning 포인트 컷 메서드가 정상종료되고나면 후에 적용된다.
	@AfterReturning(pointcut= "execution(* emp.EmpManager.*(..) )", returning = "retVal")
	public void afterReturning(JoinPoint jp , Object retVal) {
		System.out.println(">>> afterReturning advice : " + jp.getSignature().getName());
		System.out.println(">>> afterReturning advice return value is : " + retVal);
	}
	
	
	//@AfterThrowing : 포인트컷 메서드에서 예외가 발생할 때 적용된다
	@AfterThrowing(pointcut= "execution(* emp.EmpManager.*(..) )", throwing = "exception")
	public void afterThrowing(Exception exception) {
		System.out.println(">>> afeterThrowing advice : " + exception);
	}
	
	
	
	
	

}
