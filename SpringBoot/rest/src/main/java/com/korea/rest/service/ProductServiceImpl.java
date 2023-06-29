package com.korea.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.rest.dao.ProductDAO;
import com.korea.rest.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductDAO productDAO;
	
	
	@Override
	public List<ProductVO> getList() {
		
		return productDAO.findAll();
	}

	@Override
	public void register(ProductVO productVO) {
		
		productDAO.save(productVO);
	}
	

}
