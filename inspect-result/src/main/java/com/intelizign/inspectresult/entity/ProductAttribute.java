package com.intelizign.inspectresult.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "product_attribute_inspect_result")
public class ProductAttribute {
	@Id
	@Column(name = "event_id", nullable = false)
	private String eventId;
	@Column(name = "productNumber", nullable = false)
	private String productNumber;
	@Column(name = "attribute", nullable = true)
	private String attribute;
	@Column(name = "testStation", nullable = true)
	private String testStation;
	@Column(name = "result", nullable = true)
	private Boolean result;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "event_id", nullable = true)
	@ToString.Exclude
	private EventBody eventBody;
}
