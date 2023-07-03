package com.korea.rest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.rest.vo.OrderVO;
import com.korea.rest.vo.ProductVO;

@Mapper
public interface ProductMapper {

	//상품 추가
	public void insert(ProductVO productVO);
	
	//상품 조회
	public List<ProductVO> selectAll();
	
	//상품 재고 수정
	public void updateStock(OrderVO orderVO);
	
	//주문 조회
	public ProductVO select(int productId);
}
