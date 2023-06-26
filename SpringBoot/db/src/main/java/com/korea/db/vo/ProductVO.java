package com.korea.db.vo;

import lombok.Data;

@Data
public class ProductVO {
	
	
	private int productId;
	private String productName;
	private int productStock;
	private int productPrice;
	private String registerDate;
	private String updateDate;

}
