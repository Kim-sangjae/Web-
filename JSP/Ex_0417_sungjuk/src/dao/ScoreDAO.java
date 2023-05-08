package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;

import service.DBService;
import vo.ScoreVO;

public class ScoreDAO {
	
	
	
	static ScoreDAO single = null;

	public static ScoreDAO getInstance() {
		
		if (single == null)
			single = new ScoreDAO();
	
		return single;
	}
	
	
	
	
	public List<ScoreVO> selectList() {

		List<ScoreVO> list = new ArrayList<ScoreVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM SUNGTB_VIEW";

		try {
			//1.Connection얻어온다
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체정보를 얻어오기
			pstmt = conn.prepareStatement(sql);
			//3.결과행 처리객체 얻어오기
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ScoreVO vo = new ScoreVO();
				//현재레코드값=>Vo저장
				
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				
				vo.setTotal(rs.getInt("total"));
				vo.setRank(rs.getInt("rank"));
				vo.setAvgr(rs.getFloat("avgr"));
				

				//ArrayList추가
				list.add(vo);
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}
	
	
	
	
	// 추가하기
	
	public int insert(ScoreVO vo) {
		
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into sungtb values(seq_sungtb_no.nextVal,?,?,?,?)";

		try {
			//1.Connection획득
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 채우기
			pstmt.setString(1,vo.getName());
			pstmt.setInt(2,vo.getKor());
			pstmt.setInt(3,vo.getEng());
			pstmt.setInt(4,vo.getMat());
			
			//4.DB로 전송(res:처리된행수)
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
	
	// 삭제하기
	
	public int delete(int no) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from sungtb where no=?";

		try {
			//1.Connection획득
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 채우기
			pstmt.setInt(1, no);
			//4.DB로 전송(res:처리된행수)
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
	
	//수정하기
	
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		
		int res =0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE sungtb SET NAME=?,KOR=?,ENG=?,MAT=? WHERE NO=?";

		try {
			//1.Connection획득
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getNo());
			
			
			res = pstmt.executeUpdate();
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	

}
