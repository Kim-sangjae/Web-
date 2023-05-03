package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import vo.BoardVO;

/**
 * Servlet implementation class BoardListAction
 */
@WebServlet("/board_list.do")
public class BoardListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		request.setCharacterEncoding("utf-8");
		
		//전체 게시글 조회하기
		List<BoardVO> list = BoardDAO.getInstance().select();
		
		//조회수를 위해 저장해뒀던 "show"라는 정보를 세션에서 제거
		HttpSession session = request.getSession();
		request.getSession().removeAttribute("show");
		
		
		//바인딩
		request.setAttribute("list", list);
		
		//포워딩
		RequestDispatcher disp = request.getRequestDispatcher("board_list.jsp");
		disp.forward(request, response);
		
		
		
	}

}
