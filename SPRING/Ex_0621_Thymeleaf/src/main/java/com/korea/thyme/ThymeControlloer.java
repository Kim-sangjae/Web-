package com.korea.thyme;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vo.MemberVO;

@Controller
public class ThymeControlloer {
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("data" ,"타임리프");
		return "ex01";
	}
	
	
	@RequestMapping("ex02")
	public String ex02(Model model) {
		MemberVO vo = new MemberVO();
		vo.setMemNo(1);
		vo.setMemId("user01");
		vo.setMemNm("홍길동");
		vo.setRegDt(LocalDateTime.now());
		
		model.addAttribute("vo",vo);
		
		return "ex02";
		
	}
	
}
