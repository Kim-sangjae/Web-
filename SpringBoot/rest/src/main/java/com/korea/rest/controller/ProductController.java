package com.korea.rest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.korea.rest.service.ProductService;
import com.korea.rest.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {

	private final ProductService productService;
	
	@GetMapping("list")
	public String list(Model model) {
		List<ProductVO> list = productService.getList();
		model.addAttribute("productForm",new ProductVO());
		model.addAttribute("list",list);
		return "product-list";
	}
	
	@PostMapping("new")
	@ResponseBody
	//@RequestBody : ProductVO에 있는 필드들이 JSON의 키값으로 잡힌다.
	public void register(@RequestBody ProductVO productVO) {
		productService.register(productVO);
	}
	
	@GetMapping("{productId}")
	@ResponseBody
	public ProductVO getProduct(@PathVariable("productId") int productId) {
		return productService.getProduct(productId);
	}
	
}








