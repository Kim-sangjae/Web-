package vo;

public class PersonVo {
	// VO ( Value Object ) : 한개 또는 그이상의 속성들을 묶은 객체를 의미한다.
	// DB를 연동하고 사람의 정보를 db에서 가져왔다고 가정하면 
	// 결과적으로 jsp부분의 body부분에서 출력을하게된다.
	
	private String name;
	private int age;
	private String tel;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	

}
