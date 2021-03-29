package com.intelizign.inspectresult.entity;

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
public class EventMember {
	private String source;
	private String destination;
	private String eventId;
	private EventBody eventBody;
}
