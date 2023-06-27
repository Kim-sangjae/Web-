package com.korea.tier.service;

import java.util.List;

import com.korea.tier.vo.ProductVO;

public interface ProductService {
	
	// 상품조회
	public List<ProductVO> getList();
	// 상품추가
	public void register(ProductVO productVO);

}
