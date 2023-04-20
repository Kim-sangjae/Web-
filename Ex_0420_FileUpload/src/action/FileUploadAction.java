package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadAction
 */
// @WebServlet("/Upload.do") : url매핑 : jsp등 에서 현재 서블릿을 요청할 수 있는 식별자를 지정하는 영역
@WebServlet("/Upload.do")
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// service() : 매핑이 호출되면 가장 먼저 실행되는 메서드
		
//		System.out.println("서블릿 접속됨");
		
		//post로 보낸 파일 깨지지않게 인코딩
		request.setCharacterEncoding("utf-8");
		
		//파일 업로드
		String path ="c:/upload";
		int max_size = 1024*1024*100; // 100mb
		
		// 파일을 포함한 파라미터를 수신하기 위한 객체
		MultipartRequest mr = new MultipartRequest(request,//request 정보를 위임
													path, // 업로드 경로
													max_size, // 최대 업로드 용량
													"utf-8", // 수신시 인코딩 타입
													new DefaultFileRenamePolicy()//중복된 파일 명을 알아서 변경
													);
		
		String filename = "no_file";
		
		//업로드가 완료된 파일의 정보 받아오기
		File f = mr.getFile("photo");
		
		if(f != null) {
			filename = f.getName(); // 업로드된 파일의 이름을 가져올 수 있다.
		}
		
		//파일 외의 일반 파라미터
		String title = mr.getParameter("title");
		
		
		//바인딩
		request.setAttribute("title",title);
		
		request.setAttribute("filename", filename);
		
		
	
		//포워딩 
		//바인딩해놓은 정보를 어떤 페이지에서 가져다가 사용할 것인지를 지정
		RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
		disp.forward(request, response);
		
	}


}
