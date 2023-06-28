package com.korea.tier.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.korea.tier.vo.OrderVO;

@Mapper
public interface OrderMapper {
	
	
	// 주문하기
	public void insert(OrderVO orderVO);
	

}
