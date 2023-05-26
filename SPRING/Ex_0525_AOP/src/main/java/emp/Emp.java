package emp;

import lombok.Data;
import lombok.ToString;

@Data
public class Emp {
	
	
	private String empno;
	private String ename;
	
	
	
	public Emp(String empno, String ename) {
		this.empno = empno;
		this.ename = ename;
	}
	
	
	public String toString() {
		return "Emp [empno="+empno+", ename="+ename+"]";
	}
	
	
	
	
	

}
