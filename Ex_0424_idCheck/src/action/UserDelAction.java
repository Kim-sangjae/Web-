package action;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDAO;

/**
 * Servlet implementation class UserDelAction
 */
@WebServlet("/user_del.do")
public class UserDelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idx = Integer.parseInt(request.getParameter("idx"));
		int res = UserDAO.getInstance().delete(idx);
		
		
		
		String param = "no";
		
		if(res>0) {
			param = "yes";
		}
		
		
		//결과값인 param을 json 구조로 포장
		String result = String.format("[{'param' : '%s'}]", param);
		
		
		response.getWriter().print(result);
		
	
	}

}
