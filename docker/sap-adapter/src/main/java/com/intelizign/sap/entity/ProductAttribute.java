package com.intelizign.sap.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductAttribute {
	private String eventId;
	private String productNumber;
	private String attribute;
	private String testStation;
	private Boolean result;
}
