package com.korea.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.korea.rest.dao.OrderDAO;
import com.korea.rest.dao.ProductDAO;
import com.korea.rest.vo.OrderDTO;
import com.korea.rest.vo.OrderVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderDAO orderDAO;
	private final ProductDAO productDAO;
	
	
	// 주문하기 동시에 재고 수정
	public void order(OrderVO orderVO) {
		
		productDAO.setProductStock(orderVO);
		orderDAO.save(orderVO);
		
	}
	
	public List<OrderDTO> getList (String sort) {
		
		List<OrderDTO> list = orderDAO.selectAll(sort);
		
		return list;
		
	}
	
	

}
