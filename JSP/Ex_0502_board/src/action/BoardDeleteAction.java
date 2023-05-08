package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import vo.BoardVO;

/**
 * Servlet implementation class BoardDeleteAction
 */
@WebServlet("/del.do")
public class BoardDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		
		BoardDAO  dao = BoardDAO.getInstance();
		
		BoardVO baseVO = dao.selectOne(idx);
		
		baseVO.setSubject("삭제된게시물");
		baseVO.setName("unknown");
		
		int res = dao.del_update(baseVO);
		
		if(res > 0) {
			response.getWriter().print("[{'param':'yes'}]");
		} else {
			
			response.getWriter().print("[{'param':'no'}]");
		}
		
		
	}

}
