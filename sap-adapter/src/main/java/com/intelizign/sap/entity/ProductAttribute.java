package com.intelizign.sap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttribute {
	private String productNumber;
	private String attribute;
	private String testStation;
	private Boolean result;
}
