package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import util.Common;
import util.Paging;
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
		
		int nowPage = 1;
		String page = request.getParameter("page");
		
		
		if(page != null && !page.isEmpty()) {
			nowPage = Integer.parseInt(page);
		}
		
		int start = (nowPage -1)*Common.Board.BLOCKLIST+1;
		int end = start+Common.Board.BLOCKLIST-1;
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		
		
		
		//전체 게시글 조회하기
		List<BoardVO> list = BoardDAO.getInstance().select(map);
		
		//전체 게시글 갯수 조회
		int rowTotal = BoardDAO.getInstance().getRowTotal();
		
		//페이지 메뉴 생성하기
		String pageMenu = Paging.getPaging("board_list.do", 
												nowPage, // 현재 페이지 번호 
												rowTotal, // 전체 게시물 개수
												Common.Board.BLOCKLIST, // 한페이지에 보여질 게시물 수
												Common.Board.BLOCKPAGE// 페이지 수 
												);
		
		
		//조회수를 위해 저장해뒀던 "show"라는 정보를 세션에서 제거
		HttpSession session = request.getSession();
		request.getSession().removeAttribute("show");
		
		
		//바인딩
		request.setAttribute("list", list);
		request.setAttribute("pageMenu", pageMenu);
		
		//포워딩
		RequestDispatcher disp = request.getRequestDispatcher("board_list.jsp");
		disp.forward(request, response);
		
		
		
	}

}
