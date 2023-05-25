package dao;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class MemberDAO {
	
	
	SqlSession sqlSession;
	
	public MemberDAO(SqlSession sqlSession) {

		this.sqlSession = sqlSession;
	}
	
	
	// 로그인 구현
	public MemberVO loginCheck(String id) {
		
		MemberVO vo = sqlSession.selectOne("m.loginCheck",id);
		
		return vo;
		
	}
	
	// 중복 체크
	public int check_id(String id) {
		int res = sqlSession.selectOne("m.check_id" , id);
		
		return res;
	}
	
	
	
	
	
	// 회원가입
	public int insert(MemberVO vo) {
		
		int res = sqlSession.insert("m.member_insert",vo);
		
		return res;
		
	}
	
	
	
	

}
