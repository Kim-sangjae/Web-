package com.korea.tier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.korea.tier.service.OrderService;
import com.korea.tier.vo.OrderVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("order/*")
public class OrderController {
	
	private final OrderService orderService;
	
	
//	@GetMapping("order") // localhost:10000/order/order
//	public String order() {
//		OrderVO vo = new OrderVO();
//		vo.setProductId(2);
//		vo.setProductCount(10);
//		
//		orderService.order(vo);
//		return null;
//		
//	}
	
	
	@GetMapping("done")
	public RedirectView order(OrderVO orderVO) {
		
		System.out.println(orderVO.getProductCount());
		
		orderService.order(orderVO);
		
		return new RedirectView("/product/list");
	}
	
	
	
	
}
