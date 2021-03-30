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
public class EventBody {
	private String eventId;
	// payload
	private String stationType;
	private ProductAttribute productAttribute;
}
