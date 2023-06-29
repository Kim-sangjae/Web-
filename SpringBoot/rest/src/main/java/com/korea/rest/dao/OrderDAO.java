package com.korea.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.korea.rest.mapper.OrderMapper;
import com.korea.rest.vo.OrderDTO;
import com.korea.rest.vo.OrderVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderDAO {
	
	private final OrderMapper orderMapper;
	
	
	//주문하기
	public void save(OrderVO orderVO) {
		
		orderMapper.insert(orderVO);
	}
	
	public List<OrderDTO> selectAll(String sort){
		
		List<OrderDTO> list =  orderMapper.selectAll(sort);
		
		return list;
	}

}
