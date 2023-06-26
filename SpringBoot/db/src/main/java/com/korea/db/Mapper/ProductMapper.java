package com.korea.db.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.korea.db.vo.ProductVO;

@Mapper
public interface ProductMapper {
	
	// 상품 추가
	public void insert(ProductVO productVO);
	

}
