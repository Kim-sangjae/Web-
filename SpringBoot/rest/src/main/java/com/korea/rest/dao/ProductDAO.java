package com.korea.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.korea.rest.mapper.ProductMapper;
import com.korea.rest.vo.OrderVO;
import com.korea.rest.vo.ProductVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductDAO {

	private final ProductMapper productMapper;
	
	//상품 조회
	public List<ProductVO> findAll(){
		return productMapper.selectAll();
	}
	
	//상품 추가
	public void save(ProductVO productVO) {
		productMapper.insert(productVO);
	}
	
	//상품재고 수정
	public void setProductStock(OrderVO orderVO) {
		productMapper.updateStock(orderVO);
	}
	
	//주문 조회
	public ProductVO getProduct(int productId) {
		return productMapper.select(productId);
	}
	
	
	
	
	
	
	
}
