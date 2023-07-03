package com.korea.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.rest.service.OrderService;
import com.korea.rest.vo.OrderDTO;
import com.korea.rest.vo.OrderVO;

import lombok.RequiredArgsConstructor;

@RestController
//@Controller, @ResponseBody 어노테이션이 합쳐진 형태
@RequiredArgsConstructor
@RequestMapping("/order/*")
public class OrderController {

	private final OrderService orderService;
	
	
	@GetMapping("list/{sort}")
	//@PathVariable : 경로 변수를 메서드의 매개변수로 바인딩하는데 사용
	public List<OrderDTO> list(@PathVariable("sort") String sort){
		return orderService.getList(sort);
	}
	
	//주문하기
	@PostMapping("write")
	public void register(@RequestBody OrderVO orderVO) {
		orderService.order(orderVO);
	}
	
	
	
	
	
	
	
	
	
}
