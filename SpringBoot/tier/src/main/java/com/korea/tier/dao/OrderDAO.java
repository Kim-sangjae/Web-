package com.korea.tier.dao;

import org.springframework.stereotype.Repository;

import com.korea.tier.mapper.OrderMapper;
import com.korea.tier.vo.OrderVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderDAO {
	
	private final OrderMapper orderMapper;
	
	
	//주문하기
	public void save(OrderVO orderVO) {
		
		orderMapper.insert(orderVO);
	}

}
