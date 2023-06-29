package com.korea.rest.service;

import java.util.List;

import com.korea.rest.vo.ProductVO;

public interface ProductService {
	
	// 상품조회
	public List<ProductVO> getList();
	// 상품추가
	public void register(ProductVO productVO);

}
