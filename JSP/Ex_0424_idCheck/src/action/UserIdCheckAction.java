package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import vo.UserVO;

/**
 * Servlet implementation class UserIdCheckAction
 */
@WebServlet("/check_id.do")
public class UserIdCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// check_id.do?id=asdasd
		
		String id = request.getParameter("id");
		
		UserVO vo = UserDAO.getInstance().selectOne(id);
		
		String res = "no";
		
		if(vo == null) { // 넘어온 vo가 null이면  가입이 가능하다
			res = "yes";
		}
		
		String result = String.format("[{'res':'%s'}]", res);
		response.getWriter().print(result); // 콜백메서드로 복귀
	
	
	}

}
