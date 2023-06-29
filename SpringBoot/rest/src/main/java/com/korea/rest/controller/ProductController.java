package com.korea.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.korea.rest.service.ProductService;
import com.korea.rest.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/product/*")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;
	
	
	@GetMapping("list")
	public String productLIst(Model model){
		
		List<ProductVO> list = productService.getList();
		model.addAttribute("productForm", new ProductVO());
		model.addAttribute("list",list);
		
		return "/product/product-list";
	}

}
