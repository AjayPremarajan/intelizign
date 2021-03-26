package com.intelizign.sap.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventMember {
//Indicate the information about consumer of the message
private String scope;
//A ID generated to keep track of the request
private String event_id;
//Indicate the information about the producer of the message
private String source;
//payload
private ProductAttribute productAttribute;
}
