package com.korea.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	public static final String VIEW_PATH = "/WEB-INF/views/test/";
	
	public TestController() {
		System.out.println("---TestController의 기본생성자 생성----");
	}
	
	@RequestMapping("/test.do")
	public String test() {
		return VIEW_PATH+"test.jsp";
	}

}
