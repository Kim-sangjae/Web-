package com.korea.tier.vo;

import lombok.Data;

@Data
public class ProductVO {
//	PRODUCT_ID NUMBER PRIMARY KEY,
//    PRODUCT_NAME VARCHAR2(500) NOT NULL,
//    PRODUCT_STOCK NUMBER DEFAULT 0,
//    PRODUCT_PRICE NUMBER DEFAULT 0,
//    REGISTER_DATE DATE DEFAULT SYSDATE,
//    UPDATE_DATE DATE DEFAULT SYSDATE
	
	private int productId;
	private String productName;
	private int productStock;
	private int productPrice;
	private String registerDate;
	private String updateDate;
}
