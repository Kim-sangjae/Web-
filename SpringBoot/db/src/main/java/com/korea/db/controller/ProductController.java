package com.korea.db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.korea.db.Mapper.ProductMapper;
import com.korea.db.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductMapper productMapper;
	
	
	
	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("productVO", new ProductVO());
		
		return "product-register";
	}
	
	
	

}
