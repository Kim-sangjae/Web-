package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class loginAction
 */
@WebServlet("/login.do")
public class loginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//login.do?id=aaa&aaa
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(pw);
		
		MemberVO vo = MemberDAO.getInstance().selectOne(id);
		
		String param = "";
		String resultStr = "";
		
		//vo가 null이 넘어오면 '아이디가 존재하지 않는다'
		
		if(vo == null) {
			param = "no_id";
			resultStr = String.format("[{'param':'%s'}]", param);
			response.getWriter().print(resultStr);
			
			return;
		}
		
		// 내가 입력한 비밀번호와 DB에서 넘어온 비밀번호가 같은지 확인
		
		if(!vo.getPw().equals(pw)) {
			param = "no_pw";
			resultStr = String.format("[{'param':'%s'}]", param);
			response.getWriter().print(resultStr);
			return;
		}
		
		// 아이디와 비밀번호에 문제가 없다면 세션에 바인딩한다.
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		session.setAttribute("vo", vo);
		
		
		
		
		// 로그인 성공
		param = "clear";
		resultStr = String.format("[{'param':'%s'}]", param);
		response.getWriter().print(resultStr);
		
		
	}

}
