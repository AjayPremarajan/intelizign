package com.intelizign.sendemail.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true, includeFieldNames = true)
public class ProductAttribute {
	private String productNumber;
	private String attribute;
	private String testStation;
	private Boolean result;
}
