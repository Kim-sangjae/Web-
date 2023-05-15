package com.korea.test_di;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardServiceImpl;

@Controller
public class BoardController {
	
	BoardServiceImpl service;
	
	public void setService(BoardServiceImpl service) {
		this.service = service;
	}
	
	@RequestMapping("/board/list.do")
	public String list(Model model) {
		List<Object> list = service.selectList();
		
		model.addAttribute("list",list);
		
		return "board_list";
	}

}
