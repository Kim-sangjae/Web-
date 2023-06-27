package com.korea.tier.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.korea.tier.vo.ProductVO;

@Mapper
public interface ProductMapper {

	//상품 추가
	public void insert(ProductVO productVO);
	
	//상품리스트
	public List<ProductVO> select();
}
