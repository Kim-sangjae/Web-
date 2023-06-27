package com.korea.tier.vo;

import lombok.Data;

@Data
public class OrderVO {
	
		private int orderId;
		private int productId;
		private int productCount;
		private String orderDate;

}
