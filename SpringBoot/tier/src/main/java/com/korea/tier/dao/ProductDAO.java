package com.korea.tier.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.korea.tier.mapper.ProductMapper;
import com.korea.tier.vo.OrderVO;
import com.korea.tier.vo.ProductVO;

import lombok.RequiredArgsConstructor;


@Repository 
@RequiredArgsConstructor
public class ProductDAO {
	
	private final ProductMapper productMapper;
	
	
	// 상품조회
	public List<ProductVO> findAll(){
		
		return productMapper.select();		
	}
	
	
	// 상품 추가
	public void save(ProductVO productVO) {
		
		productMapper.insert(productVO);
	}
	
	
	public void setProductStock(OrderVO orderVO) {
		
		productMapper.updateStock(orderVO);
	}
	
	
	

}
