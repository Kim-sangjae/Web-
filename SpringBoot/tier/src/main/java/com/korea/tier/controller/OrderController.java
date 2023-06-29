package com.korea.tier.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.korea.tier.service.OrderService;
import com.korea.tier.vo.OrderDTO;
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
		
		return new RedirectView("/order/list");
	}
	
	
	@GetMapping("list")
	//@RequestParam(required = false) : 해당파라미터에 null 값이 들어와도 허용하게해준다
	public String list(Model model, @RequestParam(required = false)String sort) {
		
		// 처음 들어갈땐 sort의 정보가 없다 때문에 null 값일때 recent로 고정해줘야 recent 기준으로 정렬이 된다.
		if(sort == null) {
			sort ="recent";
		}
		
		model.addAttribute("sort",sort);
		
		List<OrderDTO> list = orderService.getList(sort);
		model.addAttribute("orders" , list);
		
		return "order/order-list";
	}
	
	
	
	
}
