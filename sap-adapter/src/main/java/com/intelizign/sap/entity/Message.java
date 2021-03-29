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
@ToString(callSuper = true, includeFieldNames = true)
public class Message {
private String responseCode;
private String responesMessage;
private String eventId;
}
