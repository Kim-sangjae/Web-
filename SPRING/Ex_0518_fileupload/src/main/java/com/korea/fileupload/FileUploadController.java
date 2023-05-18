package com.korea.fileupload;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;

@Controller
public class FileUploadController {
	
	
	@Autowired
	HttpServletRequest request;
	
	// seesion,request와 같은 jsp,servlet에서 제공을 해주는 객체이기 때문에 스프링에서도 지원을한다
	// jsp 에서 Servlet을 지원해주는 객체를 따로 생성하는 과정없이 자동으로 만들어주는 어노테이션
	
	
	static final String VIEW_PATH = "/WEB-INF/views/";
	
	
	
	@RequestMapping(value= {"/","insert_form.do"})
	public String insert_form() {
		
		return VIEW_PATH + "insert_form.jsp";
	}
	
	
	
	
	
	
	
	
	@RequestMapping("upload.do")
	public String upload(PhotoVO vo , Model model) {
		
		
		String webPath = "resources/upload";
		String savePath = request.getServletContext().getRealPath(webPath);
		
		System.out.println(savePath);
		
		
		
		
		MultipartFile photo = vo.getPhoto();
		String filename = "no_file";
		
		
		
		if(!photo.isEmpty()) {
			filename = photo.getOriginalFilename();
			
			File saveFile = new File(savePath,filename);
			
			if(!saveFile.exists()) { // 경로가 없다면
				// 폴더를 만들어라
				saveFile.mkdirs();
			} else {
				// 동일한 이름의 파일일 경우 업로드한 시간을 붙여서 중복되는것을 방지
				
				//자바가 만들어진 1970년부터 2023년 현재까지의 시간을 1000분의 1초로 저장
				long time = System.currentTimeMillis();
				
				filename = String.format("%d_%s", time,filename);
				saveFile = new File(savePath,filename);
						
				
			}
			
			
			
			try {
				photo.transferTo(saveFile);
			}catch (Exception e) {
				
			}
			
			
			
		}
		
		// 얻어온 파일정보에서 파일이름을 뽑아서 vo에 넣어주기
		vo.setFilename(filename);
		
		
		
		request.setAttribute("vo", vo);
		
		
		return VIEW_PATH + "insert_result.jsp";
	}
	
	
	
	
	

}
