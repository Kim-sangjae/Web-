package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDAO;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoInsert_action
 */
@WebServlet("/insert.do")
public class PhotoInsert_action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// insert.do?title=aaaa&pwd=1111&photo=%^&^&
		
		String web_path ="/upload/";
		
		ServletContext application = request.getServletContext();
		String path = application.getRealPath(web_path);
		
		
		int max_size = 1024*1024*100;
		
		MultipartRequest mr = new MultipartRequest(request,
													path,
													max_size,
													"utf-8",
													new DefaultFileRenamePolicy());
		
		
		String filename ="";
		
		File f = mr.getFile("photo");
		
		if(f != null) {
			
			filename = f.getName();
			
		}
		
		
		// 파일 형식 이외의 일반 파라미터 수신하기
		String title = mr.getParameter("title");
		String pwd = mr.getParameter("pwd");
		String ip = request.getRemoteAddr(); // ip 얻어오기
		
		
		
		PhotoVo vo = new PhotoVo();
		vo.setTitle(title);
		vo.setPwd(pwd);
		vo.setIp(ip);
		vo.setFilename(filename);
		
		
		int res = PhotoDAO.getInstance().insert(vo);
		
		if(res >= 1) {
			response.sendRedirect("list.do");
		}
		
		
		
		
		
		
		
	}

	

}
