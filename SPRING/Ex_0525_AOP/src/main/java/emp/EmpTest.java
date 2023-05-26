package emp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Context_5_AOP.class);
		
		EmpManager manager = (EmpManager)context.getBean("empManager");
		
		manager.setEmp(new Emp("1","홍길동"));
		manager.setEmp(new Emp("2","홍길동2"));
		
		
		List<Emp> emps = manager.getAllEmps();
		
		System.out.println(emps);
		
		
		
		
		
	}
}
