package com.korea.tier.vo;

import lombok.Data;

@Data
public class OrderDTO {

	
	// product
	private int productId;
	private String productName;
	private int productStock;
	private int productPrice;
	private String registerDate;
	private String updateDate;
	
	
	// order
	private int orderId;
	private int productCount;
	private String orderDate;
	private int orderPrice;

	

}
