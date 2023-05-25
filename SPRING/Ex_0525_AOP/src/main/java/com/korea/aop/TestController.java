package com.korea.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.TestDAO;

@Controller
public class TestController {

	TestDAO test_dao;
	
	public TestController(TestDAO testDAO) {
		this.test_dao = testDAO;
	}
	
	public static final String VIEW_PATH = "/WEB-INF/views/";
	
	
	@RequestMapping(value= {"/","test.do"})
	public String test() {
		test_dao.test();
		return VIEW_PATH + "test.jsp";
	}
	
}
