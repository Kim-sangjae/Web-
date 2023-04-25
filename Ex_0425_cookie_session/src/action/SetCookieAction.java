package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieAction
 */
@WebServlet("/cookie.do")
public class SetCookieAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("param", "asdasd");
		
		// 쿠키 유효시간 설정
		cookie.setMaxAge(60*60*24*7);
//		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		Cookie[] cookies = request.getCookies();
		for(Cookie cook : cookies) {
			System.out.println("쿠키이름: " + cook.getName());
			System.out.println("쿠키내용: " + cook.getValue());
			System.out.println("------------------------------");
		}
		
		
		response.sendRedirect("ex01_Cookie.jsp");
	}

}
