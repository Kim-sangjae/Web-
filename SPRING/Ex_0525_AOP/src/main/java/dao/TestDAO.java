package dao;

import org.apache.ibatis.session.SqlSession;

public class TestDAO {
	
	SqlSession sqlSession;
	
	
	public TestDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	
	public void test() {
		System.out.println("-- call TestDAO.test() ---");
		try {
			//test()메서드의 수행 시간을 Advice에서 캐치할 예정
			//메서드 한개를 호출하는 시간은 사실상 0초에 가깝기 때문에,
			//임의로 딜레이를 주기위해서 sleep을 추가했다.
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
